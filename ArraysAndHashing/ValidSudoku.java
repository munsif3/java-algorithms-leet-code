package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        // "." means no number on board
        char[][] testCase1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
        };
        char[][] testCase2 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
        };

        System.out.println("isValidSudoku test cases, ");
        System.out.println("testCase1 -> " + isValidSudoku(testCase1));
        System.out.println("testCase2 -> " + isValidSudoku(testCase2));
    }

    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Hashset to detect duplicates
        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        // check for rows - if duplicate value exists then not a valid sudoku board
        for (int i = 0; i < rows; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }
        }

        // check for cols - if duplicate value exists then not a valid sudoku board
        for (int i = 0; i < cols; i++) {
            colSet = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (colSet.contains(board[j][i])) {
                    return false;
                }
                colSet.add(board[j][i]);
            }
        }

        // block - also need to make sure no duplicate value exists in the 3x3 subsquare
        for (int i = 0; i < rows; i = i + 3) {
            for (int j = 0; j < cols; j = j + 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (blockSet.contains(board[i][j])) {
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }
        return true;
    }
}
