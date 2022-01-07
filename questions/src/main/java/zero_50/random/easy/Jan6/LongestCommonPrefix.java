package zero_50.random.easy.Jan6;

import java.util.Arrays;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/6 14:23
 * @LeetCodeNo 14 .
 * @Description: 这道题呢是求的公共前缀, 不是字串、我真的想多了
 */
public class LongestCommonPrefix {
    // 方法1 横行扫描  复杂符O(m * n) m是字符串数组中字符串的平均长度, n是字符串的数量
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String commonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    // 方法二 纵向扫描..前往后遍历所有字符串的每一列，比较相同列上的字符是否相同

    /**
     * 需要仔细思考的点在于： strs[0] 的长度比其他长、 and strs[0]的长度最短.
     */
    public static String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("leetcode", "leet", "lee", "le");
        String[] strs = list.toArray(new String[]{});
        System.out.println(longestCommonPrefixV3(strs));
    }


    // 方法三  分治法. LCP(s1...sn) = LCP(LCP(s1...sk),LCP(sk+1...sn))

    /**
     * 分解为二个子问题，然后对二个子问题的解计算最长公共前后缀
     */
    public static String longestCommonPrefixV3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefix(String[] strs, int start, int end) {
        if (end == start) {
            return strs[start];
        }
        int mid = (end - start) / 2 + start;
        String lcpLeft = longestCommonPrefix(strs, start, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, end);
        return commonPrefix(lcpLeft, lcpRight);
    }
}
