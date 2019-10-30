package LinkedList;

/**
 * 单链表反转
 *
 * @author jerry
 * @create 2019/10/30 11:20
 */
public class singleLinkedListReverse {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode after = null;
        ListNode now  = head;
        while (now!=null) {
            ListNode next = now.next;
            now.next = after;
            after = now;
            now = next;
        }
        return after;
    }
}
