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
    String result = preOrderTraverse(root, new Result()).string;
    System.out.println(result);
    return result;
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
      System.out.println(splitData[i]);
      splitIntData[i] = Integer.parseInt(splitData[i]);
    }

    System.out.println("=========");

    TreeNode root = new TreeNode(splitIntData[0]);
    for (int x : splitIntData) {
      System.out.println(x);
    }
    System.out.println("@@");
    return makeTree(root, Arrays.copyOfRange(splitIntData, 1, splitIntData.length));
  }

  public TreeNode makeTree(TreeNode root, int[] data) {
    
    for (int x : data) {
      System.out.println(x);
    }

    int leftIndex = -1;
    int rightIndex = data.length;
    
    for (int i = 0; i < data.length; i++) {
      if (data[i] < root.val) {
        leftIndex = i;
        break;
      }
    }

    for (int i = 0; i < data.length; i++) {
      if (data[i] > root.val) {
        rightIndex = i;
        break;
      }
    }

    System.out.printf("leftIndex = %d\n", leftIndex);
    System.out.printf("rightIndex = %d\n", rightIndex);

    if (leftIndex != -1) {
      root.left = new TreeNode(data[leftIndex]);
      makeTree(root.left, Arrays.copyOfRange(data, leftIndex + 1, rightIndex));
    }

    if (rightIndex != data.length) {
      root.right = new TreeNode(data[rightIndex]);
      makeTree(root.right, Arrays.copyOfRange(data, rightIndex, data.length));
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));