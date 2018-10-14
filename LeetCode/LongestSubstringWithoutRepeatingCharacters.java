import java.util.HashSet;

class Solution {
  public int lengthOfLongestSubstring(String s) {

    if (s.length() == 0) {
      return 0;
    }

    char[] sArray = s.toCharArray();
    
    int start = 0;
    int end = 1;
    int longest = 0;

    HashSet<Character> seen = new HashSet<>();
    seen.add(sArray[0]);
    while (end < sArray.length) {
      if (seen.contains(sArray[end])) {
        longest = Math.max(longest, end - start);
        start = end;
        seen = new HashSet<>();
      }
      seen.add(sArray[end]);
      end++;
    }
    longest = Math.max(longest, end - start);
    return longest;
  }
}