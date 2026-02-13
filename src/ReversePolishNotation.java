
public class ReversePolishNotation {

    public static int evaluatePostfix(String input){
        Stack s = new Stack();
        String numFilter = "-+*/^";
        char[] inList = input.toCharArray();

        for (char c : inList){
            if (numFilter.indexOf(c) == -1){ // If c is actually a number
                s.push(Character.toString(c));

            }
            else{
                if (c == '-'){
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 - num2));
                }
                else if (c == '+'){
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 + num2));
                }
                else if (c == '*'){
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 * num2));
                }
                else if (c == '/'){
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(num1 / num2));
                }
                else if (c == '^'){
                    int num2 = Integer.parseInt(s.pop());
                    int num1 = Integer.parseInt(s.pop());
                    s.push(Integer.toString(Math.powExact(num1, num2)));
                }
            }
        }
    }

    public static String infixToPostfix(String input){
        Stack s = new Stack();
    }

}
