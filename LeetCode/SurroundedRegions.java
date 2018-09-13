class Solution {
  public void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (i != 0 && j != 0 && i != board.length - 1 && j != board.length - 1) {
          board[i][j] = 'X';
        }
      }
    }
  }
}