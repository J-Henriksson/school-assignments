* Test 1: Random Data
* Test 2: Sorted Data
* Test 3: Reversed Data
* Test 4: Equal Data

* Qs V1 = QuicksortFixedPivot
* Qs V2 = QuicksortRandomPivot
* Qs V3 = QuicksortFixedPivotInsertion
* Qs V4 = QuicksortRandomPivotInsertion

| Test 1: Random Data |               |       |       |       |       |               |
| ------------------  | ------------- | ----- | ----- | ----- | ----- | ------------- |
| Problem Size        | InsertionSort | Qs V1 | Qs V2 | Qs V3 | Qs V4 | Arrays.sort † |
| 100                 |               |       |       |       |       |               |
| 1000                |               |       |       |       |       |               |
| 10000               |               |       |       |       |       |               |
| 100000              |               |       |       |       |       |               |
| 1000000             |               |       |       |       |       |               |

| Test 2: Sorted Data |               |       |       |       |       |               |
| ------------------  | ------------- | ----- | ----- | ----- | ----- | ------------- |
| Problem Size        | InsertionSort | Qs V1 | Qs V2 | Qs V3 | Qs V4 | Arrays.sort † |
| 100                 |               |       |       |       |       |               |
| 1000                |               |       |       |       |       |               |
| 10000               |               |       |       |       |       |               |
| 100000              |               |       |       |       |       |               |
| 1000000             |               |       |       |       |       |               |

| Test 3: Reversed Data |               |       |       |       |       |               |
| ------------------    | ------------- | ----- | ----- | ----- | ----- | ------------- |
| Problem Size          | InsertionSort | Qs V1 | Qs V2 | Qs V3 | Qs V4 | Arrays.sort † |
| 100                   |               |       |       |       |       |               |
| 1000                  |               |       |       |       |       |               |
| 10000                 |               |       |       |       |       |               |
| 100000                |               |       |       |       |       |               |
| 1000000               |               |       |       |       |       |               |

| Test 4: Equal Data  |               |       |       |       |       |               |
| ------------------  | ------------- | ----- | ----- | ----- | ----- | ------------- |
| Problem Size        | InsertionSort | Qs V1 | Qs V2 | Qs V3 | Qs V4 | Arrays.sort † |
| 100                 |               |       |       |       |       |               |
| 1000                |               |       |       |       |       |               |
| 10000               |               |       |       |       |       |               |
| 100000              |               |       |       |       |       |               |
| 1000000             |               |       |       |       |       |               |


### Random Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          | 125469 ns       |  100236 ns             | 219,541 ns            |    70242 ns                  | 63,890 ns                          | 37,119 ns      |
| 1000         |  2573215 ns  |   380494 ns               | 276,837 ns                 |      149502 ns                             | 218,812 ns                         | 515,599 ns     |
| 10000        |  32316455 ns |   814721 ns                       | 1,737,585 ns       |      877773 ns                            | 2,768,160 ns                       | 1,389,601 ns   |
| 100000       | - (way too much time) |   11762936 ns                    | 15,433,220 ns       |     15059170 ns                | 17,502,555 ns                      | 15,080,585 ns  |
| 1000000      |  - (way too much time) |    158172441 ns             | 209,241,804 ns           |   132537681 ns                      | 151,614,738 ns                     | 107,551,574 ns |

### Ascending Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          |  1214 ns      |   110980 ns              | 8,117 ns                   |   75662 ns                                | 5,019 ns                           | 12,589 ns      |
| 1000         | 3508 ns       | 1314171 ns               | 77,647 ns                  |   2593169 ns                                | 48,483 ns                          | 23,237 ns      |
| 10000        | 24626 ns      |      59293122 ns         | 1,126,966 ns               |       54449644 ns                    | 651,534 ns                         | 120,570 ns     |
| 100000       | - (way too much time) |  4575924922 ns   | 9,907,059 ns               |  2845770254 ns             | 6,461,292 ns                       | 150,577 ns     |
| 1000000      | - (way too much time) | - (way too much time)  | 115,363,371 ns             |     - (way too much time)        | 73,773,883 ns                      | 744,106 ns     |

### Descending Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          |  10453 ns      |     37413 ns                     | 15,882 ns          |   8393 ns                                | 5,506 ns                           | 9,357 ns       |
| 1000         | 840571 ns     |      811594 ns            | 168,768 ns                |   665045 ns                                | 40,891 ns                          | 34,576 ns      |
| 10000        |  47983956 ns   |    64957696 ns           | 942,404 ns                 |    76138260 ns                            | 444,572 ns                         | 48,503 ns      |
| 100000       |  - (way too much time) |   - (stack overflow)     | 10,403,209 ns              |   - (stack overflow)              | 4,827,124 ns                       | 128,665 ns     |
| 1000000      | - (way too much time)  |  - (stack overflow)      | 97,486,332 ns              |    - (stack overflow)             | 48,125,977 ns                      | 1,181,671 ns   |

### Equal Data

| Problem Size | InsertionSort | QuicksortFixedPivot (V1) | QuicksortRandomPivot (V2) | QuicksortFixedPivotInsertion (V3) | QuicksortRandomPivotInsertion (V4) | Arrays.sort † |
|--------------|---------------|--------------------------|----------------------------|-----------------------------------|------------------------------------|---------------|
| 100          | 2829 ns       | 145344 ns                | 170614 ns                  | 22898 ns                          | 35763 ns                           | 1841 ns       |
| 1000         | 26864 ns      | 1583088 ns               | 181877 ns                  | 120544 ns                         | 170540 ns                          | 12282 ns      |
| 10000        | 250676 ns     | 16410840 ns              | 11113188 ns                | 10611004 ns                       | 11238752 ns                        | 111633 ns     |
| 100000       | 398097 ns     | 1328861864 ns            | 1057069140 ns              | 1107642261 ns                     | 1820629328 ns                      | 418370 ns     |
| 1000000      | 579028 ns     | - (way too much time)    | - (way too much time)      | - (way too much time)             | - (way too much time)              | 1369235 ns    |

† - Arrays.sort is Java's built-in sorting algorithm.

