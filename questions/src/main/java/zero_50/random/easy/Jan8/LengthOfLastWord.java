package zero_50.random.easy.Jan8;

/**
 * @author jesse.hu
 * @date 2022/1/8 16:34
 * @LeetCodeNo
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("moon"));
    }
}
