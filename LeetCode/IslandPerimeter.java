import java.util.Stack;

class Solution {

  class Perimeter {
    int val = 0;
  }

  public int islandPerimeter(int[][] grid) {
    
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    
    Perimeter perimeter = new Perimeter();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count(grid, new int[grid.length][grid[0].length], i, j, perimeter);
          return perimeter.val;
        }
      }
    }

    return 0;
  }

  public void count(int[][] grid, int[][] seen, int x, int y, Perimeter perimeter) {
    if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 0) {
      perimeter.val++;
      return;
    }
    if (seen[x][y] == 1) {
      return;
    }
    seen[x][y] = 1;
    count(grid, seen, x + 1, y, perimeter);
    count(grid, seen, x - 1, y, perimeter);
    count(grid, seen, x, y + 1, perimeter);
    count(grid, seen, x, y - 1, perimeter);
  }
}