package zero_50.random.easy.Jan10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/10 11:22
 * @LeetCodeNo 118
 * @Desc 杨辉三角
 */
public class PascalTriangle {
    // 1、 数学直观形式
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0;i<numRows;i++){
            List<Integer> item = new ArrayList<>();
            for (int j = 0;j<=i;j++){
                if (j==0 || j== i){
                    item.add(1);
                }else{
                    item.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(item);
        }
        return res;
    }
}
