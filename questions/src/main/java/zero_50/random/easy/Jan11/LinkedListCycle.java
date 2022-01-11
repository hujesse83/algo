package zero_50.random.easy.Jan11;

import zero_50.random.ListNode;

/**
 * @author jesse.hu
 * @date 2022/1/11 09:58
 * @LeetCodeNo 141
 * 判断一个链表是否成环
 */
public class LinkedListCycle {
    // 1、同位素标记法
    public boolean hasCycle(ListNode head) {
        while (head!=null){
            if (head.val == Integer.MAX_VALUE){
                return true;
            }
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }
    // 2、快慢指针法
    /**
     *
     */
    public boolean hasCycleV2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 空链表、单节点链表一定不会有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针，一次移动两步
            slow = slow.next;      // 慢指针，一次移动一步
            if (fast == slow) {   // 快慢指针相遇，表明有环
                return true;
            }
        }
        return false; // 正常走到链表末尾，表明没有环
    }
}
