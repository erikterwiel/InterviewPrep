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
  public void flatten(TreeNode root) {
    solve(root);
  }

  public TreeNode solve(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = solve(root.left);
    TreeNode right = solve(root.right);
    if (left != null) {
      root.right = left;
      while (left.right != null) {
        left = left.right;
      }
      left.right = right;
    } else {
      root.right = right;
    }
    root.left = null;
    return root;
  } 
}