package zero_50.dp.fullPackage;

import java.util.Arrays;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/12/12 19:04
 * LC 139 这道题:star
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int []dp = new int[len+1]; //1、字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        //2、if ([j,i]这个区间的字符串出现在字典里 && dp[j]==true) 那么dp[i] = true
        Arrays.fill(dp,0);
        dp[0] = 1;
        // 遍历物品 与 遍历容量都没有区别.但是这里背包在外侧更方便字符串的操作
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j <i ; j++) {
                System.out.println(s.substring(j,i));
                if (wordDict.contains(s.substring(j,i)) && dp[j]==1){
                    dp[i] = 1;
                }
            }
        }
        return dp[len]==1?true:false;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("leet", "code");
        new WordBreak().wordBreak("leetcode",list);
    }
}
