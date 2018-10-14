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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int[] valueToIndex = new int[preorder.length];
    for (int i = 0; i < inorder.length; i++) {
      valueToIndex[inorder[i]] = i;
    }
    return build(preorder, inorder, 0, inorder.length - 1, 0, valueToIndex);
  }

  public TreeNode build(int[] preorder, int[] inorder, int start, int end, int preIndex, int[] valueToIndex) {
    TreeNode node = new Node(preorder[preIndex]);
    int mid = valueToIndex[preorder[preIndex]];
    node.left = build(preorder, inorder, start, mid, preIndex + 1, valueToIndex);
    node.right = build(preorder, inorder, mid + 1, end, preIndex + 2);
    return node;
  }
}