package recursionandbacktracking;

import java.util.ArrayList;

public class AO_GetStairPath {
    public static void main(String[] args) {
        ArrayList<String> allPossibleWays = getAllStairPath(5);
        System.out.println(allPossibleWays);
    }

    static int[] possibleSteps = {1, 2, 3, 4, 5};

    static ArrayList<String> getAllStairPath(int n) {
        if (n == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        } else if (n < 0) {
            return new ArrayList<>();
        }

        ArrayList<String> allPossiblePaths = new ArrayList<>();

        for (int step: possibleSteps) {
            ArrayList<String> allPathsFromNmiStair = getAllStairPath(n - step);
            for (String path : allPathsFromNmiStair) {
                allPossiblePaths.add(step + path);
            }
        }

        return allPossiblePaths;
    }
};