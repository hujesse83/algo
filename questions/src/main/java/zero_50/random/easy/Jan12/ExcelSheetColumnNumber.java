package zero_50.random.easy.Jan12;


/**
 * @author jesse.hu
 * @date 2022/1/12 16:43
 * @LeetCodeNo 171
 * @ 将A-Z 转化为数字
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int times = columnTitle.length() - 1;
        for (char ch : columnTitle.toCharArray()) {
            int digit = ch - 'A' + 1;
            ans += Math.pow(26, times) * digit;
            times--;
        }
        return ans;
    }
}
