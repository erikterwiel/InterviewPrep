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
  
  public class Result {
    int number = 0;
  }

  public int sumNumbers(TreeNode root) {
    
    if (root == null) {
      return 0;
    }

    Result result = new Result();
    getSolution(root, "", result);
    return result.number;
  }

  public void getSolution(TreeNode node, String currentString, Result result) {
    
    if (node == null) {
      return;
    }
    
    currentString += Integer.toString(node.val);
    
    if (node.left == null && node.right == null) {
      result.number += Integer.parseInt(currentString);
    }

    getSolution(node.left, currentString, result);
    getSolution(node.right, currentString, result);
  }
}