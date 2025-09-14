import java.util.EmptyStackException;

/**
 * A singly linked list.
 * 
 * @author Joel Henriksson
 * @version 24/02/02
 */
public class LinkedList<T> implements Stack<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void push(T element) {
        ListElement<T> newElement = new ListElement<>(element);
        if (isEmpty()) {
            first = newElement;
            last = newElement;
        } else {
            newElement.next = first;
            first = newElement;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removedData = first.data;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        size--;
        return removedData;
    }

    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return first.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }
}
