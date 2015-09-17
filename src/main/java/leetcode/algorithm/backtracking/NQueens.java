package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blank on 2015-09-09 下午9:59.
 */
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        System.out.println(res);
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] tmp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = '.';
            }
        }
        return helper(n, 0, res, tmp);
    }

    private static List<List<String>> helper(int n, int row, List<List<String>> res, char[][] board) {
        if (n == 0) {
            List<String> k = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                k.add(new String(board[i]));
            }
            res.add(k);
            return res;
        }
        int len = board.length;
        for (int j = 0; j < len; j++) {
            if (yValid(row, j, board) && zValid(row, j, board)) {
                board[row][j] = 'Q';
                helper(n - 1, row + 1, res, board);
                board[row][j] = '.';
            }
        }
        return res;
    }

    private static boolean zValid(int i, int j, char[][] board) {
        for (int k = i, m = j; k < board.length && m < board.length; k++, m++) {
            if (board[k][m] == 'Q') {
                return false;
            }
        }
        for (int k = i, m = j; k >= 0 && m >= 0; m--, k--) {
            if (board[k][m] == 'Q') {
                return false;
            }
        }
        for (int k = i, m = j; k < board.length && m >= 0; k++, m--) {
            if (board[k][m] == 'Q') {
                return false;
            }
        }
        for (int k = i, m = j; k >= 0 && m < board.length; k--, m++) {
            if (board[k][m] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static boolean yValid(int i, int j, char[][] board) {
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}

