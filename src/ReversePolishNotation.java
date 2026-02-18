
public class ReversePolishNotation {

    public static int evaluatePostfix(String input) {
        Stack s = new Stack();
        String numFilter = "-+*/^";
        char[] inList = input.toCharArray();
        int numCount = 0;
        int operatorCount = 0;

        //Check for invalid input first:
        for (char c: inList){
            if (numFilter.indexOf(c) == -1){
                numCount ++;
            }
            else{
                operatorCount ++;
            }
        }
        if ((operatorCount + 1) != numCount){
            throw new IllegalArgumentException("Postfix string is invalid.");
        }



        for (char c : inList) {
            if (numFilter.indexOf(c) == -1) { // If c is actually a number
                s.push(Character.toString(c));

            } else {
                if (c == '-') {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 - num2));
                } else if (c == '+') {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 + num2));
                } else if (c == '*') {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 * num2));
                } else if (c == '/') {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 / num2));
                } else if (c == '^') {
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString((int) Math.pow(num1, num2)));
                }
            }
        }
        return Integer.parseInt(s.peek());
    }

    public static String infixToPostfix(String input) {
        Stack s = new Stack();

        String name = "hello";
        return name;
    }

}

