package zero_50.backtrace;

/**
 * @Author huJesse
 * @Date 2021/11/22 00:18
 * @Description 二维数组暴力回溯 N皇后是一维的
 *              一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。
 *              数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 空白格用 '.' 表示
 * @ LC 37 difficult
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backTrace(board);
    }
    public boolean backTrace(char[][] board){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]!='.'){
                    continue;
                }
                for (char k = '1'; k <='9' ; k++) {
                    if (isValidSudoku(i,j,k,board)){
                        board[i][j] = k;
                        if (backTrace(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;  // 1-9数字试了全都不行说明 无解
            }
        }
        return true;
    }
    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

}
