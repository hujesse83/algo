package zero_50.random.easy.Jan13;

/**
 * @author jesse.hu
 * @date 2022/1/13 18:42
 * @LeetCodeNo 202
 * 再次做了这道还是没做出来
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 他们总会相遇，仔细思考
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (slow !=1){
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
            if (slow == fast && slow!=1){
                return false;
            }
        }
        return true;
    }

    public int getNext(int n){
        int ans = 0;
        while (n!=0){
            int digit = n %10;
            ans +=Math.pow(digit,2);
            n /=10;
        }
        return ans;
    }
}
