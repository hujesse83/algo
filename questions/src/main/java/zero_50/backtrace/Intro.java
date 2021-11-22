package zero_50.backtrace;

public interface Intro {
    /**
     * 回朔理论基础：1、回溯是递归的副产品，只要有递归就会有回溯
     *             2、回朔是一个纯暴力的方法
     *             通常使用 循环+递归
     *             回溯法解决的问题都可以抽象为树形结构，集合的大小就构成了树的宽度，递归的深度，都构成的树的深度。
     */
    //优化回溯算法只有剪枝一种方法
    /**
     *     // 回溯比递归更难，所以我们只需要确定
     *     1递归函数的返回值以及参数，
     *     2回溯函数终止条件，
     *     3单层搜索的过程
     */
//    default void backtracking(参数) {
//        if (终止条件) {
//            存放结果;
//            return;
//        }
//
//        for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
//            处理节点;
//            backtracking(路径，选择列表); // 递归
//            回溯，撤销处理结果
//        }
//    }
}
