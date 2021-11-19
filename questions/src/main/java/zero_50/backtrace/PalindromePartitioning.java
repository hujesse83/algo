package zero_50.backtrace;

import java.util.ArrayList;

import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/17 17:43
 * @Description 回文字符串 LC131
 * a a b
 * ab
 * b
 * Tips：其实切割字符串与组合很类似的。切割和组合不同的地方在于，组合是选单个，而切割取的是一个区间
 */
public class PalindromePartitioning {
    public List<List<String>> res = new ArrayList<>();
    public List<String> item = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrace(s, 0);
        return res;
    }

    public void backTrace(String s, int index) {
        if (index == s.length()) { // index在s后面一位了
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                item.add(s.substring(index, i + 1));
                backTrace(s, i + 1);
                item.remove(item.size() - 1);
            }
        }
    }

    // 判断子串是不是回文子串
    public boolean isPalindrome(String s, int start, int end) {
        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
