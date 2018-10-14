import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    return solve(s, new HashSet<String>(wordDict), new HashMap<>()); 
  }

  public boolean solve(String s, HashSet<String> dict, HashMap<String, Boolean> memory) {
    
    if (memory.containsKey(s)) {
      return memory.get(s);
    }

    StringBuilder currentString = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {

      char letter = s.charAt(i);
      currentString.append(letter);
      if (dict.contains(currentString.toString())) {

        if (currentString.toString().equals(s)) {
          memory.put(s, true);
          return true;
        }

        if (solve(s.substring(i + 1, s.length()), dict, memory)) {
          memory.put(s, true);
          return true;
        }

      }
    }

    memory.put(s, false);
    return false;
  }
}