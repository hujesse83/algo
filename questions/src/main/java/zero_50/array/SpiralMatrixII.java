package zero_50.array;

import java.util.Arrays;

/**、
 * No59 螺旋矩阵
 * 填充上行从左到右
 * 填充右列从上到下
 * 填充下行从右到左
 * 填充左列从下到上
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        generateMatrix(6);
    }

    /**
     * 擦了 又不可以递归
     */
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int a = 0;  // 上行左右
        int b = n - 1;  //右列上下
        int c = n - 1;  // 下列右左
        int d = 0;    // 左列下上
        int temp = 1;
        int k = n;  // 循环次数
        while (k >= 1) {
            int i = a;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0)
                    arr[i][j] = temp++;
            }
            a += 1;

//        00 01 02 03   1 2 3 4
//        10 11 12 13   12 13 14 5
//        20 21 22 23   11 16 15 6
//        30 31 32 33   10 9 8 7
            i = b;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 0)
                    arr[j][i] = temp++;
            }

            b -= 1;
            i = c;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    arr[i][j] = temp++;
                }
            }

            c--;
            i = d;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j][i] == 0) {
                    arr[j][i] = temp++;
                }

            }
            d++;
            k-= 2;
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        return arr;


//        00 01 02 03   1 2 3 4
//        10 11 12 13   12 13 14 5
//        20 21 22 23   11 16 15 6
//        30 31 32 33   10 9 8 7

    }

}
