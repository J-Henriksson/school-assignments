public class QuicksortFixedPivotInsertion implements IntSorter {

    // Field for the variable that determines at what size of a partition to use insertion sort
    public static int k = 5;

    /**
     * Implements the Quicksort algorithm using a fixed pivot and 
     * insertion sort for small partitions.
     * 
     * @param arr The array to be sorted.
     * @param low The starting index of the partition.
     * @param high The ending index of the partition.
     */
    static void quickSort(int[] arr, int low, int high) {
        while (low < high) {

            // If the size of the partition is under or equal to k, use insertion sort 
            if (high - low + 1 <= k) {
                QuicksortUtils.insertionSort(arr, low, high);
                break;
            }
            else {
                // Assigns the index of the pivot after each sorting phase to a variable
               int pi = QuicksortUtils.partitionFixedPivot(arr, low, high);
               
               // Tail recursion optimization
               if (pi - low < high - pi) {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
               } 
               else {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
               }
            }
        }
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
