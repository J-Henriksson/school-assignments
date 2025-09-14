#### Exercise 12.1

| Size / complexity |     log n     |       n       |    n log n    |  n<sup>2</sup>   |  n<sup>3</sup>   |   2<sup>n</sup>  |      n!          |
|-------------------|---------------|---------------|---------------|------------------|------------------|------------------|------------------|
| 1                 | 0             | 1             | 0             | 1                | 1                | 2                | 1                |
| 10                | 3.32          | 10            | 33.2          | 100              | 1000             | 1024             | 3628800          |
| 100               | 6.64          | 100           | 664           | 10000            | 1e6              | 1.27e30          | &#x221e;         |
| 1000              | 9.97          | 1000          | 9970          | 1e6              | 1e9              | 1.07e30          | &#x221e;           |
| 10000             | 13.29         | 10000         | 132900        | 1e8              | 1e12             | &#x221e;        | &#x221e;       |
| 100000            | 16.61         | 100000        | 1661000       | 1e10             | 1e15             | &#x221e;       | &#x221e;      |
| 1000000           | 19.93         | 1000000       | 19930000      | 1e12             | 1e27                 | &#x221e;                | &#x221e;                   |

#### Exercise 12.2

| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         | 2<sup>1e9</sup>      | 2<sup>3.6e12</sup>     | &#x221e; | &#x221e;         | &#x221e;          | &#x221e;
| n             | 1e9         | 6e10         | 3.6e12   | 8.64e13          | 3.15e16         |
| n log n       | 3.96e7         | 9.86e10          | 9.8e10   | 2.1e12         | 6.4e14         |
| n<sup>2</sup> | 10<sup>9/2</sup>         | (6e10)<sup>1/2</sup>         | (3.6e12)<sup>1/2</sup>    | (8.64e13)<sup>1/2</sup>   | (3.15e16)<sup>1/2</sup> |
| n<sup>3</sup> | 10<sup>9/3</sup>         | (6e10)<sup>1/3</sup>         | (3.6e12)<sup>1/3</sup>    | (8.64e13)<sup>1/3</sup>   | (3.15e16)<sup>1/3</sup> |
| 2<sup>n</sup> | 29.9         | 35.8         | 41       | 46.3         | 54.8         |
| n!            | 12.3         | 13.9         | 15       | 16.5         | 18.5         |

#### Exercise 12.3.1

f4(n) = n + 100

f3(n) = n log n

f1(n) = n<sup>1.5</sup>

f5(n) = 2<sup>n</sup>

f2(n) = 10<sup>n</sup>

#### Exercise 12.3.2

n (n + 1) / 2 = O(n<sup>3</sup>)
False
The fastest growing term of the statement is n<sup>2</sup> and not n<sup>3</sup>.

n (n + 1) / 2 = O(n<sup>2</sup>)
True
n<sup>2</sup> Is the fastest growing term of the statement.

n (n + 1) / 2 = Θ(n<sup>3</sup>)
False
Since n<sup>3</sup> is not the upper bound of the statement it can impossibly be the average bound. 

n (n + 1) / 2 = Ω(n)
True
The lower bound of the statement (best case) is when n = 1 which makes it linear.

#### Exercise 12.4

```
Algorithm Loop1(n):
   a = 0
   for i = 1 to n
      a += i

Θ(n)

Algorithm Loop2(n):
   b = 1
   for i = 1 to 4n
      b++

Θ(n)

Algorithm Loop3(n):
   c = 1
   for i = 1 to n^2
      c--

Θ(n<sup>2</sup>)

Algorithm Loop4(n):
   d = 5
   for i = 1 to 3n
      for j = 1 to i
         d = d + j

Θ(n<sup>2</sup>)

Algorithm Loop5(n):
   e = 5
   for i = 1 to n^2
      for j = 1 to i
         e = e + j

Θ(n<sup>3</sup>)
```

#### Exercise 12.5

If we expand the term (n+1)<sup>3</sup> the largest term will be n<sup>3</sup> and will therefore be the term used to denote its Big O notation. 
If we choose c=4 and n0​=1 (or any other suitable values) we can observe that for    n≥1, n<sup>3</sup>≤4×n<sup>3</sup> holds true.


#### Exercise 12.6.1


The basic operation is:  A[j] = A[j-1]


This algorithm makes use of an outer loop and inner loop to reverse the elements of a list.
The outer loop runs from i = 1 to n-1, for a total of n-1 iterations.
For each iteration of the outer loop, the inner loop performs i shifts.
The algorithms time complexity is therefore O(n<sup>2</sup>)

#### Exercise 12.7

Best Case Scenario for a sorted collection:

    Insertion Sort:
        O(n) - Linear time complexity when the collection is already sorted.
    Selection Sort:
       O(n<sup>2</sup>) - No improvement in the best case.

Cases that are mostly Sorted:

    Insertion Sort:
        Performs well in mostly sorted cases.
        Adaptive nature allows it to approach O(n) time complexity.

    Selection Sort:
        Does not adapt to existing order.
        Maintains the O(n<sup>2</sup>) time complexity even in cases that are mostly sorted. Therefore making it kind of inferior to insertion sort.


In summary, I think Insertion Sort is more versatile and adaptable in real-world scenarios, making it a better choice for small or mostly sorted collections; especially in regards to how the best case scenarios differ between insertion sort and selection sort. However, for general-purpose sorting of larger datasets, more efficient algorithms like Merge Sort or Quicksort would probably be preferred due to their superior average and worst-case time complexities.

