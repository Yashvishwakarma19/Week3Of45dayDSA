public class insertBeforeDLL{
    static class Node{
        int data;
        Node back;
        Node next;
         Node(int data){
            this.data=data;
            this.back=null;
            this.next=null;
        }
         Node(int data,Node back,Node next){
            this.data=data;
            this.back=back;
            this.next=next;
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
     public static Node insertbefhead(Node head,int val){
        Node newNode = new Node(val,null,head);
        head.back = newNode;
      return newNode;
     }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = doublyCreate(arr);
        head = insertbefhead(head,22);
        printForward(head);
    }
}