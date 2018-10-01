class QuickSort {

  public static void main(String[] args) {
    int[] input = {5, 3, 7, 9, 2, 3, 4, 23, 34, 89};
    MergeSort.mergesort(input);
    for (int num : input) {
      System.out.print(num + " ");
    }
  }

  public static void quicksort(int[] input, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot = partition(input, start, end);
    quicksort(input, start, pivot - 1);
    quicksort(input, pivot + 1, end);
  }

  public static int partition(int[] input, int start, int end) {
    int pivot = input[end];
    int pivotIndex = start;
    for (int i = 0; i < end - 1; i++) {
      if (input[i] <= pivot) {
        swap(input, i, pivotIndex);
        pivotIndex++;
      }
    }
    swap(input, end, pivotIndex);
    return pivotIndex; 
  }

   public static void swap(int[] input, int indexA, int indexB) {
     int temp = input[indexA];
     input[indexA] = input[indexB];
     input[indexB] = temp;
   }
}