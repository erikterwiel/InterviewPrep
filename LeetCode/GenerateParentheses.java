class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> results = new ArrayList<>();
    recurse("", n, n, results);
    return results;
  }

  private void recurse(String current, int numL, int numR, List<String> results) {
    if (numL == 0 && numR == 0) {
      results.add(current);
      return;
    }
    if (numL == 0) {
      recurse(current + ")", numL, numR - 1, results);
    } else if (numL == numR) {
      recurse(current + "(", numL - 1, numR, results);
    } else {
      recurse(current + "(", numL - 1, numR, results);
      recurse(current + ")", numL, numR - 1, results);
    }
  }
}