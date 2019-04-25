import java.util.Arrays;

class Solution {
  public int minPathSum(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int[][] memo = new int[grid.length][grid[0].length];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return recurse(0, grid.length - 1, grid[0].length - 1, grid, memo);
  }

  private int recurse(int sum, int x, int y, int[][] grid, int[][] memo) {
    System.out.println(x + " " + y + " " + sum);
    if (memo[x][y] != -1) {
      System.out.println("returning " + x + " " + y + " " + sum);
      return memo[x][y];
    }
    int newSum = sum + grid[x][y];
    if (x != 0 && y != 0) {
      memo[x][y] = Math.min(recurse(newSum, x - 1, y, grid, memo), recurse(newSum, x, y - 1, grid, memo));
    } else if (x != 0) {
      memo[x][y] = recurse(newSum, x - 1, y, grid, memo);
    } else if (y != 0) {
      memo[x][y] = recurse(newSum, x, y - 1, grid, memo);
    } else {
      memo[x][y] = newSum;
    }
    System.out.println("returning " + x + " " + y + " " + memo[x][y]);
    return memo[x][y];
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 2}, {1, 1}};
    System.out.println(new Solution().minPathSum(grid));
  }
}