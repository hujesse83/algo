package zero_50.greedy;


/**
 * @Author huJesse
 * @Date 2021/11/28 14:45
 * LC 738
 */
public class MonotoneIncreasingDigits {
    // 这里存在从前往后和从后往前遍历二种方案。所以从前后向遍历会改变已经遍历过的结果 所以采用从后往前
    public static int monotoneIncreasingDigits(int n) {
        String str = n + "";
        char[] arr = str.toCharArray();
        int len = arr.length;
        int flag = len;
        for (int i = len - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                flag = i;
                arr[i - 1]--;
            }
        }
        for (int i = flag; i < len; i++) {
            arr[i] = '9';
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        System.out.println(MonotoneIncreasingDigits.monotoneIncreasingDigits(213));
    }
}
