package zero_50.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/21 23:09
 * 这个版本要快一点。但是回朔思想都是一样的。用到了String.copyValueOf().Arrays.file方法。
 */
public class NQueensAnswer {
        List<List<String>> res = new ArrayList<>();
        char [][] chessboard;

        public List<List<String>> solveNQueens(int n) {
            chessboard = new char[n][n];
            for (char[] c : chessboard) {
                Arrays.fill(c, '.');
            }

            backTrack(n, 0, chessboard);
            return res;
        }


        public void backTrack(int n, int row, char[][] chessboard) {
            if (row == n) {
                res.add(Array2List(chessboard));
                return;
            }

            for (int col = 0;col < n; col++) {
                if (isValid (row, col)) {
                    chessboard[row][col] = 'Q';
                    backTrack(n, row+1, chessboard);
                    chessboard[row][col] = '.';
                }
            }

        }


        public List Array2List(char[][] chessboard) {
            List<String> list = new ArrayList<>();

            for (char[] c : chessboard) {
                list.add(String.copyValueOf(c));
            }
            return list;
        }


        public boolean isValid(int row, int col) {
            // 检查列
            for (int i=0; i<row; i++) {
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }

            // 检查45度对角线
            for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查135度对角线
            for (int i=row-1, j=col+1; i>=0 && j<chessboard.length; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

}
