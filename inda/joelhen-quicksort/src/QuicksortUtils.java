import java.util.Random;

public class QuicksortUtils {
    
    /**
     * Partitions the specified range of elements in the given array using a fixed pivot.
     * 
     * @param arr The array to be partitioned.
     * @param low The index of the first element in the range to be partitioned.
     * @param high The index of the last element in the range to be partitioned.
     * @return The index of the pivot.
     */
    public static int partitionFixedPivot(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Partitions the specified range of elements in the given array using a randomly selected pivot.
     * 
     * @param arr The array to be partitioned.
     * @param low The index of the first element in the range to be partitioned.
     * @param high The index of the last element in the range to be partitioned.
     * @return The index of the pivot.
     */
    public static int partitionRandomPivot(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);
        return partitionFixedPivot(arr, low, high);
    }

    /**
     * Sorts the specified range of elements in the given array using the insertion sort algorithm.
     * 
     * @param arr The array to be sorted.
     * @param low The index of the first element (inclusive) to be sorted.
     * @param high The index of the last element (inclusive) to be sorted.
     */
    public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int j = i;
            while (j > low && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    /**
     * Helper method for swapping two specified indices in the given array.
     * 
     * @param arr The array in which to swap elements.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
