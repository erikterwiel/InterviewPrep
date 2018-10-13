import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class RandomizedSet {

  HashMap<Integer, Integer> valToIndex;
  ArrayList<Integer> vals;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    valToIndex = new HashMap<>();
    vals = new ArrayList<>();
  }
  
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      return false;
    }
    valToIndex.put(val, vals.size());
    vals.add(val);
    return true;
  }
  
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (valToIndex.containsKey(val)) {
      int valIndex = valToIndex.get(val);
      vals.set(valIndex, vals.get(vals.size() - 1));
      valToIndex.put(vals.get(valIndex), valIndex);
      vals.remove(vals.size() - 1);
      valToIndex.remove(val);
      return true;
    }
    return false;
  }
  
  /** Get a random element from the set. */
  public int getRandom() {
    return vals.get((int) (Math.random() * vals.size()));
  }
}

/**
* Your RandomizedSet object will be instantiated and called as such:
* RandomizedSet obj = new RandomizedSet();
* boolean param_1 = obj.insert(val);
* boolean param_2 = obj.remove(val);
* int param_3 = obj.getRandom();
*/