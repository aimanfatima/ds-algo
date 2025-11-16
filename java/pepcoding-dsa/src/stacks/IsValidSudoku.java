package stacks;

import java.util.*;
import javafx.util.Pair;

class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = Integer.valueOf(board[i][j]);
                    if (map.containsKey(num)) {
                        map.get(num).add(new Pair(i, j));
                    } else {
                        List<Pair<Integer, Integer>> list = new ArrayList<>();
                        list.add(new Pair(i, j));
                        map.put(num, list);
                    }
                }
            }
        }

        System.out.println(map);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = Integer.valueOf(board[i][j]);
                    List<Pair<Integer, Integer>> indices = map.get(num);

                    for (Pair pair: indices) {
                        Integer ii = pair.getKey();
                        Integer jj = pair.getValue();
                        if (i != ii && j != jj) {
                            // check if this other pair is in the same row
                            if ( i == pair.getKey()) {
                                return false;
                            }
                            // check if this other pair is in the same column
                            if ( j == pair.getValue()) {
                                return false;
                            }
                            // check if this is in the mini grid
                            if (gridNo(i, j) == gridNo(pair.getKey(), pair.getValue())) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private int gridNo(int i, int j) {
        if (i < 3) {
            if (j < 3) {
                return 1;
            } else if (j >=3 && j < 6) {
                return 2;
            } else {
                return 3;
            }
        } else if (i >=3 && i < 6) {
            if (j < 3) {
                return 4;
            } else if (j >=3 && j < 6) {
                return 5;
            } else {
                return 6;
            }
        } else {
            if (j < 3) {
                return 7;
            } else if (j >=3 && j < 6) {
                return 8;
            } else {
                return 9;
            }
        }
    }
}