package zero_50.stackAndqueue;

import java.util.*;

/**
 *
 * 这是使用单调队列的经典题目。
 * 239.滑动窗口最大值
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow2(nums, 3)));
    }

    // 双指针做的  不过时间超出了
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int slow = 0;
        for (int fast = k-1; fast <nums.length; fast++) {
            int max = Integer.MIN_VALUE;
            for (int i = slow; i <=fast ; i++) {
                if (nums[i]>max){
                    max = nums[i];
                }
            }
            res.add(max);
            slow++;
        }
        Integer[] array = list.toArray(new Integer[res.size()]);  // list转数组
        int []res2 = new int[res.size()];
        for (int i = 0; i < res2.length; i++) {
            res2[i] = res.get(i);
        }
        return res2;
    }
    // 正解
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        // 结果数组（窗口个数 len - k + 1)
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int left = 0;
        for (int right = 0; right < len; right++) {
            // 如果队列不为空，且队尾元素小于 nums[right]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.removeLast();
            }
            // 队列为空或当前nums[right] <= 小于新的队尾元素
            deque.addLast(right);
            // 当 right >= k - 1 时  说明窗口形成
            if (right >= k - 1) {
                // 判断队首元素下标是否 < left, 是说明队首不在窗口内，移除队首
                if (deque.peekFirst() < left) {
                    deque.removeFirst();
                }
                // 否则下一个新队首一定在窗口内(因为每次只滑动一个距离)
                // 新队首就是窗口最大值
                res[left] = nums[deque.getFirst()];
                left++; // 左指针右移
            }
        }
        return res;
    }
}
