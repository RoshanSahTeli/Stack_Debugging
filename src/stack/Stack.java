package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    
    //Here in pop operation the given code had some issues related to memory i.e when elements are popped from stack,
    //the references to the popped elements are not cleared.When the element is popped and size is reduced  the reference 
    //to that object does still exist in array but is no longer part of the stack.
    //I had fixed it by setting the element to null after pop operation so that garbage collector can reclaim the space.
    
    
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; 
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    
    public static void main(String[] args) {
        Stack stack = new Stack();

        
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");

        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Popped element: " + stack.pop()); 
        stack.push("Element 4");
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Popped element: " + stack.pop()); 

        
    }
}
