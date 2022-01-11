package zero_50.random.easy.Jan11;

/**
 * @author jesse.hu
 * @date 2022/1/11 11:33
 * @LeetCodeNo 168 \
 * 从1 —— 26 的进制转换问题. 减一是关键啊！！
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber>0){
            columnNumber--;
            int digit = columnNumber % 26;
            sb.append((char)(digit+'A'));
            columnNumber /=26;
        }
        return sb.reverse().toString();
    }
}
