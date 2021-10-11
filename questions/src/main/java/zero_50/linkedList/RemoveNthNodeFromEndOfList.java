package zero_50.linkedList;

/**
 * No 19
 */
public class RemoveNthNodeFromEndOfList {
    // 方法一：暴力 倒数第几个   垃圾人写出的垃圾代码而已(me)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next!=null){
            size++;
            temp = temp.next;
        }
        temp = dummy;
        for (int i =1 ; i <size-n +1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    /**
     * 你能尝试使用一趟扫描实现吗
     */
    // 方法二用快慢指针
    //双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow  = dummy;
        ListNode fast = head;
        for (int i = 1; i <n ; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        // 此时slow为待删除的前驱节点
        slow.next = slow.next.next;
        return dummy.next;
    }
    // 方法三 递归return计数法  真牛逼哇
    int count = 0;
    public ListNode removeNthFromEndV3(ListNode head, int n) {
        if (head==null){
            return null;
        }
        head.next=removeNthFromEndV3(head.next,n);
        count++;
        if (count==n){
            return head.next;
        }
        return head;
    }
}
