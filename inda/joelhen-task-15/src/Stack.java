import java.util.EmptyStackException;

/**
 * Interface representing a stack data structure.
 * @param <T> the type of the elements stored in the stack
 */
public interface Stack<T> {
    
    /**
     * Adds an element to the top of the stack.
     * @param elem the element to push onto the stack
     */
    void push(T elem);

    /**
     * Removes and returns the top element in the stack.
     * Throws an EmptyStackException if the stack is empty.
     * @return the top element in the stack
     * @throws EmptyStackException if the stack is empty
     */
    T pop() throws EmptyStackException;

    /**
     * Returns the top element in the stack without removing it.
     * Throws an EmptyStackException if the stack is empty.
     * @return the top element in the stack
     * @throws EmptyStackException if the stack is empty
     */
    T top() throws EmptyStackException;

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Returns true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
}