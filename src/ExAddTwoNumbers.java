import org.w3c.dom.NodeList;

/**
 * Created by irilu on 7/28/2018.
 */
public class ExAddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize ListNode result head/node
        ListNode resultHead = new ListNode(0);
        ListNode current = resultHead;
        int rest = 0;
        ListNode p = l1;
        ListNode q = l2;

        while(p != null || q != null) {
//            System.out.println(p.val);
//            System.out.println(q.val);
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = x + y + rest;
            rest = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (rest > 0) {
            current.next = new ListNode(rest);
        }
        return resultHead.next;
    }
    public static void main(String[] args) {
        System.out.println("Exercise => 'Add two numbers'");
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
    }
}
