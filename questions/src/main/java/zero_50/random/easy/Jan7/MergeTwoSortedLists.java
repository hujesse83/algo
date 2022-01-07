package zero_50.random.easy.Jan7;

import zero_50.random.ListNode;

/**
 * @author jesse.hu
 * @date 2022/1/7 09:53
 * @LeetCodeNo 21
 * @Des 合并二个有序链表. 不需要新建空间
 */
public class MergeTwoSortedLists {
    // 时间复杂度 O(m+n) 分别为二个链表的长度
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (list1!=null && list2!=null){
            if (list1.val <=list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // 合并后 list1 和list2 最多只有一个还没被合并完、我们直接将链表末尾指向合并未完的链表即可
        prev.next = list1==null?list2:list1;
        return dummy.next;
    }
    // Method2 递归 时间复杂度 O(m+n) 分别为二个链表的长度. 空间复杂度 O(m+n) 分别为二个链表的长度。
    // 从后往前操作就可以使用递归的特性
    public static ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if (list1.val< list2.val){
            list1.next = mergeTwoListsV2(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoListsV2(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s4 = new ListNode(4);
        s1.next = s2;
        s2.next = s4;
        ListNode p1 = new ListNode(1);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p3;
        p3.next = p4;
        mergeTwoListsV2(s1,p1);
    }
}
