package zero_50.random.easy.Jan8;

/**
 * @author jesse.hu
 * @date 2022/1/8 16:58
 * @LeetCodeNo 66
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index>=0){
            if (digits[index]!=9){
                digits[index]+=1;
                break;
            }
            digits[index] = 0;
            index--;
        }
        if (digits[0]==0){
            int []res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
