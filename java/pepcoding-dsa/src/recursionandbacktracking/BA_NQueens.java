package recursionandbacktracking;

public class BA_NQueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] canPlace = new int[4][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                canPlace[i][j] = 0;
            }
        }
        nQueens(n, canPlace, 0, "");
    }

    static int count = 0;

    private static void nQueens(int n, int[][] canPlace, int queensPlacedSoFar, String answerSoFar) {
        if (queensPlacedSoFar == n) {
            System.out.println(answerSoFar);
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (canPlace[i][j] == 0) {
                    canPlace[i][j]++;
                    changeRow(i, j, canPlace, false, n);
                    changeColumn(j,i, canPlace, false, n);
                    changeDiagonals(i, j, canPlace, false, n);
                    count++;
                    nQueens(n, canPlace, queensPlacedSoFar+1, answerSoFar+ i + " " + j + " - ");
                    changeRow(i, j, canPlace, true, n);
                    changeColumn(j,i, canPlace, true, n);
                    changeDiagonals(i, j, canPlace, true, n);
                    canPlace[i][j]--;
                }
            }
        }
    }

    private static void print(int[][] canPlace) {
        for (int i=0; i<canPlace.length; i++) {
            for (int j=0; j<canPlace[i].length; j++) {
                System.out.print(canPlace[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void changeDiagonals(int row, int col, int[][] canPlace, boolean action, int n) {
        int i=row, j = col;
        while (i<n-1 && j<n-1) {
            i++;
            j++;
            if (!action) {
                canPlace[i][j]++;
            } else {
                canPlace[i][j]--;
            }
        }
        i = row;
        j = col;
        while (i>0 && j>0) {
            i--;
            j--;
            if (!action) {
                canPlace[i][j]++;
            } else {
                canPlace[i][j]--;
            }
        }

        i = row;
        j = col;
        while (i>0 && j<n-1) {
            i--;
            j++;
            if (!action) {
                canPlace[i][j]++;
            } else {
                canPlace[i][j]--;
            }
        }

        i = row;
        j = col;
        while (i<n-1 && j>0) {
            i++;
            j--;
            if (!action) {
                canPlace[i][j]++;
            } else {
                canPlace[i][j]--;
            }
        }
    }

    private static void changeColumn(int col, int row, int[][] canPlace, boolean action, int n) {
        for (int i=0; i<n; i++) {
            if (i==row) {
                continue;
            }
            if (!action) {
                canPlace[i][col]++;
            } else {
                canPlace[i][col]--;
            }
        }
    }

    private static void changeRow(int row, int col, int[][] canPlace, boolean action, int n) {
        for (int i=0; i<n; i++) {
            if (i==col) {
                continue;
            }
            if (!action) {
                canPlace[row][i]++;
            } else {
                canPlace[row][i]--;
            }
        }
    }
}
