package zero_50.linkedList;

import java.util.HashMap;

public class LinkedListCycleII {
    /**
     * 方法一：哈希法简单粗暴
     */
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        ListNode temp = cur;
        int k = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (temp!=null){
            if (map.containsKey(temp)){
                return temp;
            }else {
                map.put(temp,k++);
            }
            temp = temp.next;

        }
       return null;
    }
    /**
     * 方法二会修改链表
     */
    public ListNode detectCycleV2(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode temp = new ListNode(-1);
        ListNode cur = head;
        ListNode p ;
        while (cur!=null){
            if (cur.next == temp){
                return cur;
            }
            p = cur.next;
            cur.next = temp;
            cur = p;
        }
        return null;
    }
}
