package recursionandbacktracking;

public class AX_PrintAllEncodings {
    public static void main(String[] args) {
        char letter = 'a';
        for (char ch = 1 ;ch < 27; ch++) {
            letters[ch] = letter++;
        }
        printAllEncodings("103", "");
    }

    static char[] letters = new char[27];

    private static void printAllEncodings(String input, String answerSoFar) {
        if (input.length() == 0) {
            System.out.println(answerSoFar);
            return;
        }
        int num = Integer.parseInt(input.substring(0,1));
        if (input.length() >= 1 && num != 0) {
            printAllEncodings(input.substring(1), answerSoFar + letters[num]);
            if (input.length() >= 2) {
                int num2 = Integer.parseInt(input.substring(0,2));
                if (num2 <= 26) {
                    printAllEncodings(input.substring(2), answerSoFar + letters[num2]);
                }
            }
        }
    }
}
