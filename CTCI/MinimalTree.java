import java.util.Arrays;

public class MinimalTree {
  public Node createTree(int[] input) {
    return addChildren(input, 0, input.length - 1);
  }

  public Node addChildren(int[] input, int start, int end) {
    int mid = (start + end) / 2;
    Node node = new Node();
    node.left = addChildren(input, start, mid - 1);
    node.right = addChildren(input, mid + 1, end);
    return node;
  }
}