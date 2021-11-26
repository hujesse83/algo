package zero_50.greedy;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/11/26 14:35
 * 此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
 * Hard 类型 这道题真牛 秒啊
 * LC 125 ​:star:​
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] candyArray = new int[ratings.length];
        Arrays.fill(candyArray, 1);
        //  A  B  C  1、 首先从前往后比较，考虑[i+1] > [i] 的情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyArray[i] = candyArray[i - 1] + 1;
            }
        }

        // A B C  2、 再从后往前比较，考虑 [i] > [i+1]的情况
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyArray[i] = Math.max(candyArray[i], candyArray[i + 1] + 1);
            }
        }
        return Arrays.stream(candyArray).sum();
    }
}
