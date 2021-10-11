package zero_50.linkedList;
/**No206
 * http://c.biancheng.net/view/8105.html
 * 四种方法实现单链表的反转
 */

public class ReverseLinkedList {

  /**
   * 方法一：迭代反转链表
   * 当时做的时候总是对end出现空指针 需要提中止
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode beg = null;
    ListNode mid = head;
    ListNode end = head.next;
    while (true) {
      mid.next = beg;
      if (end == null) {
        break;
      }
      beg = mid;
      mid = end;
      end = end.next;
    }
    return mid;
  }

  /**
   * 方法二：就地反转
   */
  public ListNode reverseListV3(ListNode head) {
    if (head==null ||head.next==null){
      return head;
    }
    ListNode beg =head;
    ListNode end = head.next;
    while (end!=null) {
      // 将end从链表拿掉
      beg.next = end.next;
      end.next = head;
      head = end;
      end = beg.next;
    }
    return head;
  }

  /**
   * 第三种：递归反转链表
   */
  public ListNode reverseListV4(ListNode head) {
    // 空链 或者找到了最后一个节点
    if(head==null || head.next==null){
      return head;
    }
    // 这里的newHead指向的一直都是尾节点
    ListNode newHead = reverseListV4(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
  /**
   * 第四种 头插法是指在原有链表的基础上，依次将位于链表头部的节点摘下，然后采用从头部插入的方式生成一个新链表.
   */
  public ListNode reverseListV5(ListNode head) {
    ListNode newHead = null;
    ListNode temp = null;
    if (head==null || head.next==null){
      return head;
    }
    while (head!=null){
      temp = head;
      head = head.next;

      // 把摘下来的节点放入新链表头插
      temp.next = newHead;
      newHead = temp;
    }
    return newHead;
  }
}
