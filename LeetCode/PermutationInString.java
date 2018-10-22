import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean checkInclusion(String s1, String s2) {

    if (s1.length() > s2.length()) {
      return false;
    }

    HashMap<Character, Integer> s1Count = new HashMap<>();
    for (char letter : s1.toCharArray()) {
      s1Count.put(letter, s1Count.getOrDefault(letter, 0) + 1);
    }

    HashMap<Character, Integer> s2Count = new HashMap<>();
    int i = 0;
    int j = s1.length() - 1;
    for (int x = 0; x < s1.length(); x++) {
      s2Count.put(s2.charAt(x), s2Count.getOrDefault(s2.charAt(x), 0) + 1);
    }

    while (j < s2.length()) {
      boolean good = true;
      for (Map.Entry<Character, Integer> entry : s1Count.entrySet()) {
        if (entry.getValue() != s2Count.getOrDefault(entry.getKey(), 0)) {
          good = false;
          break;
        }
      }
      if (good) {
        return true;
      }
      s2Count.put(s2.charAt(i), s2Count.get(s2.charAt(i)) - 1);
      i++;
      j++;
      if (j < s2.length()) {
        s2Count.put(s2.charAt(j), s2Count.getOrDefault(s2.charAt(j), 0) + 1);
      }
    }

    return false;
  }
}