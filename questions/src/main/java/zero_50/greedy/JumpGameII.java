package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/23 20:07
 * LC 45
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int count = 0;
        int maxRange = 0 ;
        for (int i = 0; i <=maxRange; ) {
            count++;
            maxRange = i+nums[i];
            if (maxRange>= nums.length-1){
                return count;
            }
            i = findMax(nums,i,maxRange);
        }
        return 0;
    }
    public int findMax(int []nums,int i,int j){
        int num = 0;
        int max  = getValue(nums,i+1);
        for (int k = i+1; k <=j ; k++) {
            if (max<=getValue(nums,k)){
                max = getValue(nums,k);
                num = k;
            }
        }
        return num;
    }
    public int getValue(int []nums,int i){
        return i+nums[i];
    }

    public static void main(String[] args) {
        //int []nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        int []nums = {2,3,1,1,4};
        System.out.println(new JumpGameII().jump(nums));
    }
}
