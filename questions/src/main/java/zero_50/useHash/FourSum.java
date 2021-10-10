package zero_50.useHash;

import java.util.HashMap;

/**
 * 454
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 */

public class FourSum {
    public static void main(String[] args) {
        int A[] = {1,2};
        int B[] = {-1,-2};
        int C[] = {-1,2};
        int D[] = {0,2};
        System.out.println(fourSumCount(A, B, C, D));
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int a : A) {
            for (int b : B) {
                // 这句话真的太叼了
                map.put(a+b,map.get(a+b)==null?1:map.get(a+b)+1);
            }
        }
        int counts = 0;
        for (int i : C) {
            for (int j : D) {
                if(map.containsKey(-i-j)==true){
                    counts+=map.get(-i-j);
                }
            }
        }
        return counts;
    }

}
