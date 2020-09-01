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

    public void reverseList() {
        if (head == null || head.next == null) {
            return; // empty list or a 1-element list
        }
        // create 3 references, but the FOCUS will always be on the CURRENT node (the one that will "repoint" to the
        // previous node and "burn the bridge" to the next node.
        Node prev = null; // when created, "prev" points to null because "curr" is the head
        Node curr = head; // the FOCUS start on the HEAD
        Node next = curr.next; // since here there are at least 2 elements, curr.next will never be null here
        while (next != null) {
            curr.next = prev; // the CURRENT node points back to "prev" and "burns the bridge" to next
            prev = curr; // "prev" moves one position to the right
            curr = next; // "curr" moves one position to the right
            next = curr.next; // "next" moves one position to the right (in the last iteration "curr.next" is null)
        }
        // when this last "next" is null, it means "curr" is our NEW HEAD so we have to update the pointers
        curr.next = prev; // rebuild the last bridge
        head = curr;
    }

    public void reverseListRec(Node node) {
        if (head == null) return; // empty list
        if (node.next == null) { // base case
            // once the last node is reached, it means it's the NEW HEAD, so we update "head" and return
            head = node;
            return;
        }
        reverseListRec(node.next);
        // all code AFTER the recursive call is executed when the last node is reached and the stack is being emptied;
        // but the call that reached the BASE CASE won't execute the next lines (the call that reached the last node)
        node.next.next = node; // this is changing the direction of the "arrow"
        node.next = null; // and this is "disconnecting" the "arrow" from the "next" node
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
