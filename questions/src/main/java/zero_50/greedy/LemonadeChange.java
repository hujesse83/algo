package zero_50.greedy;


/**
 * LC860
 *
 * @Author huJesse
 * @Date 2021/11/26 15:13
 * The greedy idea here is that we use large coins to change as much as possible  to leave more small coins in our hands.
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            }  // i=20的意思
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

}
