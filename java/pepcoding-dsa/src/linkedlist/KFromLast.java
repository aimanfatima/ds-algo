package linkedlist;

public class KFromLast {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        System.out.println(kFromLast(linkedList.head, 3).val);
    }

    private static Node kFromLast(Node head, int k) {
        Node right = head;
        for (int i=0; i<k ;i++) {
            right = right.next;
        }
        Node left = head;

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        return left;
    }
}
