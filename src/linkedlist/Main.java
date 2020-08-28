package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(12);
        linkedList.append(56);
        linkedList.prepend(89);
        linkedList.deleteWithValue(56);
        System.out.println(linkedList.printList());
        System.out.println(linkedList.countElements());
        LinkedList list2 = new LinkedList();
        System.out.println(list2.printList());
        System.out.println(list2.countElements());

        System.out.println("Reversing a singly linked list:");
        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.append(10);
        System.out.println(l2.printList());
        l2.reverseList();
        System.out.println(l2.printList());
        
        LinkedList l3 = new LinkedList();
        l3.append(1);
        l3.append(10);
        l3.append(100);
        System.out.println(l3.printList());
        l3.reverseList();
        System.out.println(l3.printList());

        LinkedList l4 = new LinkedList();
        l4.append(1);
        l4.append(10);
        l4.append(100);
        l4.append(1000);
        System.out.println(l4.printList());
        //l4.reverseList();
        l4.reverseListRec(l4.head);
        System.out.println(l4.printList());
        System.out.println(l4.head.data); // 1000
    }
}
