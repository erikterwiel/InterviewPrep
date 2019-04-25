class Solution {
  public static double findMedianSortedArrays(int[] x, int[] y) {
    
    if (x.length > y.length) {
      return findMedianSortedArrays(y, x);
    }
    if (x.length == 0) {
      return findMedian(y);
    }
    if (y.length == 0) {
      return findMedian(x);
    }

    int low = 0;
    int high = x.length;

    while (low <= high) {
      int xPartion = (low + high) / 2;
      int yPartion = (x.length + y.length + 1) / 2 - xPartion;
      System.out.println(xPartion + " " + yPartion);
      
      int xLeftHigh = xPartion == 0 ? Integer.MIN_VALUE : x[xPartion - 1];
      int xRightLow = xPartion == x.length ? Integer.MAX_VALUE : x[xPartion];
      int yLeftHigh = yPartion == 0 ? Integer.MIN_VALUE : y[yPartion - 1];
      int yRightLow = yPartion == y.length ? Integer.MAX_VALUE : y[yPartion];

      System.out.println(xLeftHigh + " " + xRightLow + " " + yLeftHigh + " " + yRightLow);

      if (xLeftHigh <= yRightLow && yLeftHigh <= xRightLow) {
        if ((x.length + y.length) % 2 == 0) {
          return ((double) Math.max(xLeftHigh, yLeftHigh) + Math.min(xRightLow, yRightLow)) / 2;
        }
        return (double) Math.max(xLeftHigh, yLeftHigh);
      } else if (xLeftHigh > yRightLow) {
        System.out.println("too far right");
        high = xPartion - 1;
      } else {
        System.out.println("too far left");
        low = xPartion + 1;
      }
      System.out.println("");
    }
    return 0;
  }

  private static double findMedian(int[] array) {
    if (array.length % 2 == 0) {
      return ((double) (array[array.length / 2 - 1] + array[array.length / 2])) / 2;
    } else {
      return array[array.length / 2];
    }
  }

  public static void main(String[] args) {
    int[] x = {};
    int[] y = {2, 3};
    System.out.println(Double.toString(findMedianSortedArrays(x, y)));
  }
}