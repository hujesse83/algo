package zero_50.random;


/**
 * @author jesse.hu
 * @date 2022/1/7 09:54
 * @LeetCodeNo
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {
    }
    public ListNode(int val) {
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
