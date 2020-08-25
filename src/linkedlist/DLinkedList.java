package linkedlist;

public class DLinkedList {
    DNode head;
    DNode tail;

    /**
     * Append the data to the end of the linked list
     *
     * @param data the data to be appended
     */
    public void append(int data) {
        if (head == null) { // the list is empty
            head = new DNode(data);
            tail = head; // tail and head point to the same node
            return;
        }
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        DNode newNode = new DNode(data);
        current.next = newNode;
        newNode.prev = current;
        tail = newNode;
    }
}
