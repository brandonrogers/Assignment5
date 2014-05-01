
/**
 * Brandon Rogers Assignment 5: Queues Due 7 May 2014
 *
 * @author brandonrogers
 */

import java.util.Queue;
import java.util.Iterator;
import java.util.Collection;

public class SimpleQueue<E> implements Queue<E> {
    
    protected E[] storage;
    private int head, tail, numelements;


    /*
    * constructor method
    * initializes an array called container with 5 elements
    * int head is the variable pointing to the head (start) of the queue/array
    * int tail is the variable pointing to the tail (end) of the queue/array
    * takes and returns no arguments
    */
    public SimpleQueue(){
        
        this.storage = (E[]) new Object[5];
        this.head = 0; // first element in basic array initialize to 0
        this.tail = 0; // last element in basic array initialize to 0
        this.numelements = 0; // total amount of filled elements in the array
    }
    
    /*
    * extend takes no arguments and returns nothing
    * extend copies a SimpleQueue array into another array with the head always
    * = 0 and the tail is the last non null element in the array.
    * This method is called when the add method is called but there is no array 
    * space left
    */
    private Object[] extend(){
        int i = 0;
        E[] tempStorage =  (E[]) new Object[this.size()*2];  // cast to E      
        
        // counter variable i
        // first while loop iterates until head runs off the right edge of the array
        // it reorders the new tempStorage array with the first value at tempStorage[0]
        // up to tempStorage[i]. 
        while (this.head < this.size()) {
            tempStorage[i] = this.storage[this.head];
            this.head++; i++; // increment counters
        }
        
        // second while loop continues from the beginning of storage if the array is
        // abnormal - say the head is greater than the tail
        if (i != this.size()-1) {
            this.head = 0;
            while (this.head < this.tail) {
                tempStorage[i] = this.storage[this.head];
                this.head++; i++; // increment counters
            }
        }
        this.tail = this.size()-1; // resets the tail to be at the last element in the new array
        this.head = 0; // resets the head to = 0
        return tempStorage; // returns tempStorage which has null space at the end
    }
    /*
    * add: This method adds an element to the end of an array
    * it first checks if the array is long enough to add an element
    * 
    *
    */
    @Override
    public boolean add(E itemToAdd) {
           boolean wasAdded;
           
            // A special case where every element is uninitialized null and the head and tail point to null
            if (this.storage[this.head] == null) {
                this.storage[this.head] = itemToAdd;
                this.numelements++;
                wasAdded = true;
            }
            
            // A special case where the array is full and needs to be extended
            else if (this.numelements == this.size()) {
                this.storage = (E[]) this.extend();
                this.tail++;
                this.storage[this.tail] = itemToAdd;
                this.numelements++;
                wasAdded = true;
            }
                
            // A special case where there is no array space beyond the tail but there is null space in front of the head
            // wrap the tail around to Array[0] and wraparound flag = true
            
            else if (this.head != 0 && this.storage[this.head -1] == null && this.tail == this.size() - 1) {
                this.tail = 0;
                this.storage[this.tail] = itemToAdd;
                this.numelements++;
                wasAdded = true;
            }
            
            
            // Normal access
           else {
                this.tail++;
                this.storage[this.tail] = itemToAdd;
                this.numelements++;
                wasAdded = true;
           }
        return wasAdded;
    }
    
    @Override
    public E remove() {
        E temp = this.storage[this.head];
        if (this.head == this.size()-1) {
            
        }
        
        return temp;
    }
    
    /*
    * clear takes no parameters and returns nothing
    * clear iterates through an array and makes all elements = null.
    */
    @Override
    public void clear() {
        for (int i = 0; this.size() > i; i++) {
            storage[i] = null;
        }
    }
    
    /*
    * isEmpty takes no parameters and returns a boolean
    * true = the array is empty (all elements equal to null)
    * false = the array has one or more initialized elements
    * isEmpty iterates through the array and breaks if it finds an initialized element
    */
    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (int i=0; this.size() < i; i++) {
            if (storage[i] != null) {
                empty = false;
                break;
            }
        }
    return empty;
    }
    
    /*
    * size takes no parameters and returns an int
    * returns: the length of an array (.length method from the array API)
    */
    @Override
    public int size() {
        return storage.length;
    }
    
    /*
    * toArray takes no arguments and returns an Object[]
    * toArray is designed to return an array that begins at head and ends at tail
    * the array size will be exactly the number of elements currently in the array with no null space
    * 
    */
    @Override
    public Object[] toArray() {
        int i = 0;
        E[] tempStorage =  (E[]) new Object[this.size()*2];  // cast to E      
        
        // counter variable i
        // first while loop iterates until head runs off the right edge of the array
        // it reorders the new tempStorage array with the first value at tempStorage[0]
        // up to tempStorage[i]. 
        while (this.head < this.size()) {
            tempStorage[i] = this.storage[this.head];
            this.head++; i++; // increment counters
        }
        
        // second while loop continues from the beginning of storage if the array is
        // abnormal - say the head is greater than the tail
        if (i != this.size()-1) {
            this.head = 0;
            while (this.head < this.tail) {
                tempStorage[i] = this.storage[this.head];
                this.head++; i++; // increment counters
            }
        }
        this.tail = this.size()-1; // resets the tail to be at the last element in the new array
        this.head = 0; // resets the head to = 0
        return tempStorage; // returns tempStorage which has null space at the end
    }
    
    // element takes no arguments and returns a generic E
    // element looks at the first element (whatever "head" is pointing at)
    // and returns it.
    @Override
    public E element() {
        return this.storage[this.head];
    }
    
    // peek takes no arguments and returns a generic E
    // peek differs from element in that it returns null if empty or the element
    // if full
    @Override
    public E peek() {
        if (this.storage[this.head] == null)
            return null;
        else
            return this.element();
    }
    
    @Override
    public E poll() {
        if (this.storage[this.head] == null)
            return null;
        else
            return this.remove();
    }
    
    // Unsupported Methods! All Throw UnsupportedOperationException

    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
