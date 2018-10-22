class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<Integer>();
      for (int j = 0; j < i + 1; j++) row.add(0);
      row.set(0, 1);
      row.set(i, 1);
      if (i > 1) {
        List<Integer> aboveRow = triangle.get(i - 1);
        for (int j = 1; j < i; j++) {
          row.set(j, aboveRow.get(j - 1) + aboveRow.get(j));
        }
      }
      triangle.add(row);
    }
    return triangle;
  }
}