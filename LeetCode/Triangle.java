class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> minimumValues = triangle.get(triangle.size() - 1);
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        minimumValues.set(j, Math.min(minimumValues.get(j), minimumValues.get(j + 1)) + triangle.get(i).get(j));
      }
    }
    return minimumValues.get(0);
  }
}