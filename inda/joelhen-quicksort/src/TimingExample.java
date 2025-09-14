/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Stefan Nilsson 
 * @author Joel Henriksson
 * @version 2011-03-19
 */
public final class TimingExample {

    public static long longest = 0;

    public static long shortest = 0;

    final static Stopwatch clock = new Stopwatch();

    
    

/**
 * Calculates the sum of sorting times for the given sorter and data characteristics.
 * 
 * @param sorter The sorting algorithm to test.
 * @param order The order of the data (ASCENDING, DESCENDING, RANDOM).
 * @param reps The number of repetitions for the test.
 * @param arraySize The size of the array to be sorted.
 * @param isEqual  Indicates whether the array elements are equal (true) or unique (false).
 * @return The sum of sorting times.
 */
   private static long sortSum(IntSorter sorter, Data.Order order, int reps, int arraySize, boolean isEqual) {
    long timeSum = 0;
    long time;
    int[] array;
    for (int g = 0; g <= reps; g++) {
        if (isEqual) {
            array = new Data(arraySize, 1, order).get();  
        }
        else {
            array = new Data(arraySize, arraySize, order).get();
        }
        clock.reset().start();
        sorter.sort(array);
        time = clock.stop().nanoseconds();

        if (g > 0) {
            if (time > longest) {
                longest = time;
            }
            else if (time < shortest || shortest == 0) {
                shortest = time;
            }
    
            timeSum += time;
        }
    }
    return timeSum;
    }
   
/**
 * Performs a timing test for sorting algorithms.
 * 
 * @param sorter  The sorting algorithm to test.
 * @param order   The order of the data (ASCENDING, DESCENDING, RANDOM).
 * @param isEqual Indicates whether the array elements are equal (true) or unique (false).
 */
   public static void sortTimingTest(IntSorter sorter, Data.Order order, boolean isEqual) {
    final int reps = 5;

    for (int i = 100; i <= 1000000; i *= 10) {
        long avg = sortSum(sorter, order, reps, i, isEqual) / reps;
        System.out.println(String.format("Avg time in nanoseconds for sorting of problem size %d is: %d. "
        + "Longest time: %d. Shortest time: %d.", i, avg, longest, shortest));
        longest = 0;
        shortest = 0;
    }
   }
   
   public static void main(String[] args) {
    ArraysSort arraySort = new ArraysSort();
    InsertionSort insertionSort = new InsertionSort();
    QuicksortFixedPivot fixedPivot = new QuicksortFixedPivot();
    QuicksortRandomPivot randomPivot= new QuicksortRandomPivot();
    QuicksortFixedPivotInsertion fixedPivotInsertion = new QuicksortFixedPivotInsertion();
    QuicksortRandomPivotInsertion  randomPivotInsertion = new QuicksortRandomPivotInsertion();

   IntSorter[] algorithms = { fixedPivotInsertion};

    Data.Order[] orders = {Data.Order.DESCENDING};

    for (Data.Order order : orders) {
        for (IntSorter algorithm : algorithms) {
            System.out.println(algorithm.getClass().getSimpleName() + " with " + order + " data");
            sortTimingTest(algorithm, order, false);
        }
    }

    
  }
}
