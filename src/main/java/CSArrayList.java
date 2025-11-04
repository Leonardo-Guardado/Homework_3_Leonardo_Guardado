
import java.util.Arrays;
import java.util.AbstractList;
import java.util.Collection;
/**
 *  This class implements some of the methods of the Java
 *  ArrayList class.
 * @param <E> The element type
 *  @author .
 */
public class CSArrayList<E>
        extends AbstractList<E>
{
    // Data Fields

    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array
     *  private E[] theData declares a private array that can hold objects of a type specified by the generic parameter E. This is a common pattern in implementing generic data structures like lists, stacks, queues, where the underlying storage is an array, and the type of elements stored is flexible.*/
    private E[] theData;
    /** The current size */
    private int size = 0;
    /** The current capacity */
    private int capacity = 0;

    /**
     * Construct an empty CSArrayList with the default
     * initial capacity
     */
    /*Java provides an annotation that enables you to compile the constructor without an error message. If you place the statement @SuppressWarnings("unchecked") before the constructor, the compiler warning will not appear*/
    @SuppressWarnings({"unchecked"})
    public CSArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }


    /**
     * Construct an ArrayList<E> from any Collection whose elements are E or a subtype of E.
     * @param c The Collection
     */
    public CSArrayList(Collection<? extends E> c) {
        this.addAll(c);
    }

    /**
     * An empty CSArrayList with a specified initial capacity
     * @param capacity The initial capacity
     */
    @SuppressWarnings("unchecked")
    public CSArrayList(int capacity) {
        this.capacity = capacity;
        theData = (E[]) new Object[capacity];
    }


    /**
     * Add an entry to the data inserting it at the end of the list.
     * @param anEntry The value to be added to the list.
     * @return true since the add always succeeds
     */
    @Override
    public boolean add(E anEntry) {
        // if the size is equal to capacity we must first allocate a new array to hold the data and then copy the data to this new array with method reallocate
        if (size == capacity) {
            reallocate();
        }


        theData[size] = anEntry;
        size++;
        modCount++; //modCount added for iteration
        return true;
    }

    /**
     * Add an entry to the data inserting it at index of the list.
     * @param index - The index of the item desired
     * @param anEntry The value to be added to the list.
     */
    public void add(int index, E anEntry) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size == capacity) {
            reallocate();
        }


        // Shift data in elements from index to size - 1
        for (int i = size; i > index; i--) {
            theData[i] = theData[i - 1];
        }
        // Insert the new item.
        theData[index] = anEntry;
        size++;
        modCount++; //modCount added for iteration
    }
    /**
     * Get a value in the array based on its index.
     * @param index - The index of the item desired
     * @return The contents of the array at that index
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Set the value in the array based on its index.
     * @param index - The index of the item desired
     * @param newValue - The new value to store at this position
     * @return The old value at this position
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    @Override
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /**
     * Remove an entry based on its index
     * @param index - The index of the entry to be removed
     * @return The value removed
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        modCount++; //modCount added for iteration
        return returnValue;
    }

    /**
     * Allocate a new array that is twice the size of the current array. Copies the contents of the current array to the new one using .copyOf
     */
    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }

    /**
     * Get the current size of the array
     * @return The current size of the array
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Get the current capacity of the array
     * @return The current size of the array
     */
    @Override
    public int capacity(){
        return capacity;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element
     * @param item The object to search for
     * @return The index of the first occurrence of the specified item
     *         or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (theData[i] == null && item == null) {
                return i;
            }
            if (theData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    //Part A ----------------------------------------------------------------------------------------------------------
    /**
     * Changes the ArrayList into a string
     * @return The ArrayList as a string, will pop up as [] if there are no items in the arraylist
     */
    public String toString(){
        //only brackets for if there is no element in array
        if (this.size == 0){
            return "[]";
        }
        //Stringbuilder initialized
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            //Adding each element of array to string
            sb.append(theData[i]);
            if (i != size - 1){
                //If the array is not at its end, add a comma and space
                sb.append(", ");
            }
        }
        //Closes array in string
        sb.append("]");
        return sb.toString();
    }

    /**
     * Clears the entire arraylist by turning each item one by one into null
     */
    public void clear(){
        //for every element, change to null
        for (int i = 0; i < size; i++) {
            theData[i] = null;
        }
        //reduce size to zero so that the whole array isn't just nulls
        size = 0;
        modCount++; //modCount added for iteration
    }

    /**
     * Tells us if the arraylist is empty
     * @return boolean of true or false whether the arraylist is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * removes specific object in parameter from the array list, using the indexOf(object) method to locate it
     * @param o element to be removed from this collection, if present
     * @return
     */
    public boolean remove(Object o){
        if (this.size == 0){
            //return false if nothing exists in array
            return false;
        }
        //First, indexOf(o) grabs the index of element from the array
        //Then remove(int) uses that index to remove the element in said index
        remove(indexOf(o));
        //Return true if such object exists
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        //If the minCapacity is greater than the one we started with, the capacity will be incremented to the minimum stated
        if (minCapacity > this.capacity) {
            //main capacity incremented to the minimum
            this.capacity = minCapacity;
        }
        theData = Arrays.copyOf(theData, capacity);
    }

    public void trimToSize() {
        //Makes the capacity of array the same as the amount of elements in array
        this.capacity = this.size;
        //Resizing copy
        theData = Arrays.copyOf(theData, capacity);
    }
//----------------------------------------------------------------------------------------------------------

    //Part C:----------------------------------------------------------------------------------------------------
    public boolean addAll(int index, Collection<? extends E> c){
        //Making sure that index is not outside of given array
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index + " isn't in array");
        }
        //Making sure we are not just adding an empty array into an existing one
        if(c == null){
            throw new  NullPointerException("Collection cannot be null");
        }
        //Make new array using a collection and toArray() method
        Object[] newArray = c.toArray();
        int numElements = newArray.length;
        //Nothing in array, doesn't get added
        if (numElements == 0){
            return false;
        }
        //Ensure that we are not going over the capacity if new elements are being added
        ensureCapacity(this.size + numElements);
        //copy new array to existing array using System.arraycopy()
        System.arraycopy(newArray, 0, theData, index, numElements);
        size += numElements;
        return true;
    }
}
