class MergeSort {

  public static void main(String[] args) {
    int[] input = {5, 3, 7, 9, 2, 3, 4, 23, 34, 89};
    MergeSort.mergesort(input);
    for (int num : input) {
      System.out.print(num + " ");
    }
  }

  public static void mergesort(int[] array) {
    mergesort(array, new int[array.length], 0, array.length - 1);
  }

  public static void mergesort(int[] array, int[] temp, int low, int high) {
    if (low >= high) {
      return;
    }
    int middle = (low + high) / 2;
    mergesort(array, temp, low, middle);
    mergesort(array, temp, middle + 1, high);
    merge(array, temp, low, middle, high);
  }

  public static void merge(int[] array, int[] temp, int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      temp[i] = array[i];
    }

    int leftIndex = low;
    int rightIndex = middle + 1;
    int totalIndex = low;

    while (leftIndex <= middle && rightIndex <= high) {
      if (temp[leftIndex] <= temp[rightIndex]) {
        array[totalIndex] = temp[leftIndex];
        leftIndex++;
      } else {
        array[totalIndex] = temp[rightIndex];
        rightIndex++;
      }
      totalIndex++;
    }

    while (leftIndex <= middle) {
      array[totalIndex] = temp[leftIndex];
      leftIndex++;
      totalIndex++;
    }
  }
}