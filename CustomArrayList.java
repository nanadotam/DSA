public class CustomArrayList {
    private Object[] array;
    private int capacity;   // initializing maximumn capacity of the list
    private int array_size;    // current size of the list
    private static final int DEFAULT_CAPACITY = 100; // setting default capacity of CustomArrayList   

    // Constructor for creating a new ArrayList
    public CustomArrayList() {
        this(DEFAULT_CAPACITY); // calls CustomArrayList(capacity)
    }

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity]; // null array with default capacity
        array_size = 0; // intialize to size 0 as list is empty 
    }

    /**
     * Adds an element to the list by specifying the element.
     * Increases array size by one upon adding an element to the array.
     * 
     * @param element specifies the element to be added
     */
    public void add(Object element) {
        // check to see if array needs to be resized
        if (array_size == array.length) {
            // resize the array
            resizeArray(); // method call to resize array
        }
        // add an object element to the end of the list
        array[array_size] = element; // add element to array
        array_size++;   // increase array size
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * index).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= array_size())
     **/
    public Object remove(int index) throws IndexOutOfBoundsException {
        // throw exception if out of bounds
        // calls check index helper method to make the check modular
        checkIndex(index);
        Object removedElement = array[index]; // stores index to be removed
        
        // shift elements to left to fill gap for removed index
        for (int i = index; i < array_size - 1; i++) {
            array[i] = array[i + 1]; // increase by 1 because inndex starts from 0
        }
        array[--array_size] = null; // make the last element null and decrease array size by 1
        return removedElement;
    }
    

    /**
     * Removes the element by specifying the element in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices) by calling the remove by index method.
     *
     * @param element the element to be removed.
     * @return the element that was removed from the list
     **/
    public Object remove(Object element) {
        // reverse search to find index of removed element
        int index = -1; // make array an index that doesnt exist in array

        for (int i = 0; i < array_size; i++) {
            if (array[i] != null && array[i].equals(element)) {
                index = i; // assign found index to variable index
                break;  // exit the loop once the element is found
            }
        }

        // remove element by index
        if (index != -1) {
            return remove(index); // remove element by found index
        } else {
            return null; // return null, if not found
        }
    }

    /**
     * Returns the element at the specified index in the list.
     * 
     * @param index index of the element to be returned; must not be negative.
     * @return the element at the specified index in the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= array_size())
     */
    public Object get(int index)  throws IndexOutOfBoundsException {
        if (index < 0 || index >= array_size) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return array[index];
    }


    /**
     * Replaces the element at the specified index with the given element.
     * 
     * @param index position of element to be replaced
     * @param element new element replacing element at specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= array_size())
     */
    // Set method to replace the element at the specified index with the given element.
    public void set(int index, Object element) throws IndexOutOfBoundsException {
    checkIndex(index); // Reuse checkIndex to handle index validation
    array[index] = element;
    }

    /**
     * Gets the size of the array
     * 
     * @return integer of the total number of elements in list
     */
    public int size() {
        return array_size;
    }

    /**
     * Checks if the array is empty. If true, sets the array size to zero
     * 
     * @return size of the array set to zero
     */
    public boolean isEmpty() {
        return array_size == 0;
    }

    /**
     * Displays the elemeents in the array using the stringbuilder class.
     * 
     * @return the elements in string format
     */

    // public String display() {
    //     if (array_size == 0) { return "[]";}
    //     StringBuilder sb = new StringBuilder(); sb.append('[');
    //     for (int i = 0; i < array_size; i++) {sb.append(array[i]).append(", ");}
    //     sb.append(array[array_size - 1]).append(']'); return sb.toString();}
    
    // further check method
    public String display() {
        if (array_size == 0) {
            return "[]";
        }

        StringBuilder nsb = new StringBuilder();
        nsb.append('[');
        for (int i = 0; i < array_size; i++) {
            nsb.append(array[i]);
            // handling trailing comma removal for element at n
            if (i < array_size - 1) {
                nsb.append(", ");
            }
        }
        nsb.append(']');
        return nsb.toString();
    }
    
    // Helper Methods

    /**
     * Helper method to checks if a specified indes is out of bounds in the array
     * 
     * @param index position to be checked
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= array_size())
     */
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= array_size) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    /**
     * Helper method to increase the array capacity. 
     * Copies the array to a new array, tempArray with an increased capacity.
     */
    private void resizeArray() {
        // double array capacity by 2
        capacity *= 2;
        // create new array and pass the new array size into it
        Object[] tempArray = new Object[capacity];
        // copy from beginning to end of old array to new array
        System.arraycopy(array, 0, tempArray, 0, array_size); // System fastcopy > loop
        array = tempArray;
    }
}
