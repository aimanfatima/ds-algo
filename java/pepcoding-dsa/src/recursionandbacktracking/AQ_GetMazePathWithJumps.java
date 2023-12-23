package recursionandbacktracking;

import java.util.ArrayList;

public class AQ_GetMazePathWithJumps {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        ArrayList<String> allPaths =
                getMazePathsWithJumps(0, 0, rows-1, cols-1);
        System.out.println(allPaths);
    }

    private static ArrayList<String> getMazePathsWithJumps(int sourceRow, int sourceCol, int destinationRow, int destinationCol) {

        if (sourceCol == destinationCol && sourceRow == destinationRow) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        ArrayList<String> allPossiblePaths = new ArrayList<>();

        if (sourceCol < destinationCol) {
            for (int step = 1; step <= destinationCol - sourceCol; step++) {
                ArrayList<String> allPossiblePathsFromNextCol =
                        getMazePathsWithJumps(sourceRow, sourceCol + step, destinationRow, destinationCol);
                for (String path: allPossiblePathsFromNextCol) {
                    allPossiblePaths.add("h" + step + path);
                }
            }
        }

        if (sourceRow < destinationRow) {
            for (int step = 1; step <= destinationRow - sourceRow; step++) {
                ArrayList<String> allPossiblePathsFromNextRow =
                        getMazePathsWithJumps(sourceRow + step, sourceCol, destinationRow, destinationCol);
                for (String path: allPossiblePathsFromNextRow) {
                    allPossiblePaths.add("v" + step + path);
                }
            }
        }

        // diagonals
        for (int step = 1; step <= destinationRow - sourceRow && step <= destinationCol - sourceCol; step++) {
            ArrayList<String> allPossiblePathsFromNextDiagonal =
                    getMazePathsWithJumps(sourceRow + step, sourceCol + step, destinationRow, destinationCol);
            for (String path: allPossiblePathsFromNextDiagonal) {
                allPossiblePaths.add("d" + step + path);
            }
        }

        return allPossiblePaths;
    }
}
