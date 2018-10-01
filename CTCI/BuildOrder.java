import java.util.ArrayList;
import java.util.HashMap;

import com.sun.corba.se.impl.orbutil.graph.Node;

import sun.misc.Queue;

public class BuildOrder {
  public int[] createBuildOrder(String[] projects, String[][] dependencies) {
    
    Node[] projectNodes = new Node[127];
    String buildLast = dependencies[0][1];

    for (String project : projects) {
      Node toAdd = new Node();
      toAdd.val = project;
      toAdd.seen = false;
      toAdd.adjacent = new ArrayList<Node>();
      projectNodes[project] = toAdd;
    }

    for (String[] dependancy : dependancies) {
      String project = dependancy[1];
      String dependantOn = dependancy[0];
      
      if (buildLast == dependantOn) {
        buildLast = project; 
      }

      projectNodes[project].adjacent.add(projectNodes[dependantOn]);
    }

    HashMap<String, Boolean> builtMap = new HashMap<>(); 

    ArrayList<String> buildOrder = new ArrayList<>();

    Queue<Node> toVisit = new Queue();
    toVisit.enqueue(projectNodes[buildFirst]);
    while (!toVisit.isEmpty()) {
      
      Node currentNode = toVisit.dequeue();
      currentNode.seen = true;
      builtMap.put(currentNode.val, true);
      builtOrder.add(0, currentNode.val);

      for (Node adjacentNode : currentNode.adjacent) {
        if (adjacentNode.seen) {
          throw new Error();
        }
        toVisit.enqueue(adjacentNode);
      }
    }

    for (String project : projects) {
      if (!builtMap.contains(project)) {
        throw new Error();
      }
    }

    return buildOrder.toArray();
  }
}