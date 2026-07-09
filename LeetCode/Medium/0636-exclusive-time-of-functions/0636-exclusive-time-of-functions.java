class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");

            int functionId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    int currentFunction = stack.peek();
                    answer[currentFunction] += timestamp - prevTime;
                }

                stack.push(functionId);
                prevTime = timestamp;
            } else {
                int currentFunction = stack.pop();
                answer[currentFunction] += timestamp - prevTime + 1;

                prevTime = timestamp + 1;
            }
        }

        return answer;
    }
}