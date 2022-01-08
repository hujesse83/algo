package zero_50.random.easy.Jan8;

/**
 * @author jesse.hu
 * @date 2022/1/8 23:58
 * @LeetCodeNo 69
 * @desc 本题是一道常见的面试题，面试官一般会要求面试者在不使用 \sqrt{x}
 * 函数的情况下，得到 xx 的平方根的整数部分
 */
public class SqrtX {
    public static int mySqrt(int x) {
        int left = 0;
        int right = x / 2;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long temp = (long) mid * mid; //脑袋没转过来想到要用long
            if (temp < x) {
                left = mid + 1;
            } else if (temp > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        System.out.println(Integer.MAX_VALUE);
    }

}
