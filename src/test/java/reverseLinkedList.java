import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reverse Linked List 调试
 *
 * @author jerry
 * @create 2019/10/31 8:35
 */
public class reverseLinkedList {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().reverseList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    /**
     * code
     */
    private static class Solution {
        /**
         * 迭代
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null; //前指针节点
            ListNode curr = head; //当前指针节点
            //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
            while (curr != null) {
                ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
                curr.next = prev; //将当前节点指向它前面的节点
                prev = curr; //前指针后移
                curr = nextTemp; //当前指针后移
            }
            return prev;
        }

        /**
         * 递归
         */
//        public ListNode reverseList(ListNode head) {
//            return reverse(null, head);// prev = null; curr = head; 这两步简化了
//        }
//
//        private static ListNode reverse(ListNode prev, ListNode curr) {
//            if (curr==null) return prev;
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            return reverse(curr, nextTemp);// prev = curr; curr = nextTemp; 这两步简化了
//        }
    }

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x ;}
    }

}
