package recursionandbacktracking;

public class AY_FloodFill {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}
        };
        boolean[][] didVisit = new boolean[matrix.length][matrix[0].length];
        floodFill(0, 0, matrix, didVisit, "");
    }

    private static void floodFill(int currentRow, int currentCol, int[][] matrix, boolean[][] didVisit, String answerSoFar) {

        if (currentRow == matrix.length - 1 && currentCol == matrix[0].length - 1) {
            System.out.println(answerSoFar);
            return;
        }

        didVisit[currentRow][currentCol] = true;
        if (currentRow > 0
                && !didVisit[currentRow - 1][currentCol]
                && matrix[currentRow - 1][currentCol] != 1) {
            floodFill(currentRow - 1, currentCol, matrix, didVisit, answerSoFar + "t");
        }

        if (currentRow < matrix.length - 1
                && !didVisit[currentRow + 1][currentCol]
                && matrix[currentRow + 1][currentCol] != 1) {
            floodFill(currentRow + 1, currentCol, matrix, didVisit, answerSoFar + "d");
        }

        if (currentCol > 0
                && !didVisit[currentRow][currentCol - 1]
                && matrix[currentRow][currentCol - 1] != 1) {
            floodFill(currentRow, currentCol - 1, matrix, didVisit, answerSoFar + "l");
        }

        if (currentCol < matrix[0].length - 1
                && !didVisit[currentRow][currentCol + 1]
                && matrix[currentRow][currentCol + 1] != 1) {
            floodFill(currentRow, currentCol + 1, matrix, didVisit, answerSoFar + "r");
        }
        didVisit[currentRow][currentCol] = false;
    }
}
