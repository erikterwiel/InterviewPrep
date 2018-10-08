class Solution {
  public boolean isAnagram(String s, String t) {
    int[] map = new int[128];
    for (char letter : s.toCharArray()) {
      map[letter]++;
    }

    for (char letter : t.toCharArray()) {
      map[letter]--;
    }

    for (int letterCount : map) {
      if (letterCount != 0) {
        return false;
      }
    }

    return true;
  }
}