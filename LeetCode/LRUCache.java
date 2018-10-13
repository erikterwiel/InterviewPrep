import java.util.HashMap;

class LRUCache {

  HashMap<Integer, Node> map = new HashMap<>(); 
  int capacity;
  int size = 0;
  Node first = null;
  Node last = null;

  class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }
    
  public int get(int key) {
    
    if (!map.containsKey(key)) {
      return -1;
    }

    Node target = map.get(key);
    
    if (size == 1) {
      return target.val;
    }

    access(target);

    return target.val;
  }

  public void access(Node target) {
    
    if (size == 1) {
      return;
    }

    if (target == first) {
      first = target.next;
      first.prev = null;
      last.next = target;
      target.prev = last;
      target.next = null;
      last = target;
    } else if (target != last) {
      target.prev.next = target.next;
      target.next.prev = target.prev;
      last.next = target;
      target.prev = last;
      target.next = null;
      last = target;
    }
  }
    
  public void put(int key, int value) {
    
    if (map.containsKey(key)) {
      Node target = map.get(key);
      target.val = value;
      access(target);
      return;
    }

    if (size == 0) {
      Node toAdd = new Node(key, value);
      toAdd.prev = null;
      toAdd.next = null;
      first = toAdd;
      last = toAdd;
      size++;
      map.put(key, toAdd);
      return;
    }

    Node toAdd = new Node(key, value);
    toAdd.prev = last;
    toAdd.next = null;
    last.next = toAdd;
    last = toAdd;
    map.put(key, toAdd);

    if (size < capacity) {
      size++;
      return;
    }

    Node toDelete = first;
    first.next.prev = null;
    first = first.next;
    map.remove(toDelete.key);

  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */