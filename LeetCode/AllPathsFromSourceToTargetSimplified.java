class Solution {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    return search(graph, 0, new ArrayList<Integer>());
  }

  public List<List<Integer>> search(int[][] graph, int nodeNum, List<Integer> currentPath) {
    
    currentPath.add(nodeNum);
    List<List<Integer>> toReturn = new ArrayList<>();

    if (nodeNum == graph.length - 1) {
      toReturn.add(currentPath);
      return toReturn;
    }
    
    for (int nextNode : graph[nodeNum]) {
      List<List<Integer>> paths = search(graph, nextNode, new ArrayList<Integer>(currentPath));
      for (List<Integer> path : paths) {
        toReturn.add(path);
      }
    }

    return toReturn;
  }
}