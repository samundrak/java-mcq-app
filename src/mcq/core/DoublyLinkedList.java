package mcq.core;

/**
 *
 * @author samundra-sage
 */
public class DoublyLinkedList {

    Node head; // head of list 

    public void push(int new_data) {
        Node new_Node = new Node(new_data);

        new_Node.next = head;
        new_Node.prev = null;

        if (head != null) {
            head.prev = new_Node;
        }

        head = new_Node;
    }

    class Node {

        int data;
        Node prev;
        Node next;

        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(int d) {
            data = d;
        }
    }
}
