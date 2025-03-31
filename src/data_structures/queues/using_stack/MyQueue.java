package data_structures.queues.using_stack;

import java.util.Stack;

public class MyQueue {
  // Main stack to hold elements
  private final Stack<Integer> stack = new Stack<>();
  // Auxiliary stack to assist in reversing the order of elements
  private final Stack<Integer> auxiliaryStack = new Stack<>();
  // Adds an element to the queue
  public void enqueue(int value) {
    stack.push(value); // Push the value onto the main stack
  }

  // Removes and returns the front element of the queue
  public int dequeue() {
    // Move elements from the main stack to the auxiliary stack to reverse the order
    fillAuxiliaryStackWithStack();
    // Pop the top element from the auxiliary stack (front of the queue)
    int value = auxiliaryStack.pop();
    // Restore the original state of the main stack
    fillStackWithAuxiliaryStack();
    return value;
  }

  // Returns the front element of the queue without removing it
  public int peek() {
    // Move elements from the main stack to the auxiliary stack to reverse the order
    fillAuxiliaryStackWithStack();
    // Peek the top element from the auxiliary stack (front of the queue)
    int value = auxiliaryStack.peek();
    // Restore the original state of the main stack
    fillStackWithAuxiliaryStack();
    return value;
  }

  // Prints the elements of the queue in order
  public void printQueue() {
    if (stack.empty()) { // If the queue is empty, do nothing
      return;
    }

    // Move elements from the main stack to the auxiliary stack to reverse the order
    fillAuxiliaryStackWithStack();
    // Convert the auxiliary stack to an array and print each element
    Object[] list = auxiliaryStack.toArray();
    for (Object o : list) {
      System.out.print("-->" + o);
    }
    System.out.println();
    // Restore the original state of the main stack
    fillStackWithAuxiliaryStack();
  }

  // Helper method to move all elements from the main stack to the auxiliary stack
  private void fillAuxiliaryStackWithStack() {
    while (!stack.isEmpty()) { // Transfer elements to reverse their order
      auxiliaryStack.push(stack.pop());
    }
  }

  // Helper method to move all elements back from the auxiliary stack to the main stack
  private void fillStackWithAuxiliaryStack() {
    while (!auxiliaryStack.isEmpty()) { // Restore the original order
      stack.push(auxiliaryStack.pop());
    }
  }

  // Main method to test the queue implementation
  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.enqueue(10); // Add 10 to the queue
    queue.enqueue(4);  // Add 4 to the queue
    queue.enqueue(5);  // Add 5 to the queue
    queue.printQueue(); // Print the queue: -->10-->4-->5
    queue.dequeue();    // Remove the front element (10)
    queue.printQueue(); // Print the queue: -->4-->5
    queue.dequeue();    // Remove the front element (4)
    queue.printQueue(); // Print the queue: -->5
  }
}
