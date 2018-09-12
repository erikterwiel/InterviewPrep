/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int solution = 0;
        int power = 0;
        ListNode node = l1;
        while (node != null) {
            solution += node.val * Math.pow(10, power);
            power++;
            node = node.next;
        }
        power = 0;
        node = l2;
        while (node != null) {
            solution += node.val * Math.pow(10, power);
            power++;
            node = node.next;
        }
        String stringSolution = String.valueOf(solution);
        for
        return solution;
    }
}
