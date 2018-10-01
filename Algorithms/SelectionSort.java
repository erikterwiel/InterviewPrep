class SelectionSort {
  public static void sort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      int min = i;
      for (int j = i + 1; j < input.length; j++) {
        if (input[j] <  input[i]) {
          min = j;
        }
      }
      int temp = input[i];
      input[i] = input[min];
      input[min] = temp;
    }
  }
}