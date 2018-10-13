class Solution {

  
  public int numIslands(char[][] grid) {

    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int xBound = grid.length;
    int yBound = grid[0].length;
    int islands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          islands++;
          dfs(grid, i, j, xBound, yBound);
        }
      }
    }
    return islands;
  }

  public void dfs(char[][] grid, int x, int y, int xBound, int yBound) {
    if (x < 0 || y < 0 || x == xBound || y == yBound || grid[x][y] == '0') {
      return;
    } 
    grid[x][y] = '0';
    dfs(grid, x + 1, y, xBound, yBound);
    dfs(grid, x - 1, y, xBound, yBound);
    dfs(grid, x, y + 1, xBound, yBound);
    dfs(grid, x, y - 1, xBound, yBound);
  }
}