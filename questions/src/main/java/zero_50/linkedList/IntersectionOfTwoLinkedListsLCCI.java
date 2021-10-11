package zero_50.linkedList;

/**
 * 面
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，
 * 如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * 他们开始相交的地方是一段重复的
 */
public class IntersectionOfTwoLinkedListsLCCI {
    // 方法一：只要以相同的速度前进，就一定有机会遇见你
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        // 要么相遇即节点相等，要么都为空即无缘无分，最终都能跳出感情的死循环。
        while (curA != curB) {
            // 两人以相同的速度（一次一步）沿着各自的路径走，当走完各自的路时，再“跳”至对方的路上。（起点平齐速度相同，终点即为相遇点）
            // a+c+b+c = b+c+a+c
            curA = (curA == null ? headB : curA.next);
            curB = (curB == null ? headA : curB.next);
        }
        return curA;
    }

    // 方法二 对齐二串
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (lenA>=lenB){
            int diff = lenA-lenB;
            while (diff-->0) curA = curA.next;
        }
        if (lenB>lenA){
            int diff = lenB-lenA;
            while (diff-->0) curB=curB.next;
        }
        while (curA!=null && curB!=null){
            if (curA==curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
       return null;
    }
}
