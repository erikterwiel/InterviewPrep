class Solution {

  class Node {
    int val;
    ArrayList<Node> children = new ArrayList<>();
  
    public Node(int x) {
      val = x;
    }
  }

  class Graph {
    HashMap<Integer, Nodes> nodes = new HashMap<>();
    int size = 0;

    public Node getNode(int key) {
      if (!nodes.containsKey(key)) {
        nodes.put(key, new Node(key));
        size++;
      }
      return nodes.get(key);
    }

    public void addEdge(int from, int to) {
      getNode(from).children.add(getNode(to));
    }
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graphEdges) {
    Graph graph = new Graph();
    for (int i = 0; i < graphEdges.length; i++) {
      for (int j = 0; j < graphEdges[i].length; j++) {
        graph.addEdge(i, j);
      }
    }

    return search(graph.getNode(0), graph.getNode(graph.size - 1));
  }

  public List<List<Integer>> search(Node node, List<Integer> currentPath, Node target) {
    currentPath.add(node.val);
  }
}