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
  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    int low = Integer.MIN_VALUE;
    boolean isInit = false;
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (!isInit) {
          low = root.val;
          isInit = true;
        } else {
          if (root.val <= low) {
            return false;
          }
          low = root.val; 
        }
        root = root.right;
      }
    }
    return true;
  }
}