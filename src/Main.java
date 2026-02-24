public class Main {
    public static void main(String[] args) {
        String result = String.valueOf(ReversePolishNotation.infixToPostfix("a + b * c + (d  * e + f) * g"));
        System.out.println(result);

    }
}