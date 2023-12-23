package recursionandbacktracking;

public class AV_PrintMazePathJumps {
    public static void main(String[] args) {
        printMazePathJumps(0, 0, 2, 2, "");
    }

    private static void printMazePathJumps(int sourceRow, int sourceCol, int destinationRow, int destinationCol, String answerSoFar) {
        if (sourceRow == destinationRow && sourceCol == destinationCol) {
            System.out.println(answerSoFar);
            return;
        }

        for (int i=1; i<=destinationRow - sourceRow; i++) {
            printMazePathJumps(sourceRow+i, sourceCol, destinationRow, destinationCol, answerSoFar + "v" + i);
        }
        for (int i=1; i<= destinationCol- sourceCol; i++) {
            printMazePathJumps(sourceRow, sourceCol+i, destinationRow, destinationCol, answerSoFar + "h" + i);
        }
        for (int i=1; i<=destinationRow - sourceRow && i <= destinationCol- sourceCol; i++) {
            printMazePathJumps(sourceRow+i, sourceCol+i, destinationRow, destinationCol, answerSoFar + "d" + i);
        }
    }
}
