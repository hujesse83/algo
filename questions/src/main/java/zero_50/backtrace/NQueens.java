package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/21 21:56
 * 自己的版本 。 LC51 很经典的N皇后问题
 */
public class NQueens {
    public List<List<String>> res = new ArrayList<>();
    public List<String > item = new ArrayList<>();
    public StringBuilder sb = new StringBuilder();
    public int [][] chessBoard ;
    public static int COUNT = 0;
    public List<List<String>> solveNQueens(int n) {
         chessBoard = new int[n][n];
        backTrace(0,n);
        return res;
    }
    public void backTrace(int row,int n){
        for (int col = 0; col < n; col++) {
            if (isValid(row,col)){
                chessBoard[row][col] = 1;
                if (row==n-1){
                   // display();
                    arrayToList();
                }
                if (row<n-1){
                    backTrace(row+1,n);
                }
                chessBoard[row][col]=0;
            }
        }
    }
    public boolean isValid(int row,int col){
        for (int i = row; i >=0 ; i--) {
            if (chessBoard[i][col]==1){  // 垂直方向上有棋子
                return false;
            }
        }
        // 查看坐上斜线是否有皇后
        for (int i = row , j = col; i >=0&&j>=0 ; i--,j--) {
            if (chessBoard[i][j]==1){
                return false;
            }
        }
        // 查看右上斜线是否有皇后
        for (int i = row,j=col; i>=0&&j<chessBoard[0].length ; i--,j++) {
            if (chessBoard[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public void display(){
        System.out.println("第"+(++COUNT)+"次摆法");
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public void arrayToList(){
        for (int[] ints : chessBoard) {
            for (int i : ints) {
                if(i==0){
                    sb.append(".");
                }else {
                    sb.append("Q");
                }
            }
            item.add(sb.toString());
            sb.setLength(0);
        }
        res.add(new ArrayList<>(item));
        item.clear();
        sb.setLength(0);
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
