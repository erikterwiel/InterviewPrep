import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
  
    RandomListNode copyHead = getNode(map, head);

    RandomListNode temp = head;
    RandomListNode copyTemp = getNode(map, head);

    while(temp != null) {
      copyTemp.next = getNode(map, temp.next);
      copyTemp.random = getNode(map, temp.random);
      temp = temp.next;
      copyTemp = copyTemp.next;
    }

    return copyHead;
  }

  public RandomListNode getNode(HashMap<RandomListNode, RandomListNode> map, RandomListNode original) {
    
    if (original == null) {
      return null;
    }

    if (!map.containsKey(original)) {
      RandomListNode copy = new RandomListNode(original.label);
      map.put(original, copy);
    }
    
    return map.get(original);
  }
}