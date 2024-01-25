package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        Node head = reverseLinkedList(linkedList.head);
        display(head);

    }

    private static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " - > ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextToCurr = current.next;
            current.next = prev;
            prev = current;
            current = nextToCurr;
        }
        return prev;
    }
}
