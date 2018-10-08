import java.util.*;

enum Direction {
  LEFT, RIGHT, UP, DOWN
}

class Solution {

  public static void main(String[] args) {
    int[][] input = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    List<Integer> result = new Solution().spiralOrder(input);
    for (int num : result) {
      System.out.print(num + " ");
    }
    System.out.print("\n");
  }

  public List<Integer> spiralOrder(int[][] matrix) {

    ArrayList<Integer> order = new ArrayList<>();
    if (matrix.length == 0 || (matrix.length > 0 && matrix[0].length == 0)) {
      return order;
    }

    int elements = matrix.length * matrix[0].length;
    int leftBoundary = 0;
    int topBoundary = 0;
    int rightBoundary = matrix[0].length - 1;
    int bottomBoundary = matrix.length - 1;
    int x = 0;
    int y = 0;
   
    Direction direction = Direction.RIGHT;

    while (order.size() < elements) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          String result = i == y && j == x ? "X" : "O";
          System.out.print(result + " ");
        }
        System.out.print("\n");
      }
      System.out.print("\n");
      order.add(matrix[y][x]);
      
      switch (direction) {
        case RIGHT:
          if (x == rightBoundary) {
            direction = Direction.DOWN;
            topBoundary++;
          }
          break;
        case DOWN:
          if (y == bottomBoundary) {
            direction = Direction.LEFT;
            rightBoundary--;
          }
          break;
        case LEFT:
          if (x == leftBoundary) {
            direction = Direction.UP;
            bottomBoundary--;
          }
          break;
        case UP:
          if (y == topBoundary) {
            direction = Direction.RIGHT;
            leftBoundary++;
          }
          break;
      }

      switch (direction) {
        case RIGHT:
          x++;
          break;
        case DOWN:
          y++;
          break;
        case LEFT:
          x--;
          break;
        case UP:
          y--;
          break;
      }
    }

    return order;
  }
}