package zero_50.linkedList;
// No 24
public class SwapNodesInPairs {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 自己写的 用了四个指针 严格来说emm不太简洁  但是我看了答案 还是我的好理解
     */
    public ListNode swapPairs(ListNode head) {
          if(head==null ||head.next==null){
              return head;
          }
          ListNode newHead = head.next;
          ListNode beg = new ListNode(-1);
          ListNode mid = head;
          ListNode end = head.next;
          ListNode temp ;

          while (true){
              temp = end.next;
              end.next = mid;
              beg.next = end;
              mid.next = temp;
              if (temp.next==null || temp==null){
                  break;
              }
              beg = mid;
              mid = temp;
              end = mid.next;
          }
          return newHead;
    }
    /**
     * 递归  因为我们每每交换一对节点都是重复的工作采用递归代码更简洁
     */
    public ListNode swapPairsv2(ListNode head) {
        if (head==null ||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode n = cur.next;
        cur.next = pre;
        pre.next = swapPairsv2(n);
        return cur;
    }

}
