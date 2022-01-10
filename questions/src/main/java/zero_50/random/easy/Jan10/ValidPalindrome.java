package zero_50.random.easy.Jan10;

/**
 * @author jesse.hu
 * @date 2022/1/10 16:50
 * @LeetCodeNo 125
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Method1、筛选 + 判断. 只要是API的使用啊... 不然判断在a-z, 0-9 A-Z 的区间内代码难看
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder reverseOrigin = new StringBuilder(sb).reverse();
        return sb.toString().equals(reverseOrigin.toString());
    }


    // 直接在原串上操作. 我当时没记住Character的API方法..  白板还真的记啊！！！
    public boolean isPalindromeV2(String s) {
        // 直接在原串上进行操作
        int end = s.length()-1;
        int begin = 0;
        while (begin <end){
            while (begin < end && !Character.isLetterOrDigit(s.charAt(begin))){
                begin++;
            }
            while (begin < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if (begin < end){
                char ch1 = s.charAt(begin);
                char ch2 = s.charAt(end);
                if(Character.toLowerCase(ch1)!=Character.toLowerCase(ch2)){
                    return false;
                }
                begin++;
                end--;
            }
        }
        return true;
    }
}
