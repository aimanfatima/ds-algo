package recursionandbacktracking;

public class AU_PrintMazePath {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;
        printMazePath(0, 0, rows, cols, "");
    }

    private static void printMazePath(int currentRow, int currentCol, int destinationRow, int destinationCol, String answerSoFar) {
        if (currentRow == destinationRow && currentCol == destinationCol) {
            System.out.println(answerSoFar);
            return;
        }
        if (currentCol < destinationCol) {
            printMazePath(currentRow, currentCol + 1, destinationRow, destinationCol, answerSoFar + "h");
        }

        if (currentRow < destinationRow) {
            printMazePath(currentRow + 1, currentCol, destinationRow, destinationCol, answerSoFar + "v");
        }
    }
}
