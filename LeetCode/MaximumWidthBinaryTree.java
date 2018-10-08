import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  
  class Pair {
    int left = -1;
    int right = -1;
    
    public int getWidth() {
      return right - left + 1;
    }
  }

  public int widthOfBinaryTree(TreeNode root) {
    
    HashMap<Integer, Pair> map = new HashMap<>();
    findSolution(root.left, map, 1, 1);
    findSolution(root.right, map, 1, 2);

    int maxWidth = 1;
    for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
      int currentWidth = entry.getValue().getWidth();
      System.out.printf("Left = %d, Right = %d\n", entry.getValue().left, entry.getValue().right);
      System.out.println(currentWidth);
      System.out.println("");
      if (currentWidth > maxWidth) {
        maxWidth = currentWidth;
      }
    }

    return maxWidth;
  }
  
  public void findSolution(TreeNode root, HashMap<Integer, Pair> map, int level, int currentPos) {

    if (root == null) {
      return;
    }

    System.out.printf("Level: %d\n", level);
    System.out.printf("Val: %d\n\n", root.val);

    if (!map.containsKey(level)) {
      map.put(level, new Pair());
    }

    Pair levelPair = map.get(level);

    if (levelPair.left == -1 || currentPos < levelPair.left) {
      levelPair.left = currentPos;
    }

    if (levelPair.right == -1 || currentPos > levelPair.right) {
      levelPair.right = currentPos;
    }

    findSolution(root.left, map, level + 1, currentPos * 2 - 1);
    findSolution(root.right, map, level + 1, currentPos * 2);
  }
}