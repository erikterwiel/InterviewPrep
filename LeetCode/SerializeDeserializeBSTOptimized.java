/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // public class TreeNode {
  //   int val;
  //   TreeNode left;
  //   TreeNode right;
  //   TreeNode(int x) {
  //     val = x;
  //   }
  // }

  public class Result {
    String string = "";
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return preOrderTraverse(root, new Result()).string;
  }

  public Result preOrderTraverse(TreeNode node,  Result result) {
    if (node == null) {
      return result;
    }
    if (!result.string.equals("")) {
      result.string += ",";
    }
    result.string += node.val;
    preOrderTraverse(node.left, result);
    preOrderTraverse(node.right, result);
    return result;
  } 

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("")) {
      return null;
    }
    String[] splitData = data.split(",");
    int[] splitIntData = new int[splitData.length];
    
    for (int i = 0; i < splitData.length; i++) {
      splitIntData[i] = Integer.parseInt(splitData[i]);
    }


    TreeNode root = new TreeNode(splitIntData[0]);
    return makeTree(root, splitIntData, 1, splitIntData.length);
  }

  public TreeNode makeTree(TreeNode root, int[] data, int min, int max) {
    
    int leftIndex = min - 1;
    int rightIndex = max;
    
    for (int i = min; i < max; i++) {
      if (data[i] < root.val) {
        leftIndex = i;
        break;
      }
    }

    for (int i = min; i < max; i++) {
      if (data[i] > root.val) {
        rightIndex = i;
        break;
      }
    }

    if (leftIndex != min - 1) {
      root.left = new TreeNode(data[leftIndex]);
      makeTree(root.left, data, leftIndex + 1, rightIndex);
    }

    if (rightIndex != max) {
      root.right = new TreeNode(data[rightIndex]);
      makeTree(root.right, data, rightIndex, max);
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));