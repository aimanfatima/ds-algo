package recursionandbacktracking;

public class AT_PrintStairPath {
    public static void main(String[] args) {
        printStairPath(3, "");
        System.out.println("No of paths = " + count);
    }

    static int[] possibleSteps = {1, 2, 3};
    static int count = 0;

    private static void printStairPath(int num, String answerSofar) {
        if (num <= 0) {
            if (num == 0 ) {
                count++;
                System.out.println(answerSofar);
            }
            return;
        }
        for (int step: possibleSteps) {
            printStairPath(num-step, answerSofar + step);
        }
    }
}
