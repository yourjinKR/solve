class Solution {
    static String PLUS = "+";
    static String MINUS = "-";
    static String MULTIPLY = "*";
    static String DIVIDE = "/";
    static Set<String> OPERATION = Set.of(PLUS, MINUS, MULTIPLY, DIVIDE);
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (OPERATION.contains(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                int result = 0;
                if (token.equals(PLUS)) {
                    result = first + second;
                } else if (token.equals(MINUS)) {
                    result = first - second;
                } else if (token.equals(MULTIPLY)) {
                    result = first * second;
                } else if (token.equals(DIVIDE)) {
                    result = first / second;
                }
                stack.add(result);
            } else {
                int num = Integer.parseInt(token);
                stack.add(num);
            }
        }

        return stack.pop();
    }
}