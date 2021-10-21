package zero_50.aboutString;

import java.util.*;
// No 151 重要哇
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String a = "a b c  d";
        System.out.println(reverseWordsV3(a));
        System.out.println(a.length());
        char aa = ' ';
        System.out.println(Integer.valueOf(aa));
    }

    public static String reverseWords(String s) {
        // trim是删除字符串二边空白字符或其他预定字符 ' 'ASCII码为32 而还有比32小的字符 并不会改变原字符串
        //split参数为正则表达式 " +" 表示多个空格
        String[] s1 = s.trim().split(" +");
        Collections.reverse(Arrays.asList(s1));
        System.out.println(Arrays.toString(s1));
        return Arrays.toString(s1);
    }
    public static String reverseWordsV2(String s) {
        // pre [left,right]为需要读取单词的区间
        // 1、首先去掉字符串首位空字符串，然后left、right此时指向首位
        // 2、从后往前遍历
        // 双指针只要考察的是
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length-1;
        StringBuilder res = new StringBuilder();
        while(left<=right && array[left]<=' ') left++;
        while (left<=right && array[right]<=' ')right--;

        while (left<=right){
            int index = right;
            while (array[index]!=' ' &&index>=left) index--;
            for (int i = index+1; i <=right ; i++) {
                res.append(array[i]);
            }
            if (index>=left) res.append(' ');
            while (left<=index && array[index]<=' ')index--;
            right = index;
        }
        return res.toString();
    }
    // 使用栈 先进后出
    public static String reverseWordsV3(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length-1;
        StringBuilder res = new StringBuilder();
        while(left<=right && array[left]<=' ') left++;
        while (left<=right && array[right]<=' ')right--;
        Stack<String> stack = new Stack<>();
        while (left<=right){
            if (array[left]!=' '){
                res.append(array[left]);
                left++;
            }else {
                while(left<=right &&  array[left]<=' ') left++;
                stack.add(res.toString());
                // 相当于把res置空
                res.setLength(0);
            }
        }
       // stack.add(res.toString()); 此时栈里还剩下最后一个元素
        while (stack.size()>=1){
            res.append(" "+stack.pop());
        }
        System.out.println(res.length());
        return res.toString();
    }



}
