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
    }
}
