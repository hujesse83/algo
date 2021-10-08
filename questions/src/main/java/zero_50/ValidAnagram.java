package zero_50;

/**
 * 242
 * Anagram：相同字母异序词
 * 需要定义一个多大的数组呢，定一个数组叫做record，大小为26 就可以了，初始化为0，因为字符a到字符z的ASCII也是26个连续的数值。
 * 需要把字符映射到数组也就是哈希表的索引下表上，因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下表0，相应的字符z映射为下表25。
 * 再遍历 字符串s的时候，只需要将 s[i] - ‘a’ 所在的元素做+1 操作即可，并不需要记住字符a的ASCII，只要求出一个相对数值就可以了。 这样就将字符串s中字符出现的次数，统计出来了。
 * 那看一下如何检查字符串t中是否出现了这些字符，同样在遍历字符串t的时候，对t中出现的字符映射哈希表索引上的数值再做-1的操作。
 */

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] record = new int[26];
        for (Character c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (Character c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
