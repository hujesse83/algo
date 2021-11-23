package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/23 20:07
 * LC 45
 * 哎 LC上面评论的都看不懂。我自己的见解是这样的：在能跳的范围里面，遍历找到下一次最大跳最远的
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int maxRange = 0;
        for (int i = 0; i <= maxRange; ) {
            count++;
            maxRange = i + nums[i];
            if (maxRange >= nums.length - 1) {
                return count;
            }
            i = findMax(nums, i, maxRange);
        }
        return 0;
    }

    public int findMax(int[] nums, int i, int j) {
        int num = 0;
        int max = getValue(nums, i + 1);
        for (int k = i + 1; k <= j; k++) {
            if (max <= getValue(nums, k)) {
                max = getValue(nums, k);
                num = k;
            }
        }
        return num;
    }

    public int getValue(int[] nums, int i) {
        return i + nums[i];
    }

    // 整体简洁代码。
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //int []nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGameII().jump(nums));
    }
}
