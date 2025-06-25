public class ArrayToDoublyLL{
    static class Node{
        int data;
        Node prev;
        Node next;

       
         Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    public static Node doublyCreate(int[] arr){
         Node head = new Node(arr[0]);
         Node prev = head;
         for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;  
            prev = temp;
         }
         return head;
    }
     public static void printForward(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
     }
     public static void printBackward(Node tail){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
     }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = doublyCreate(arr);
        System.out.print("Printing forward: ");
        printForward(head);

        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        System.out.print("Printing Backward: ");
        printBackward(tail);
       
    }
}