package zero_50.random.easy.Jan8;

import zero_50.random.ListNode;

/**
 * @author jesse.hu
 * @date 2022/1/9 00:53
 * @LeetCodeNo 83
 */
public class DeleteDuplicates {
    // 迭代法
    public ListNode deleteDuplicatesV1(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        while (cur.next!=null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    // 递归法 重要的事情说三遍
    // 递归真的要从宏观上考虑！！！
    //递归真的要从宏观上考虑！！！
    //递归真的要从宏观上考虑！！！
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val){
            head = head.next;
        }
        return head;
    }
}
