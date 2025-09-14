# A Study of Quicksort

## Characteristics and Complexity

Quicksort is a widely used sorting algorithm known for its efficiency. It was developed by 
British computer scientist Tony Hoare in 1959. Hoare developed Quicksort while working on sorting words for the Elliott 803, an early commercial computer. 
The algorithm is based on the problem solving model of divide and concur, which encompasses the method of solving of complex problem by breaking it down into smaller, more manageable sub problems. In the case of quicksort this is accomplished by selecting a pivot element from the array and partitioning the array into two sub-arrays such that the elements smaller than the pivot are on the "left" sub-array and elements larger than the pivot are on the right. This process is then recursively applied to the sub-arrays until the entire array is sorted.

Quicksorts strength comes from its average-case time complexity of O(n log n) which arises when the pivot selection process distributes the elements evenly around the pivot. In practice, this can be achieved through  randomized pivot selection or strategies that aim to select a pivot close to the median of the array. 
Much like many other sorting algorithms quicksort unfortunately has the worst case time complexity of O(n^2). This occurs when the chosen pivots lead to highly unbalanced partitions during each recursive call. This happens when the pivot element is either the smallest or largest element in the array which makes one partition significantly larger than the other, causing Quicksort's performance to degrade to O(n^2).

 

## Variations of Quicksort

	In this section:
	* Outline each variation you implemented
	* Include snippets of code where relevant (e.g. different partition routines)
	* Discuss your cut-off strategy

### Variation 1: QuicksortFixedPivot

This variation of Quicksort utilizes a fixed pivot, choosing the last element of the partition as the pivot.

For each of my quicksort implementations I've stored the method used to get the pivot in the helper class QuicksortUtils.

```java
public class QuicksortFixedPivot implements IntSorter {
    static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            int pi = QuicksortUtils.partitionFixedPivot(arr, low, high);
            if (pi - low < high - pi) {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            } else {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
```

The pivot is chosen as follows:

```java
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
```

In this version of quicksort a fixed pivot is always chosen as the last element of the partitioned array. The partitioning process involves iterating through the array, placing elements smaller than the pivot to its left and elements greater than or equal to it to its right. Finally, the pivot is positioned in its correct sorted position, and the index of its final position is returned so that it can be used to repeat the process by dividing up the array into new sub-arrays.

### Variation 2: QuicksortRandomPivot

This version is similar to the previous implementation but here the pivot is chosen randomly.

```java
  public static int partitionRandomPivot(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);
        return partitionFixedPivot(arr, low, high);
    }
```
This variation generates the pivot by choosing a random index within the range [low, high] using the nextInt method of the Random class. By doing this the algorithm reduces the likelihood of encountering worst-case scenarios and improves its average-case performance.
After selecting the random pivot, the method swaps the element at the random index with the last element of the partitioned array. This ensures that the random pivot always assumes the position of the pivot for the fixed pivot partitioning method. Subsequently, the partitionFixedPivot method is called to partition the array based on the random pivot, following the same logic as in Variation 1.

### Variation 3: QuicksortFixedPivotInsertion

This variation uses the v1 implementation of insertion sort for small partitions, but switches to insertion sort when the size of the partition is below 5. 

```java
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
```

The partitioning process here follows the same approach as Variation 1, selecting a fixed pivot and recursively dividing the array until the partition size becomes <= 5. In that case the insertionSort method is used instead.

```java
  public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int j = i;
            while (j > low && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }
```

### Variation 4: QuicksortRandomPivotInsertion

This variation follows the exact same logic and layout as V3 except that the pivot is randomly chosen. This is done in the same manner as it is in V2.

### Cut-off Strategy


	In V3 and V4, a cut-off strategy is employed to switch from Quicksort to insertion sort for small partitions. When the size of the partition is below or equal to the threshold k=5, insertion sort is used instead of further partitioning.

   The choice of k=5 is done to balance the overhead of partitioning using quicksort with the efficiency of insertion sort for smaller arrays. I found that a K value of somewhere between 5-7 provides the best trade-off between complexity and performance.

## Methodology

To comprehensively evaluate the Quicksort variations, I used a test suite comprising of a series systematic tests, aiming to assess the different variations correctness, efficiency, and scalability across diverse input scenarios.

The tests encompassed various types of arrays:

Even and Odd Arrays: Ensured handling arrays of different lengths.
Ascending and Descending Arrays: Evaluated performance on partially sorted data. 
Random Arrays: Assessed algorithms' handling of completely unsorted data.
Super Big Arrays: Tested scalability with a large array of 100,000 elements.

Problem sizes ranged from small arrays of 100 elements to large arrays with 100,000 elements, providing insights into performance under different computational loads.

The tests covered all four of the relevant Quicksort algorithm variations:

QuicksortFixedPivot (V1)
QuicksortRandomPivot (V2)
QuicksortFixedPivotInsertion (V3)
QuicksortRandomPivotInsertion (V4)

I also added two tests to ensure that the sorting algorithms behaved correctly when faced with empty and single value arrays.

## Results

### Random Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          | 125469 ns       |  100236 ns             | 219541 ns            |    70242 ns                  | 63890 ns                          | 37119 ns      |
| 1000         |  2573215 ns  |   380494 ns               | 276837 ns                 |      149502 ns                             | 218812 ns                         | 515599 ns     |
| 10000        |  32316455 ns |   814721 ns                       | 1737585 ns       |      877773 ns                            | 2768160 ns                       | 1389601 ns   |
| 100000       | - (way too much time) |   11762936 ns                    | 15433220 ns       |     15059170 ns                | 17502555 ns                      | 15080585 ns  |
| 1000000      |  - (way too much time) |    158172441 ns             | 209,241,804 ns           |   132537681 ns                      | 151614738 ns                     | 107551574 ns |

### Ascending Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          |  1214 ns      |   110980 ns              | 8117 ns                   |   75662 ns                                | 5019 ns                           | 12589 ns      |
| 1000         | 3508 ns       | 1314171 ns               | 77647 ns                  |   2593169 ns                                | 48,483 ns                          | 23237 ns      |
| 10000        | 24626 ns      |      59293122 ns         | 1126966 ns               |       54449644 ns                    | 651534 ns                         | 120570 ns     |
| 100000       | - (way too much time) |  4575924922 ns   | 9907059 ns               |  2845770254 ns             | 6461292 ns                       | 150577 ns     |
| 1000000      | - (way too much time) | - (way too much time)  | 115363371 ns             |     - (way too much time)        | 73773883 ns                      | 744106 ns     |

### Descending Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          |  10453 ns      |     37413 ns                     | 15882 ns          |   8393 ns                                | 5506 ns                           | 9357 ns       |
| 1000         | 840571 ns     |      811594 ns            | 168768 ns                |   665045 ns                                | 40891 ns                          | 34576 ns      |
| 10000        |  47983956 ns   |    47990263 ns           | 942,404 ns                 |    76138260 ns                            | 444,572 ns                         | 48503 ns      |
| 100000       |  - (way too much time) |   3691851021 ns     | 10403209 ns              |   3303796725             | 4827124 ns                       | 128665 ns     |
| 1000000      | - (way too much time)  |  - (way too much time)      | 97486332 ns              |    - (way too much time)             | 48125977 ns                      | 1181671 ns   |

### Equal Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          | 2829 ns       | 145344 ns                | 170614 ns                  | 22898 ns                          | 35763 ns                           | 1841 ns       |
| 1000         | 26864 ns      | 1583088 ns               | 181877 ns                  | 120544 ns                         | 170540 ns                          | 12282 ns      |
| 10000        | 250676 ns     | 16410840 ns              | 11113188 ns                | 10611004 ns                       | 11238752 ns                        | 111633 ns     |
| 100000       | 398097 ns     | 1328861864 ns            | 1057069140 ns              | 1107642261 ns                     | 1820629328 ns                      | 418370 ns     |
| 1000000      | 579028 ns     | - (way too much time)    | - (way too much time)      | - (way too much time)             | - (way too much time)              | 1369235 ns    |

† - Arrays.sort is Java's built-in sorting algorithm.


### Performance Comparison: QuicksortRandomPivotInsertion vs. Arrays.sort (with Random Data)

```matlab
problem_sizes = [100, 1000, 10000, 100000, 1000000];

quicksort_random_data = [63890, 218812, 2768160, 17502555, 151614738];
arrays_sort_data = [37119, 515599, 1389601, 15080585, 107551574];

figure;
plot(problem_sizes, quicksort_random_data, '-o', 'DisplayName', 'QuicksortRandomPivotInsertion (V4)');
hold on;
plot(problem_sizes, arrays_sort_data, '-o', 'DisplayName', 'Arrays.sort');
xlabel('Problem Size');
ylabel('Execution Time (ns)');
title('Performance Comparison: QuicksortRandomPivotInsertion vs. Arrays.sort (Random Data)');
legend('Location', 'northwest');
grid on; 
```

## Discussion

Based on the test results these conclusions can be made:

* The quicksort variations generally outperformed InsertionSort, especially for larger problem sizes.
* QuicksortFixedPivot (V1) and QuicksortRandomPivot (V2) showed comparable performance, with QuicksortRandomPivot slightly outperforming QuicksortFixedPivot in some cases.
* The insertion sort optimizations for (V3) and (V4) as expected significantly improved performance for smaller partitions, resulting in faster execution times compared to (V1) and (V2).
* Arrays.sort consistently demonstrated strong performance across all test cases, highlighting the efficiency of Java's built-in sorting algorithm.


One of the more surprising observations that can made based on the data, at least according to the preconceived notions that I had was the performance of the different sorting methods on arrays with equal data. To garner a deeper understanding of why this is we first have to understand stability in sorting algorithms.
In regards to sorting algorithms stability refers to their ability to maintain the relative order of equal elements in the sorted output. So if two elements have the same value, their relative positions in the input array should be the same as in the sorted array.

When all elements in an array are equal, quicksort's partitioning step becomes inefficient. Since quicksorts basic structure relies on dividing the array into smaller sub-arrays based on a pivot this means that when all elements are the same, any pivot choice will result in highly uneven partitions; where all elements are either less than or greater than the pivot. This imbalance leads to suboptimal performance were the partitioning steps fail to provide any meaningful separation of data.

On the contrary, insertion sort doesn't rely on partitioning. It iterates through the array, comparing each element with its predecessors and inserting it into the correct position. When all elements are equal, there's no need for complex partitioning logic. Instead, insertion sort simply iterates through the array and performs comparisons. This results in insertion sort being preferable to quicksort when it comes to equal data.


Another thing which I found interesting was the fact when I first ran my test to gether the data used in the Results section I encountered some stack overflow errors. The fixe for this was using what is known as tail end recursion.
By employing tail recursion optimization in quicksort, the recursive calls are transformed into iterative processes, reducing the memory footprint and preventing excessive stack growth. As a result, even for large arrays or deeply nested recursion scenarios, this optimization allowed quicksort to operate efficiently without risking stack overflow errors. This ensured the reliability and scalability of the tests and allowed them to handle all of the different data sizes and distributions without encountering errors.


In my tests the RandomPivotInsertion variation consistently emerged as the fastest sorting algorithm across various data distributions and problem sizes. This observation aligns with my expectations on the performance of the various implementations of the algorithm, given its superior optimizations. The use of a randomly selected pivot helps mitigate the risk of worst-case scenarios encountered in traditional pivot selection methods, such as selecting the smallest or largest element as the pivot. Furthermore the incorporation of insertion sort for partitions below a certain threshold (in this case below or equal to 5) enhances the efficiency of the algorithm even more since insertion sort exhibits excellent performance on smaller datasets.

Given the fact that the RandomPivotInsertion variation was the best performing one it was also the one closest to java's Arrays.sort.


In conclusion, this analysis of various quicksort implementations has shed light on their efficacy across diverse datasets and problem sizes. While all variations demonstrated notable performance improvements over InsertionSort, QuicksortRandomPivotInsertion emerged as the best variation, showcasing superior efficiency and scalability.

	