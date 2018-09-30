import sun.misc.Queue;

class RouteBetweenNodesBFS {
  public boolean checkRoute(Node start, Node end) {
    
    Queue<T> queue = new Queue();
    queue.add(start);
    
    while (!queue.isEmpty()) {
      Node single = queue.dequeue();
      if (single == end) {
        return true;
      }
      single.visited = true;
      for (Node node : single) {
        if (!node.visited) {
          queue.enqueue(node);
        }
      }
    }
    return false;
  }
}