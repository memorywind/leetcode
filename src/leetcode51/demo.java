package leetcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        List<Integer> col = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        List<Integer> add =  new ArrayList<>();
        dfs(res,col,add,sub,n,0,board);
        return res;
    }

    public void dfs(List<List<String>> res, List<Integer> colSet, List<Integer> add, List<Integer> sub, int n, int row, char[][] board) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(new String(board[i]));
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || add.contains(col + row) || sub.contains(row - col)) {
                continue;
            }
            colSet.add(col);
            add.add(col + row);
            sub.add(row - col);
            board[row][col] = 'Q';
            dfs(res, colSet, add, sub, n, row+1, board);
            colSet.remove(Integer.valueOf(col));
            add.remove(Integer.valueOf(col + row));
            sub.remove(Integer.valueOf(row - col));
            board[row][col] = '.';
        }
    }
}
