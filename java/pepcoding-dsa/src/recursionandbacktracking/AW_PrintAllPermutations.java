package recursionandbacktracking;

public class AW_PrintAllPermutations {
    public static void main(String[] args) {
        printAllPermutations("abc", "");
    }

    private static void printAllPermutations(String str, String answerSoFar) {
        if (str.length() == 0) {
            System.out.println(answerSoFar);
            return;
        }
        for (int i=0; i<str.length(); i++) {
            String firstPart = str.substring(0, i);
            String secondPart = str.substring(i + 1);
            printAllPermutations(firstPart + secondPart, answerSoFar + str.charAt(i));
        }
    }
}
