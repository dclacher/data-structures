package linkedlist;

public class DLinkedList {
    DNode head;

    /**
     * Append the data to the end of the linked list
     *
     * @param data the data to be appended
     */
    public void append(int data) {
        if (head == null) {
            head = new DNode(data);
            return;
        }
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        DNode newNode = new DNode(data);
        current.next = newNode;
        newNode.prev = current;
    }
}
