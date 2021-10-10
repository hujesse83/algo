package zero_50.useHash;

import java.util.HashSet;
import java.util.Set;

/**
 * No202
 * 快乐数
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * #
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static HashSet<Integer> set = new HashSet<>();

    /**
     * 我自己写的方法  不知道为什么OJ上测不通过 ... 也算是一种思路把..
     * 如果递归层次较深，会直接导致调用栈崩溃。不要因为这个题目给出的整数是 int 型而投机取巧
     * 此题不建议用集合记录每次的计算结果来判断是否进入循环，因为这个集合可能大到无法存储
     */
    static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (!set.contains(n)) {
            set.add(n);
        } else {
            return false;
        }
        int sum = 0;
        String num = String.valueOf(n);
        for (int ch : num.toCharArray()) {
            ch -= '0';
            sum += ch * ch;
        }
        return isHappy(sum);
    }

    /**
     * Answer  1
     * 还有一个难点就是求和的过程，如果对取数值各个位上的单数操作不熟悉的话，做这道题也会比较艰难。
     * 时空均为O(n)
     */

    public static boolean isHappyV2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    /**
     * 快慢指针法 时间复杂度O(1)  时间复杂度O(n)
     * 10
     */
    static boolean isHappyV3(int n) {
        int slow = n;
        int quick = n;
        do {
            slow = getNextNumber(slow);
            quick = getNextNumber(quick);
            quick = getNextNumber(quick);
        } while (slow != quick);
        return slow == 1;
    }

}
