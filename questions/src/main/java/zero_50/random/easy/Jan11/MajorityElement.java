package zero_50.random.easy.Jan11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jesse.hu
 * @date 2022/1/11 12:00
 * @LeetCodeNo
 */
public class MajorityElement {
    //1、使用HashMa。 这种方式可以取得数组内出现次数最多的那个数、不仅仅是 n / 2;
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    // 2、排序 藏在管子里的蛇，身体长于管子的一半的话，砍中间就肯定能砍到
    public int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //3、摩尔投票法 关键考察
    public int majorityElementV3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


}
