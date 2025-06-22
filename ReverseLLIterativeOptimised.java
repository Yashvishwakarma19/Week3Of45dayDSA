public class ReverseLLIterativeOptimised{
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
    //Reverse LinkedList
    public static Node ReverseLL(Node head){
        Node temp = head;
        Node prev = null;
                                //TC: O(N) as solvine in one go
        while(temp != null){       //SC: O(1) as no change in space we are just changing the pointer
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4};
        Node head = ReturnHead(arr);
        System.out.print("Before Reversing LinkedList: ");
        printList(head);
        
        head = ReverseLL(head);
         System.out.print("After Reversing LinkedList: ");
        printList(head);
       
    }
}