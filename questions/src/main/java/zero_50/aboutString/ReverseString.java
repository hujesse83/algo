package zero_50.aboutString;

import java.util.Arrays;

/**
 * No344
 * 要求不分配新内存
 */
public class ReverseString {
    public static void main(String[] args) {
        char [] s ={'a','b','c','d','e','f'};
        reverseStringV2(s);
    }

    /**
     * 用一个辅助变量Swap
     */
    public static void reverseString(char[] s) {
       if (s==null || s.length==0){
           return;
       }
       char temp = ' ';
       int begin = 0;
       int last = s.length-1;
       while (begin<last){
           temp = s[begin];
           s[begin] = s[last];
           s[last] = temp;
           begin++;
           last--;
       }
        System.out.println(Arrays.toString(s));
    }

    /**
     * 2、使用异或操作符 即使用^
     */
    public static void reverseStringV2(char[] s) {
        if (s==null || s.length==0){
            return;
        }
        int i = 0;
        int j = s.length-1;
        while (i<j){
            s[i] ^=s[j];
            s[j] ^= s[i];
            s[i] ^=s[j];
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }
    /**
     * 方法三
     */

}
