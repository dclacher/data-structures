package linkedlist;

public class LinkedList {
    Node head; // this is a pointer for the HEAD of the list

    /**
     * Append the data to the end of the linked list
     *
     * @param data the data to be appended
     */
    public void append(int data) {
        // if HEAD is null just create a new node
        if (head == null) {
            head = new Node(data);
            return; // instead of if/else, it uses return to break out of the method
        }
        // start from the HEAD and loop until the last element (to which current.next is actually NULL)
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // when the last element is reached and the loop ends, just point last node's "next" to a new node
        current.next = new Node(data);
    }

    /**
     * Prepend the data to the beginning of the linked list and update the head
     *
     * @param data the data to be prepended
     */
    public void prepend(int data) {
        // if HEAD is null just create a new node
        if (head == null) {
            head = new Node(data);
            // no "return" here, using if/else instead (to show both options - append vs. prepend)
        } else {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead; // we have to update the pointer
        }
    }

    /**
     * It deletes the first node that has the provided value
     *
     * @param data the data to be deleted
     */
    public void deleteWithValue(int data) {
        // if HEAD is null just return
        if (head == null) {
            return;
        }
        // special case: if the node to be delete is the HEAD, the pointer needs to be reassigned to the next node
        if (head.data == data) {
            head = head.next;
            return;
        }
        // loop through the list
        Node current = head;
        while (current.next != null) {
            // we check the data from the next node, not from the one we are currently in;
            // if we find the node to be deleted, we make the current node cut it out of the list by pointing to the
            // next one (skipping the one with the value to be deleted)
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public int countElements() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String printList() {
        if (head == null) {
            return "The list is empty.";
        } else {
            StringBuilder list = new StringBuilder("List: ");
            Node current = head;
            while (current != null) {
                list.append(current.data);
                list.append(",");
                current = current.next;
            }
            return list.substring(0, list.toString().length() - 1);
        }
    }
}
