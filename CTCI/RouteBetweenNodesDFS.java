class RouteBetweenNodesDFS {

  public class Node {
    Node[] adjacent;
    int val;
    boolean visited = false;
  }

  public boolean checkRoute(Node root, Node start, Node end) {
    return dfs(root, start, end);
  }

  public static boolean dfs(Node root, Node start, Node end) {
    boolean status = false;
    
    if (root == null) {
      return false;
    }

    if (start == end) {
      status = true;
    }

    root.visited = true;
    for (Node node : root.adjacent) {
      if (node.visited == false) {
        dfs(node, start, end);
      }
    }
    
    return status;
  }
}