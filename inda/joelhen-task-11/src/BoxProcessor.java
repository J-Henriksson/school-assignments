import java.util.List;
import java.util.Collections;
import java.lang.Math;

public class BoxProcessor {

    /**
     * Sorts an array of boxes using the insertion sort algorithm.
     *
     * @param array The array of boxes to be sorted.
     */
    public void sort(Box[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j].compareTo(array[j - 1]) < 0) {
                Box temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j -= 1;
            }
        }
    }

    /**
     * Sorts a list of boxes using the insertion sort algorithm.
     *
     * @param list The list of boxes to be sorted.
     */
    public void sort(List<Box> list) {
        for (int i = 0; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0) {
                Collections.swap(list, j, j - 1);
                j -= 1;
            }
        }
    }

    /**
     * Performs sequential search on an array of boxes to find the specified box.
     *
     * @param array The array of boxes to be searched.
     * @param box   The box to search for.
     * @return The index of the box in the array or -1 if not found.
     */
    public int sequentialSearch(Box[] array, Box box) {
        for (int i = 0; i < array.length; i++) {
            if (box.compareTo(array[i]) == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Performs sequential search on a list of boxes to find the specified box.
     *
     * @param list The list of boxes to be searched.
     * @param box  The box to search for.
     * @return The index of the box in the list or -1 if not found.
     */
    public int sequentialSearch(List<Box> list, Box box) {
        for (int i = 0; i < list.size(); i++) {
            if (box.compareTo(list.get(i)) == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Performs binary search on an array of boxes to find the specified box.
     *
     * @param array The array of boxes to be searched (must be sorted).
     * @param box   The box to search for.
     * @return The index of the box in the array or -1 if not found.
     */
    public int binarySearch(Box[] array, Box box) {
        int upperBound = array.length - 1;
        int lowerBound = 0;
        int index;
        while (lowerBound <= upperBound) {
            index = (int) Math.floor((upperBound + lowerBound) / 2);
            if (array[index].compareTo(box) == 0) {
                return index;
            }
            else if (array[index].compareTo(box) < 0) {
                lowerBound = index + 1;
            }
            else if (array[index].compareTo(box) > 0) {
                upperBound = index - 1;
            }
        }

        return -1;
    }

    /**
     * Performs binary search on a list of boxes to find the specified box.
     *
     * @param list The list of boxes to be searched (must be sorted).
     * @param box  The box to search for.
     * @return The index of the box in the list or -1 if not found.
     */
    public int binarySearch(List<Box> list, Box box) {
        int upperBound = list.size() - 1;
        int lowerBound = 0;
        int index;
        while (lowerBound <= upperBound) {
            index = (int) Math.floor((upperBound + lowerBound) / 2);
            if (list.get(index).compareTo(box) == 0) {
                return index;
            }
            else if (list.get(index).compareTo(box) < 0) {
                lowerBound = index + 1;
            }
            else if (list.get(index).compareTo(box) > 0) {
                upperBound = index - 1;
            }
        }

        return -1;
    }
}
