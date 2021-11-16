package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time 2021/11/15 17:55
 * LC 17 mid 难度
 * 2021/11/15 22：04
 */
public class LetterCombinationsOfAPhoneNumber {
    public static ArrayList<String> res = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    // 这是我自己写的 稍微有点垃圾
    public static List<String> letterCombinations(String digits) {
        if (digits == ""||digits==null) {
            return res;
        }
        char[] array = digits.toCharArray();
        ArrayList<Integer> item = new ArrayList<>();
        for (char c : array) {
            item.add((int) c - 48);
        }
        System.out.println(item);
        backTrace(item, 0);
        return res;
    }

    public static void backTrace(ArrayList<Integer> digits, int index) {
        if (index >= digits.size()) {
            res.add(sb.toString());
            return;
        }
        char ch = 'a';
        Integer digit = digits.get(index);
        if (digit == 2) {
            ch = 'a';
        } else if (digit == 3) {
            ch = 'd';
        } else if (digit == 4) {
            ch = 'g';
        } else if (digit == 5) {
            ch = 'j';
        } else if (digit == 6) {
            ch = 'm';
        } else if (digit == 7) {
            ch = 'p';
        } else if (digit == 8) {
            ch = 't';
        } else if (digit == 9) {
            ch = 'w';
        }else {
            return;
        }
        char end = (char) (ch + 3);
        if (digit == 7 || digit == 9) {  // 主要是7和9有四个字符
            end += 1;
        }
        for (char i = ch; i < end; i++) {
            sb.append(i);
            backTrace(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);;// 移除最后一个元素
        }
    }

    // V2 简洁答案
    public List<String> letterCombinationsV2(String digits) {
        if(digits==null ||digits.length()==0){
            return res;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""为0和1
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits,numString, 0);
        return res;
    }
    public void backTracking(String digits,String[] numString,int num){
        if (num==digits.length()){
            res.add(sb.toString());
            return;
        }
        String str = numString[digits.charAt(num)-'0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(digits,numString,num+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        letterCombinations("1");
        System.out.println(res);
    }
}
