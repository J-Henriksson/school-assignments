public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    public int size;

    private static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    /**
     * Searches for an element in the tree.
     *
     * @param elem The element to search for.
     * @return true if the element is found, false otherwise.
     */
    public boolean search(T elem) {
        Node<T> current = root;

        while(current != null) {
            int comparison = elem.compareTo(current.data);
            if (comparison == 0) {
                return true;
            }
            if (comparison < 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        
        return false;
    }

    /**
     * Inserts an element into the tree.
     *
     * @param elem The element to insert.
     * @return true if the element is successfully inserted, false if the element already exists in the tree.
     */
    public boolean insert(T elem) {
        if (root == null) {
            root = new Node<>(elem); 
            size++;
            return true;
        }
    
        Node<T> current = root;
        Node<T> parent;
    
        while (true) {
            parent = current;
            int comparison = elem.compareTo(current.data);
            if (comparison < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = new Node<>(elem); 
                    size++;
                    return true;
                }
            } 
            else if (comparison > 0) {
                current = current.right; 
                if (current == null) {
                    parent.right = new Node<>(elem); 
                    size++;
                    return true;
                }
            } 
            else {
                return false; 
            }
        }
    }

    /**
     * Gets the size of the tree.
     *
     * @return The number of elements in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Gets the height of the tree.
     *
     * @return The height of the tree.
     */
    public int height() {
        if (root.left == null && root.right == null) {
        return 0;
        }
        
        return heightHelper(root);
    }

    /**
     * Helper method used to calculate the height of a subtree.
     *
     * @param node The root of the subtree.
     * @return The height of the subtree.
     */
    public int heightHelper(Node<T> node) {
        if (node == null) {
            return 0;
        }
        else {
            int leftHeight = heightHelper(node.left);
            int rightHeight = heightHelper(node.right);
            if (node == root) {
                return Math.max(leftHeight, rightHeight); 
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Gets the total amount of leaves in the tree.
     *
     * @return The number of leaves in the tree.
     */
    public int leaves() {
        return leavesHelper(root);
    }

    /**
     * Helper method used to count the number of leaves in a subtree.
     *
     * @param node The root of the subtree.
     * @return The number of leaves in the subtree.
     */
    public int leavesHelper(Node<T> node) {
        if (node == null) {
            return 0;
        }
        else if (node.left == null && node.right == null) {
            return 1;
        }
        else {
            int leftLeaves = leavesHelper(node.left);
            int rightLeaves = leavesHelper(node.right);

            return(leftLeaves + rightLeaves);
        }
    }

    /**
     * Generates a string representation for the tree.
     *
     * @return A string representation of the tree.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(root, sb);

        String trimmedString = sb.toString().trim();

        if (trimmedString.length() > 0) {
            trimmedString = trimmedString.substring(0, trimmedString.length() - 1);
        }
        
        return "[" + trimmedString + "]";
    }
    
    /**
     * Helper method for building a string representation of the tree.
     *
     * @param node The current node being traversed.
     * @param sb The StringBuilder to append the node data.
     */
    private void toStringHelper(Node<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        toStringHelper(node.left, sb);
        sb.append(node.data).append(", ");
        toStringHelper(node.right, sb);
    }
}