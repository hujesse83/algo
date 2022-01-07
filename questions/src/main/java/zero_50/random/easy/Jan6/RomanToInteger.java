package zero_50.random.easy.Jan6;


/**
 * @author jesse.hu
 * @date 2022/1/6 11:14
 * @LeetCodeNo 13
 * the key to it:把小值放在大值左边就做减法， 否则做加法
 */
public class RomanToInteger {
    // 这也是我当初的思路，卡在了枚举上面.
    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }

    // 核心在于比较当前字符与下一个罗马字符的关系. 多读题. 罗马数字是从大到小排列的
    //时间复杂度：O(n)，其中 n 是字符串 s 的长度。
    //
    //空间复杂度：O(1)。
    public int romanToIntV2(String s) {
        int ans = 0;
        int len = s.length();
        for (int i = 0; i <len ; i++) {
            int value = getValue(s.charAt(i));
            if (i < len -1 && value< getValue(s.charAt(i+1))){
                ans -= value;
            }else {
                ans +=value;
            }
        }
        return ans;
    }


    public int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default: return 0;
        }
    }
}
