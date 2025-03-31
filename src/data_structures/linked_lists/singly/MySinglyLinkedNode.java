package data_structures.linked_lists.singly;

// This class represents a node in a singly linked list.
public class MySinglyLinkedNode {

  // The value stored in this node.
  private int value;

  // A reference to the next node in the linked list.
  private MySinglyLinkedNode next;

  // Constructor to create a node with a given value and no next node.
  public MySinglyLinkedNode(int value) {
    this.value = value;
    this.next = null; // By default, the next node is set to null.
  }

  // Constructor to create a node with a given value and a reference to the next node.
  public MySinglyLinkedNode(int value, MySinglyLinkedNode next) {
    this.value = value;
    this.next = next;
  }

  // Getter method to retrieve the value of this node.
  public int getValue() {
    return value;
  }

  // Setter method to update the value of this node.
  public void setValue(int value) {
    this.value = value;
  }

  // Getter method to retrieve the reference to the next node.
  public MySinglyLinkedNode getNext() {
    return next;
  }

  // Setter method to update the reference to the next node.
  public void setNext(MySinglyLinkedNode next) {
    this.next = next;
  }
}
