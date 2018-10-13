class Solution {
  
  class Tuple {
    int i;
    int j;
    public Tuple(int x, int y) {
      i = x;
      j = y;
    }
  }
  
  public int numIslands(char[][] grid) {
    
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int[][] newGrid = new int[grid.length + 2][grid[0].length + 2];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        newGrid[i + 1][j + 1] = grid[i][j] - '0';
      }
    }
    
    int[][] seen = new int[newGrid.length][newGrid[0].length];
    int islands = 0;

    for (int i = 0; i < newGrid.length; i++) {
      for (int j = 0; j < newGrid[0].length; j++) {
        if (newGrid[i][j] == 1 && seen[i][j] == 0) {
          islands++;
          LinkedList<Tuple> toVisit = new LinkedList<>();
          toVisit.offer(new Tuple(i, j));
          while (!toVisit.isEmpty()) {
            Tuple t = toVisit.poll();
            int x = t.i;
            int y = t.j;
            seen[x][y] = 1;
            if (seen[x + 1][y] == 0 && newGrid[x + 1][y] == 1) {
              toVisit.offer(new Tuple(x + 1, y));
            }
            if (seen[x - 1][y] == 0 && newGrid[x - 1][y] == 1) {
              toVisit.offer(new Tuple(x - 1, y));
            }
            if (seen[x][y + 1] == 0 && newGrid[x][y + 1] == 1) {
              toVisit.offer(new Tuple(x, y + 1));
            }
            if (seen[x][y - 1] == 0 && newGrid[x][y - 1] == 1) {
              toVisit.offer(new Tuple(x, y - 1));
            }
          }
        }
      }
    }

    return islands;
  }
}