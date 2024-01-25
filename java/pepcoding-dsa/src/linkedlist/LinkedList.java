package linkedlist;

public class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
        Node n = new Node();
        n.val = val;
        n.next = null;
        if (size == 0) {
            head = tail = n;

        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    int size() {
        return size;
    }

    void removeFirst() {
        if(size == 0) {
            System.out.println("Linked List is empty");
        } else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    int getFirst() {
        if (size == 0) {
            System.out.println("Linked List is empty");
            return -1;
        }
        return head.val;
    }

    int getLast() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return -1;
        }
        return tail.val;
    }

    int getAt(int index) {
        if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else if (index >= size) {
            System.out.println("Index out of bound");
            return -1;
        } else {
            Node temp = head;
            for (int i=0; i<index && temp!=null ; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
    }

    void addFirst(int val) {
        Node n = new Node();
        n.val = val;
        n.next = head;
        if (size == 0) {
            tail = n;
        }
        head = n;
        size++;
    }

    void addAt(int index, int val) {
        if (size == 0) {
            addFirst(val);
        } if (index == size) {
            addLast(val);
        } else {
            Node temp = head;
            for (int i=0; i<index-1 && temp!=null ; i++) {
                temp = temp.next;
            }
            Node n = new Node();
            n.val = val;
            n.next = temp.next;
            temp.next = n;
        }
    }

    void removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }
}
