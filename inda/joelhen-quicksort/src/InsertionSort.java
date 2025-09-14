public class InsertionSort implements IntSorter {

    public void sort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int j = i;
            while (j > 0 && v[j - 1] > v[j]) {
                int temp = v[j];
                v[j] = v[j - 1];
                v[j - 1] = temp;
                j--;
            }
        }
    }
}
