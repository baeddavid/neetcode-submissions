/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        /*
        i, n - i, i + 1, n - i + 1...
        */

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode fastHead = slow.next;
        slow.next = null;

        fastHead = reverseList(fastHead);
        ListNode sentinel = new ListNode(-1);
        ListNode sCurr = sentinel;
        slow = head;
        boolean leftTurn = true;

        while(slow != null || fastHead != null) {
            if(leftTurn && slow != null) {
                sCurr.next = slow;
                slow = slow.next;
                sCurr = sCurr.next;
                leftTurn = false;
            } else if(fastHead != null) {
                sCurr.next = fastHead;
                fastHead = fastHead.next;
                sCurr = sCurr.next;
                leftTurn = true;
            } else {
                leftTurn = true;
            }
        }
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
