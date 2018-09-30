import java.util.ArrayList;

public class ListOfDepths {
  public Node[] solution(Node root) {
    ArrayList<Node> linkedLists = new ArrayList<>();
    linkedLists = traverse(root, 0, linkedLists);
  }

  public ArrayList<Node> traverse(Node node, int height, ArrayList<Node> linkedLists) {
    if (node != null) {
      linkedLists = addNodeToList(linkedLists, node, height);
    }
    traverse(node.left, height + 1, linkedLists);
    traverse(node.right, height + 1, linkedLists);
  }

  public ArrayList<Node> addNodeToList(ArrayList<Node> linkedLists, Node node, int height) {
    Node start = linkedLists.get(height);
    Node temp = start;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = node;
    linkedLists.set(height, start);
    return linkedLists;
  }
}