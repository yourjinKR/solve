class Solution {
    static Map<String, IntBinaryOperator> calculator = Map.of(
            "+", (a, b) -> b + a,
            "-", (a, b) -> b - a,
            "*", (a, b) -> b * a,
            "/", (a, b) -> b / a
    );

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            IntBinaryOperator oper = calculator.get(token);
            if (oper == null) {
                stack.add(Integer.parseInt(token));
            } else {
                stack.add(oper.applyAsInt(stack.pop(), stack.pop()));
            }
        }
        return stack.pop();
    }
}