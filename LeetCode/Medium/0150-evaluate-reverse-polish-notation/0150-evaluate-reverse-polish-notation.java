class Solution {
    int idx;
    public int evalRPN(String[] tokens) {
        idx = tokens.length -1;
        return help(tokens);
    }
    public int help(String[] s){
        return switch(s[idx--]){
            case "+" -> help(s) + help(s);
            case "*" -> help(s) * help(s);

            case "-" ->{
                int a = help(s);
                yield help(s) - a;
            }

            case "/" ->{
                int a = help(s);
                yield help(s)/a;
            }
            default -> Integer.parseInt(s[idx+1]);
        };
    }
}