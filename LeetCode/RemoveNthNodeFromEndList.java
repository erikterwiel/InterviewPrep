/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ArrayList<ListNode> list = new ArrayList<>();
    
    ListNode temp = head;
    
    while (temp != null) {
      list.add(temp);
      temp = temp.next;
    }

    if (list.size() < 2) {
      return null;
    } else if (list.size() == n) {
      return list.get(1);
    } else if (n == 1) {
      list.get(list.size() - 2).next = null;
      return head;
    } else {
      list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
      return head;
    }

  }
}