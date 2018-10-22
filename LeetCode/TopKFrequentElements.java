import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> numToFrequency = new HashMap<>();
    for (int num : nums) {
      if (!numToFrequency.containsKey(num)) {
        numToFrequency.put(num, 1);
      } else {
        numToFrequency.put(num, numToFrequency.get(num) + 1);
      }
    }
    ArrayList<ArrayList<Integer>> frequencyToNumbers = new ArrayList<>();
    for (int i = 0; i < nums.length + 1; i++) {
      frequencyToNumbers.add(new ArrayList<>());
    }
    for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
      frequencyToNumbers.get(entry.getValue()).add(entry.getKey());
    }
    List<Integer> solution = new ArrayList<>();
    for (int i = frequencyToNumbers.size() - 1; i > 0; i--) {
      List<Integer> currentFrequency = frequencyToNumbers.get(i);
      while (currentFrequency.size() > 0 && k > 0) {
        solution.add(currentFrequency.get(currentFrequency.size() - 1));
        currentFrequency.remove(currentFrequency.size() - 1);
        k--;
      }
      if (k == 0) {
        break;
      }
    }
    return solution;
  }
}