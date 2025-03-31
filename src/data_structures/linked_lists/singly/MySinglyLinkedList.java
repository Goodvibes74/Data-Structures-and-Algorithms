package data_structures.linked_lists.singly;

public class MySinglyLinkedList {
  private MySinglyLinkedNode head; // The first node in the linked list
  private MySinglyLinkedNode tail; // The last node in the linked list
  private int length; // The number of nodes in the linked list

  // Constructor to initialize the linked list with a single node
  public MySinglyLinkedList(int value) {
    head = new MySinglyLinkedNode(value); // Create the first node
    tail = head; // Since there's only one node, head and tail are the same
    length = 1; // Length is 1
  }

  // Add a new node at the beginning of the list
  public void prepend(int value) {
    head = new MySinglyLinkedNode(value, head); // Create a new node and point it to the current head
    if (length == 1) {
      tail = head.getNext(); // Update tail if the list had only one node
    }
    length++; // Increment the length
  }

  // Add a new node at the end of the list
  public void append(int value) {
    MySinglyLinkedNode newNode = new MySinglyLinkedNode(value); // Create a new node
    if (tail != null) {
      tail.setNext(newNode); // Link the current tail to the new node
    } else {
      head = newNode; // If the list is empty, set the new node as the head
    }
    tail = newNode; // Update the tail to the new node
    length++; // Increment the length
  }

  // Insert a new node at a specific index
  public void insert(int index, int value) {
    index = wrapIndex(index); // Ensure the index is within bounds
    if (index == 0) {
      prepend(value); // If index is 0, prepend the value
      return;
    }
    if (index == length) {
      append(value); // If index is at the end, append the value
      return;
    }
    MySinglyLinkedNode leader = traverseToIndex(index - 1); // Find the node before the target index
    MySinglyLinkedNode newNode = new MySinglyLinkedNode(value, leader.getNext()); // Create a new node and link it
    leader.setNext(newNode); // Update the leader's next pointer
    length++; // Increment the length
  }

  // Remove a node at a specific index
  public void remove(int index) {
    index = wrapIndex(index); // Ensure the index is within bounds
    if (index == 0) {
      head = head.getNext(); // Update the head to the next node
      if (length == 1) tail = null; // If the list becomes empty, set tail to null
      length--; // Decrement the length
      return;
    }
    MySinglyLinkedNode leader = traverseToIndex(index - 1); // Find the node before the target index
    MySinglyLinkedNode nodeToRemove = leader.getNext(); // Get the node to remove
    leader.setNext(nodeToRemove.getNext()); // Skip the node to remove
    if (index == length - 1) {
      tail = leader; // Update the tail if the last node was removed
    }
    length--; // Decrement the length
  }

  // Reverse the linked list
  public void reverse() {
    MySinglyLinkedNode first = head; // Start with the head
    tail = head; // Update the tail to the current head
    MySinglyLinkedNode prev = null; // Initialize the previous node as null
    while (first != null) {
      MySinglyLinkedNode temp = first.getNext(); // Store the next node
      first.setNext(prev); // Reverse the link
      prev = first; // Move the previous pointer forward
      first = temp; // Move the current pointer forward
    }
    head = prev; // Update the head to the last node
  }

  // Traverse the list to a specific index
  public MySinglyLinkedNode traverseToIndex(int index) {
    index = wrapIndex(index); // Ensure the index is within bounds
    MySinglyLinkedNode currentNode = head; // Start from the head
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext(); // Move to the next node
    }
    return currentNode; // Return the node at the target index
  }

  // Ensure the index is within valid bounds
  private int wrapIndex(int index) {
    return Math.max(Math.min(index, length - 1), 0); // Clamp the index between 0 and length - 1
  }

  // Print the linked list in a readable format
  public void printList() {
    if (head == null) return; // If the list is empty, do nothing
    MySinglyLinkedNode currentNode = head; // Start from the head
    System.out.print(currentNode.getValue()); // Print the value of the head
    currentNode = currentNode.getNext(); // Move to the next node
    while (currentNode != null) {
      System.out.print(" --> " + currentNode.getValue()); // Print the value of each node
      currentNode = currentNode.getNext(); // Move to the next node
    }
    System.out.println(); // End the line
  }

  // Main method to test the linked list
  public static void main(String[] args) {
    MySinglyLinkedList list = new MySinglyLinkedList(5); // Create a new list with initial value 5
    list.append(8); // Append 8 to the list
    list.append(4); // Append 4 to the list
    list.prepend(10); // Prepend 10 to the list
    list.printList(); // Print the list
    list.insert(2, 15); // Insert 15 at index 2
    list.printList(); // Print the list
    list.remove(100); // Attempt to remove a node at an out-of-bounds index (will remove the last node)
    list.remove(2); // Remove the node at index 2
    list.printList(); // Print the list
    list.reverse(); // Reverse the list
    list.printList(); // Print the reversed list
  }
}
