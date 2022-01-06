package zero_50.random.easy;

/**
 * @author jesse.hu
 * @date 2022/1/6 10:32
 * @LeetCodeNo 9
 */
public class PalindromeNumber {
    //1、7ms 数字转为字符串. 利用python语言特性可以将字符串截取为一半. 宁外一半是反序的
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0, j = len - 1; i <= len / 2; i++, j--) {
            if (str.charAt(i) == str.charAt(j)) {
                continue;
            }
            return false;
        }
        return true;
    }

    //2、6ms  将数字本身反转。 但是这样会有整数溢出,但是溢出之后变成了负数，也能AC
    //如果是回文数，显然不会溢出
    public static boolean isPalindromeV2(int x) {
        if (x < 0) return false;
        int y = x;
        int res = 0;
        while (y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }

    // answer 时间复杂度 O(log10(n))   空间复杂符O（1） 只需开辟int空间
    public static boolean isPalindromeV3(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }


    public static void main(String[] args) {
        isPalindromeV2(2147117421);
        isPalindromeV3(12321);  // 奇数情况
        isPalindromeV3(1221);  // 偶数情况
    }
}
