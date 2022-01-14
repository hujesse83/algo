package zero_50.random.easy.Jan13;

import zero_50.random.ListNode;

/**
 * @author jesse.hu
 * @date 2022/1/13 19:06
 * @LeetCodeNo 203
 * 在一个链表中移除值为val的节点
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        // 返回新的头节点
        return dummy.next;
    }

    // 递归真的需要宏观去看, 不要吧自己递归进去了.
    public ListNode removeElementsV2(ListNode head, int val) {
        if (head==null){
            return null;
        }
        head.next = removeElementsV2(head.next,val);
        return head.val == val ? head.next : head;
    }
}
