package data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is an example of how to write the same code in the course.
 * This is NOT an example of a dynamic array in Java. For dynamic arrays in Java, please see {@link ArrayList}.
 */
public class MyArray {

  private Object[] data; // Array to store elements
  private int capacity;  // Maximum capacity of the array
  private int length;    // Current number of elements in the array

  // Constructor to initialize the array with a capacity of 1
  public MyArray () {
    capacity = 1;
    length = 0;
    data = new Object[1];
  }

  // Method to get the element at a specific index
  public Object get(int index) {
    return data[index];
  }

  // Method to add a new element to the array
  public void push(Object obj) {
    // If the array is full, double its capacity
    if(capacity == length) {
      data = Arrays.copyOf(data, capacity * 2);
      capacity *= 2;
    }
    // Add the new element and increase the length
    data[length] = obj;
    length++;
  }

  // Method to remove and return the last element of the array
  public Object pop() {
    Object popped = data[length - 1]; // Get the last element
    data[length - 1] = null;         // Remove the last element
    length--;                        // Decrease the length
    return popped;
  }

  // Method to delete an element at a specific index
  public Object delete(int index) {
    Object itemToDelete = data[index]; // Get the element to delete
    shiftItems(index);                 // Shift the remaining elements
    return itemToDelete;
  }

  // Helper method to shift elements to the left after deletion
  public void shiftItems(int index) {
    for (int i = index; i < length - 1; i++) {
      data[i] = data[i + 1]; // Shift each element one position to the left
    }
    data[length - 1] = null; // Remove the last element
    length--;                // Decrease the length
  }

  // Main method to test the MyArray class
  public static void main(String[] args) {
    MyArray m = new MyArray();
    m.push("Hello"); // Add "Hello" to the array
    m.push("World"); // Add "World" to the array

    // Print all elements in the array
    for (int i = 0; i < m.length; i++) {
      System.out.println(m.get(i));
    }
  }
}
