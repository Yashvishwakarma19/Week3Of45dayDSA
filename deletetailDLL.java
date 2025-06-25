public class deletetailDLL{
    static class Node{
        int data;
        Node back;
        Node next;

       
         Node(int data){
            this.data=data;
            this.back=null;
            this.next=null;
        }
    }
    public static Node doublyCreate(int[] arr){
         Node head = new Node(arr[0]);
         Node back = head;
         for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            back.next = temp;
            temp.back = back;  
            back = temp;
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
     public static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
       Node tail = head;
       while(tail.next != null){
        tail = tail.next;
       }
       tail.back.next = null;
       return head;
     }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = doublyCreate(arr);
        head = deleteTail(head);
        System.out.print("Printing forward: ");
        printForward(head);
    }
}