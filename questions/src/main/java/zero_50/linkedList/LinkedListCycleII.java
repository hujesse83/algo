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
}
