package zero_50.random.easy.Jan11;

import zero_50.random.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jesse.hu
 * @date 2022/1/11 10:42
 * @LeetCodeNo
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA !=tempB){
            tempA =tempA==null?headB:tempA.next;
            tempB = tempB==null?headA:tempB.next;
        }
        return tempA;
    }

    // Method 2、Hash法 很慢 空间还耗费O(N)
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp!=null){
            if(visited.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
