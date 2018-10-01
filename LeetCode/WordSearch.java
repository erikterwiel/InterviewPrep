import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    char[][] input = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
    System.out.println(new Solution().exist(input, "ABCESEEEFS"));
  }

  public boolean exist(char[][] board, String word) {
    
    char[] wordArray = word.toCharArray();
    
    boolean result = false;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        
        if (board[i][j] == wordArray[0] && search(board, new int[board.length][board[0].length], Arrays.copyOfRange(wordArray, 1, wordArray.length), i, j)) {
          result = true;
        }
      }
    }

    return result;
  }

  public boolean search(char[][] board, int[][] seen, char[] wordArray, int row, int column) {
    
    if (wordArray.length == 0) {
      return true;
    }

    seen[row][column] = 1;

    boolean result = false;

    if (result == false && row != 0 && board[row - 1][column] == wordArray[0] && seen[row - 1][column] == 0) {
      result = search(board, seen, Arrays.copyOfRange(wordArray, 1, wordArray.length), row - 1, column);
    }
    
    if (result == false && row != board.length - 1 && board[row + 1][column] == wordArray[0] && seen[row + 1][column] == 0) {
      result = search(board, seen, Arrays.copyOfRange(wordArray, 1, wordArray.length), row + 1, column);
    } 
    
    if (result == false && column != 0 && board[row][column - 1] == wordArray[0] && seen[row][column - 1] == 0) {
      result = search(board, seen, Arrays.copyOfRange(wordArray, 1, wordArray.length), row, column - 1);
    }
    if (result == false && column != board[0].length - 1 && board[row][column + 1] == wordArray[0] && seen[row][column + 1] == 0) {
      result = search(board, seen, Arrays.copyOfRange(wordArray, 1, wordArray.length), row, column + 1);
    }

    if (result == false) {
      seen[row][column] = 0;
    }
    
    return result;
  }
}