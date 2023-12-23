package recursionandbacktracking;

public class AR_PrintAllSubsequences {
    public static void main(String[] args) {
        String str = "abc";
        printAllSubsequences(str, "");
    }

    private static void printAllSubsequences(String str, String answerSoFar) {
        if (str.length() == 0) {
            System.out.println(answerSoFar);
            return;
        }
        printAllSubsequences(str.substring(1), answerSoFar);
        printAllSubsequences(str.substring(1), answerSoFar + str.charAt(0));
    }
}
