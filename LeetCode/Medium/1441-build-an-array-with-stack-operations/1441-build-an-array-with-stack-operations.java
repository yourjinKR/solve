class Solution {
    static String PUSH = "Push";
    static String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        int[] ans = new int[target.length];
        List<String> result = new ArrayList<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            result.add(PUSH);
            ans[index] = i;
            if (ans[index] != target[index]) {
                result.add(POP);
                ans[index] = 0;
            } else {
                index++;
            }
            if (Arrays.equals(ans, target)) {
                break;
            }
        }

        return result;
    }
}