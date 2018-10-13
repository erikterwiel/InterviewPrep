import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

class LFUCache {

  HashMap<Integer, Integer> keyToVal = new HashMap<>();
  HashMap<Integer, Integer> keyToOccurences = new HashMap<>();
  HashMap<Integer, LinkedHashSet<Integer>> occurencesToKeyOrder = new HashMap<>();
  int size = 0;
  int capacity = 0;
  int minOccurance = 0;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    occurencesToKeyOrder.put(0, new LinkedHashSet<>());
  }
  
  public int get(int key) {
    if (!keyToVal.containsKey(key)) {
      return -1;
    }

    addOccurence(key);
    return keyToVal.get(key);  
  }
  
  public void put(int key, int value) {

    if (capacity == 0) {
      return;
    }
    
    if (keyToOccurences.containsKey(key)) {
      keyToVal.put(key, value);
      addOccurence(key);
      return;
    }
    
    if (size == capacity) {
      LinkedHashSet<Integer> minOccurenceSet = occurencesToKeyOrder.get(minOccurance);
      Iterator<Integer> minOccuranceIterator = minOccurenceSet.iterator();
      int leastFreqUsed = minOccuranceIterator.next();
      keyToVal.remove(leastFreqUsed);
      keyToOccurences.remove(leastFreqUsed);
      minOccurenceSet.remove(leastFreqUsed);
      size--;
    }
    
    minOccurance = 0;
    keyToVal.put(key, value);
    keyToOccurences.put(key, 0);
    occurencesToKeyOrder.get(0).add(key);
    size++;
  }

  public void addOccurence(int key) {
    
    int occurences = keyToOccurences.get(key);
    occurencesToKeyOrder.get(occurences).remove(key);
    if (occurences == minOccurance && occurencesToKeyOrder.get(occurences).size() == 0) {
      minOccurance++;
    } 

    occurences++;
    keyToOccurences.put(key, occurences);
    if (!occurencesToKeyOrder.containsKey(occurences)) {
      occurencesToKeyOrder.put(occurences, new LinkedHashSet<>());
    }
    occurencesToKeyOrder.get(occurences).add(key);
  }
}

/**
* Your LFUCache object will be instantiated and called as such:
* LFUCache obj = new LFUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/