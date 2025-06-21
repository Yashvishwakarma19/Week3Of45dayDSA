public class InsertAtHead{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        public static Node ReturnHead(int[] arr){
            Node head = new Node(arr[0]);
            Node mover = head;

            for(int i=1;i<arr.length;i++){
                Node temp = new Node(arr[i]);
                mover.next = temp;
                mover = temp;
            }
            return head;
    }
    // Traverse and printing the linked list
    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    //Insert at head
    public static Node InsertHead(Node head,int ele){
        Node temp = new Node(ele);
        temp.next = head;
        return temp;
    }
        public static void main(String[] args) {
        int[] arr= {77,98,43,11,36};
        Node head = ReturnHead(arr);
        head = InsertHead(head,77);
        printList(head);
       
    }
}