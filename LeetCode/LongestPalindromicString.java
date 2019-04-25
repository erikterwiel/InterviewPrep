class Solution {
  public String longestPalindrome(String s) {
    boolean[][] memo = new boolean[s.length()][s.length()];
    int longestI = 0;
    int longestJ = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {  
        if (j - i > longestJ - longestI && isPalindrome(s, i, j, memo)) {
          longestI = i;
          longestJ = j;
        }
      }
    }
    return s.substring(longestI, longestJ + 1);
  }

  private boolean isPalindrome(String s, int i, int j, boolean[][] memo) {
    if (memo[i][j]) {
      return true;
    }
    if (j - i <= 0) {
      memo[i][j] = true;
      return true;
    }
    if (s.charAt(i) != s.charAt(j)) {
      return false;
    }
    boolean result = isPalindrome(s, i + 1, j - 1, memo);
    if (result) {
      memo[i][j] = true;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome(args[0]));
  }
}