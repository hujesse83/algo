package zero_50.useHash;
/**
 * 383.
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *   方法 1）HashMap key：字符 value：次数
 *   方法 2） 26长度的数组

*/
import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String s = "ab";
        String a = "aa";
        System.out.println(canConstructV2(a, s));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>(); // 字符以及出现的次数
        for (Character ch : magazine.toCharArray()) {
            map.put(ch, map.get(ch) == null ? 1 : map.get(ch) + 1);
        }
        for (Character ch : ransomNote.toCharArray()) {
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的
     * ！数据量大的话就能体现出来差别了。 所以数组更加简单直接有效
     */
    public static boolean canConstructV2(String ransomNote, String magazine) {
        // 记录杂志字符出现的次数
        int []temp = new int[26];
        for(char ch:magazine.toCharArray()){
            temp[ch-'a'] +=1;
        }
        for(char ch:ransomNote.toCharArray()){
            temp[ch-'a'] -=1;
        }
        for (int i : temp) {
            if (i!=0)
                return false;
        }
        return true;
    }

}
