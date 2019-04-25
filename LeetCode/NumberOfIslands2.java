import java.util.concurrent.atomic.AtomicInteger;

class Solution {
  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int[][] seen = new int[grid.length][grid[0].length];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && seen[i][j] == 0) {
          recurse(grid, seen, i, j);
          count++;
        }
      }
    }
    return count;
  }
  
  public void recurse(char[][] grid, int[][] seen, int x, int y) {
    if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == '0' || seen[x][y] == 1) {
      return;
    }
    seen[x][y] = 1;
    recurse(grid, seen, x + 1, y);
    recurse(grid, seen, x - 1, y);
    recurse(grid, seen, x, y + 1);
    recurse(grid, seen, x, y - 1);
  }
}