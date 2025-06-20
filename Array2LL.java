public class Array2LL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node ConvertArr(int[] arr) {
        Node head = new Node(arr[0]); // create first node
        Node mover = head;      //passing head reference to mover

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); // create new node
            mover.next = temp; // link it
            mover = temp; // move the pointer
        }
        return head; 
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = ConvertArr(arr);
        System.out.println("Head data: " + head.data);
    }
}
