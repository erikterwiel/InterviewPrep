import java.util.List;

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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> seen = new ArrayList<>();
    search(root, result, seen, sum);
    return result;
  }

  public void search(TreeNode node, List<List<Integer>> result, List<Integer> seen, int currentNum) {
    
    if (node == null) {
      return;
    }

    seen.add(node.val);
    currentNum -= node.val;

    if (node.left == null && node.right == null && currentNum == 0) {
      result.add(new ArrayList<Integer>(seen));
    } else {
      search(node.left, result, seen, currentNum);
      search(node.right, result, seen, currentNum);
    }
    
    seen.remove(seen.size() - 1);
  }
}