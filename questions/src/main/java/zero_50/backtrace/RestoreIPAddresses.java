package zero_50.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/19 13:33
 * 类似字符串分割 就是判断条件换了一下。LC93 考验的是字符串的处理多一点
 * 字符串处理确实要求对下标，长度的处理很麻烦。
 */
public class RestoreIPAddresses {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {  // 小剪枝
            return Collections.emptyList();
        }
        backTrace(s, 0, 0);
        return result;

    }

    public void backTrace(String s, int startIndex, int pointNum) {
        if (sb.length() == s.length() + 4) {  // 四个dot 记录添加逗点的数量。
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }
        if (pointNum == 4) {
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 剪枝 选了一个ip，看剩下的数字长度是不是超过了
            int leftLength = s.length() - i - 1;
            if (leftLength > (3 - pointNum) * 3) {  // 小剪枝
                continue;
            }
            if (isValid(s, startIndex, i)) {
                sb.append(s, startIndex, i + 1);
                sb.append(".");
                backTrace(s, i + 1, pointNum + 1);
                int len = i + 1 - startIndex;
                sb.delete(sb.length() - (len + 1), sb.length());
            } else {
                return; // 剪枝
            }
        }
    }
    // 判断字符串s在左闭右闭区间[startIndex,endIndex] 所组成的数字是否合法

    /**
     * 段位以0为开头的数字不合法
     * 段位里有非正整数字符不合法
     * 段位如果大于255了不合法
     */
    public boolean isValid(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        if (s.charAt(startIndex) == '0' && endIndex != startIndex) {
            return false;
        }
        int num = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0'); // 真是巧妙
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidV2(String s, int start, int end) {
        String temp = s.substring(start, end);
        if (temp.length() > 1) {
            if (temp.startsWith("0")) {
                return false;
            }
        }
        if (temp.length() > 3) {
            return false;
        }
        return Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("22522511135"));
    }

}
