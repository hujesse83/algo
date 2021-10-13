package zero_50.aboutString;

// 剑指offer 58 ==>{尝试不使用额外空间}

public class RotateStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWordsV3(s, 2));
    }
    // 1、使用StringBuilder
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
    // 局部反转+整体反转 达到左旋转的目的。
    public static String reverseLeftWordsV3(String s, int n) {
        StringBuilder res = new StringBuilder(s);
        reverseString(res,0,n-1);
        reverseString(res,n,s.length()-1);
        return res.reverse().toString();
    }
    public static void reverseString(StringBuilder res,int start,int end){
        while (start<end){
            char temp = res.charAt(start);
            res.setCharAt(start,res.charAt(end));
            res.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
