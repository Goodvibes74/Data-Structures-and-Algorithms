package data_structures.stacks.using_array;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack {
  // Internal list to store stack elements
  private final List<Integer> array = new ArrayList<>();

  // Constructor to initialize the stack
  public MyStack() {
  }

  // Method to get the top element of the stack without removing it
  public int peak() {
    // If the stack is empty, throw an exception
    if(array.isEmpty()) {
      throw new EmptyStackException();
    }
    // Return the last element in the list (top of the stack)
    return array.get(this.array.size() - 1);
  }

  // Method to remove and return the top element of the stack
  public int pop() {
    // If the stack is empty, throw an exception
    if(array.isEmpty()) {
      throw new EmptyStackException();
    }
    // Remove and return the last element in the list (top of the stack)
    return array.remove(array.size() - 1);
  }

  // Method to add an element to the top of the stack
  public void push(int valueToPush) {
    // Add the value to the end of the list
    array.add(valueToPush);
  }

  // Method to print all elements in the stack
  public void printStack() {
    // Iterate through the list and print each value
    for (int value : array) {
      System.out.println(value);
    }
  }

  // Main method to demonstrate stack operations
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(5); // Push 5 onto the stack
    stack.printStack(); // Print the stack: [5]
    stack.push(3); // Push 3 onto the stack
    stack.printStack(); // Print the stack: [5, 3]
    stack.pop(); // Remove the top element (3) from the stack
    stack.printStack(); // Print the stack: [5]
  }
}
