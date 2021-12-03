package zero_50.dp;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/3 11:43
 * 类似于小老鼠找迷宫. 1、回溯 时间很长
 */
public class UniquePaths {
    private int [][] chessboard;
    private int count = 0;
    //1、尝试使用回溯 当棋盘数量大起来之后超出时间限制
    public int uniquePaths(int m, int n) {
        chessboard = new int[m][n];
        backTrace(0,0,chessboard);
        return count;
    }
    public void backTrace(int row,int col,int [][]chessboard){
        if (row==chessboard.length-1 && col==chessboard[0].length-1){
            count++;
            display();
            return;
        }
        if (row>=chessboard.length){
            return;
        }
        if (col>=chessboard[0].length){
            return;
        }
        chessboard[row][col] = 1;
        backTrace(row,col+1,chessboard);
        backTrace(row+1,col,chessboard);
        chessboard[row][col] = 0;
    }
    public void display(){
        for (int[] ints : chessboard) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3,7);
    }
}
