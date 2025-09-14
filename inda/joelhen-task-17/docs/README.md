#### Task 17.2 - Time Complexity

| Operation (BST)     | Time Complexity (worst case)    |
| ------------------- | ------------------------------- |
| search              |             O(n)                |
| insert              |             O(n)                |
| size                |             O(1)                |
| height              |             O(n)                |
| leaves              |             O(n)                |
| toString            |             O(n)                |


Search:
When the search operation has to traverse through the entire height of the tree when the tree is unbalanced.

Insert:
Same as for search.

Size:
Since the size method only needs to access the size field it has a constant time complexity of O(1).

Height:
In the worst case, every node needs to be visited once to determine the height.

Leaves:
n the worst case, when the tree is unbalanced and each node has either no children or one child, the operation needs to visit every node to determine if it's a leaf node.

ToString:
The toString method will always need to traverse every node in order to generate a string representation of the tree.