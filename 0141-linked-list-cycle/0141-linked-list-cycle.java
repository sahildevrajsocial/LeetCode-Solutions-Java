/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode x = head;
        ListNode y = head;

        while (x != null && y != null && y.next!=null) {
            x = x.next;
            y = y.next.next;

            if (x == y) {
                return true;
            }
        }
        return false;
    }
}