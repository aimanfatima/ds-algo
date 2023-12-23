package recursionandbacktracking;

import java.util.ArrayList;

public class AP_GetMazePath {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        ArrayList<String> getAllMazePaths = getAllMazePaths(0, 0, rows-1, cols-1);
        System.out.println(getAllMazePaths);
    }

    private static ArrayList<String> getAllMazePaths(int currentRow, int currentCol, int totalRows, int totalCols) {

        if (currentRow >= totalRows || currentCol >= totalCols) {
            ArrayList<String> baseResult = new ArrayList<>();
            if (currentRow == totalRows || currentCol == totalCols) {
                baseResult.add("");
            }
            return baseResult;
        }

        ArrayList<String> allPathsFromNextCol = getAllMazePaths(currentRow, currentCol + 1, totalRows, totalCols);
        ArrayList<String> allPathsFromNextRow = getAllMazePaths(currentRow + 1, currentCol, totalRows, totalCols);
        ArrayList<String> allPossiblePaths = new ArrayList<>();

        for (String path : allPathsFromNextCol) {
            allPossiblePaths.add("h" + path);
        }

        for (String path : allPathsFromNextRow) {
            allPossiblePaths.add("v" + path);
        }

        return allPossiblePaths;
    }
}
