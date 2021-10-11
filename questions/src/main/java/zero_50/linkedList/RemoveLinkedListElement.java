package zero_50.linkedList;

/**
 * No 203
 */
public class RemoveLinkedListElement {
    public static void main(String[] args) {

    }

    /**
     * 删除节点关键的是找到待删除节点的前驱 所以我们使用dummy 指向第一个节点head
     */
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        void display(ListNode head){
            while (head!=null){
                System.out.println(val);
                head= head .next;
            }
        }
    }

}
