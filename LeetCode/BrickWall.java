import java.util.HashMap;

class Solution {
  public int leastBricks(List<List<Integer>> wall) {

    if (wall.size() == 0 || wall.get(0).size() == 0) {
      return 0;
    }

    HashMap<Integer, Integer> betweenGaps = new HashMap<>();
    
    for (int i = 0; i < wall.size(); i++) {
      int currentPos = -1;
      for (int j = 0; j < wall.get(i).size() - 1; j++) {
        currentPos += wall.get(i).get(j);
        betweenGaps.put(currentPos, betweenGaps.getOrDefault(currentPos, 0) + 1);
      }
    }

    int highestGap = 0;
    for (int gaps : betweenGaps.values()) {
      highestGap = Math.max(highestGap, gaps);
    }

    return wall.size() - highestGap;
  }
}