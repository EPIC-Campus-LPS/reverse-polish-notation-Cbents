
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

        String numFilter = "-+*/^";
        char[] inList = input.toCharArray();
        int numCount = 0;
        int operatorCount = 0;
        String output = "";



        for (char c : inList) {
            //space
            if (c == ' ') {
                continue;
            }

            // operand
            else if (Character.isLetterOrDigit(c)) {
                output += c;
            }
            // parenthesis special case
            else if (c == '(') {
                s.push("(");
            }

            else if (c == ')') {
                while (!s.isEmpty() && !s.peek().equals("(")) {
                    output += s.pop();
                }
                s.pop(); // remove the (
            }

            // operator
            else if (isOperator(c)) {

                while (!s.isEmpty()
                        && isOperator(s.peek().charAt(0))
                        && (
                        precedence(s.peek().charAt(0)) > precedence(c)
                                || (precedence(s.peek().charAt(0)) == precedence(c) && c != '^')
                )
                ) {

                    output += s.pop();
                }

                s.push(Character.toString(c));
            }
        }

        while (!s.isEmpty()) {
            output += s.pop();
        }

        return output;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return -1;
    }
    }



