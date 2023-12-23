package recursionandbacktracking;

public class AS_PrintKeypadCombinations {
    public static void main(String[] args) {
        printKeypadCodes("573", "");
    }

    static String[] codes = {".;","abc","def","ghi","jkl","mnop","qrst","uv","wxyz",",,"};

    private static void printKeypadCodes(String input, String answerSoFar) {
        if (input.length() == 0) {
            System.out.println(answerSoFar);
            return;
        }
        String code = codes[input.charAt(0) - '0'];
        for (int i=0; i< code.length(); i++) {
            printKeypadCodes(input.substring(1), answerSoFar + code.charAt(i));
        }
    }
}
