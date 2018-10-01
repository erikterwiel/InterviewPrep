class BinarySearch {
  public static void binarySearch(int[] input, int target, int low, int high) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (input[mid] < target) {
      binarySearch(input, target, mid + 1, high);
    } else if (input[mid] > target) {
      binarySearch(input, target, low, mid - 1);
    } else if (input[mid] == target) {
      return mid;
    }
  }
}