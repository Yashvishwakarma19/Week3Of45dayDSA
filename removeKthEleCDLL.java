public class removeKthEleCDLL {
    static class Node {
        int data;
        Node back;
        Node next;

        Node(int data) {
            this.data = data;
            this.back = null;
            this.next = null;
        }
    }

    public static Node doublyCreate(int[] arr) {
        Node head = new Node(arr[0]);
        Node back = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            back.next = temp;
            temp.back = back;
            back = temp;
        }
        // Make it circular
        head.back = back;
        back.next = head;
        return head;
    }

    public static void printForward(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == head) return null;
        Node tail = head.back;
        Node newTail = tail.back;
        newTail.next = head;
        head.back = newTail;
        return head;
    }

    public static Node deleteHead(Node head) {
        if (head == null || head.next == head) return null;
        Node tail = head.back;
        Node newHead = head.next;
        tail.next = newHead;
        newHead.back = tail;
        return newHead;
    }

    public static Node deleteKEle(Node head, int k) {
        if (head == null) return null;
        if (k == 1) return deleteHead(head);

        int cnt = 1;
        Node temp = head;
        while (cnt < k) {
            temp = temp.next;
            if (temp == head) return head; // k out of bounds
            cnt++;
        }

        Node prev = temp.back;
        Node next = temp.next;

        prev.next = next;
        next.back = prev;

        if (temp == head) head = next;

        temp.next = temp.back = null; 
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {66, 87, 21, 90, 54};
        Node head = doublyCreate(arr);
        head = deleteKEle(head, 3);
        System.out.print("Printing forward: ");
        printForward(head);
    }
}
