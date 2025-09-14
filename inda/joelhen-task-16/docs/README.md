#### Task 16.2 - Time Complexities for Data Structures


| Operation         | Sorted Array | Unsorted Singly Linked List | Hashtable (average) | Hashtable (worst) |
| :-----------------| :------------| :---------------------------| :-------------------| :-----------------|
| Search for key X  |   O(log n)           |              O(n)           | O(1)          |  O(n)              |
| Insert X          |   O(n)           |                  O(1)           | O(1)          |  O(n)              |
| Remove X          |   O(n)           |                  O(n)           | O(1)          |  O(n)                 |

    Sorted Array
        Searching for key X in a sorted array using binary search results in a time complexity of O(log n).

        Inserting or removing X in a sorted array requires shifting elements in order to maintain order which results in a time complexity of O(n).

    Unsorted Singly Linked List
        Searching for, or removing a key X in an unsorted singly linked list could require searching through all elements, which resulting in a time complexity of O(n).

        Inserting X into an unsorted linked list can be done in constant time (O(1)) since the new element is just added to the first or last values/pointers.

    Hashtable
        In a hashtable searching, inserting, and removing elements can on average be done in constant time (O(1)).
        However, in the worst case, when many keys collide, search and removal operations can go to a time complexity of O(n) since all elements may end up in the same bucket, requiring linear time to process through them all.
        Insert can also reach a time complexity of O(n) in cases were the hash's capacity is exceeded and it needs to be reinitialized to increase capacity.


#### Task 16.3 - Dynamic Tables
    1.
        The initial capacity of an ArrayList's internal array is 10 which is specified as the constant DEFAULT_CAPACITY.

    2.
        The statement used to determine growth is located at line 219. The specific conditional statement is: (minCapacity - elementData.length > 0)
    3. 
      minus

    4.
      1.5 due to the >>
    5.
      22 

    6.
      Worst case is O(n) which occurs when capacity is reached and a bigger array needs to be initialized.
      Average case is O(1) since most of the time when the add method is called the capacity is not exceeded and a new array does not need to be initialized.
      Best case is O(1).
