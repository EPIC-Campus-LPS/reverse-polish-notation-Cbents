public class Main {
    public static void main(String[] args) {
        String result = String.valueOf(ReversePolishNotation.evaluatePostfix("72+9/35*"));
        System.out.println(result); //ONLY WORKS FOR SINGLE DIGIT NUMBERS RIGHT NOW

    }
}