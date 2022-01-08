package zero_50.random.easy.Jan8;

/**
 * @author jesse.hu
 * @date 2022/1/8 17:03
 * @LeetCodeNo 67
 * @Desc given two binary strings a and b, return their sum as a binary string.
 * 字符型是由ASCII码表示的，与数字对对应不上，减去'0'之后，
 * 刚好字符之间与数字之间可以对应； 比如：char c1 = '1' + '1' - '0'; （'1'的ASCII为49，'0'为48） 这样结果才能变成'2';否则如果不减去'0',结果就是两个字符1之间的ASCII相加，为98
 */
public class AddBinary {
    //1、 star star
    public static String addBinary(String a, String b) {StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        addBinary("1010","1011");
    }
}
