public class insertBefElementCDLL {
    static class Node {
        int data;
        Node back;
        Node next;

        Node(int data) {
            this.data = data;
            this.back = null;
            this.next = null;
        }

        Node(int data, Node back, Node next) {
            this.data = data;
            this.back = back;
            this.next = next;
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
        back.next = head;
        head.back = back;
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

    public static void insertbefEl(Node temp, int val) {
      Node prev = temp.back;
      Node newNode = new Node(val,prev,temp);
      prev.next = newNode;
      temp.back = newNode;
    }
    public static void main(String[] args) {
        int[] arr = {66, 87, 21, 90, 54};
        Node head = doublyCreate(arr);
        insertbefEl(head.next, 100); 
        printForward(head);
    }
}
