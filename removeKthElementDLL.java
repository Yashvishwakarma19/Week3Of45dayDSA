public class removeKthElementDLL{
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
     public static Node deleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;
        return head;
     }
      public static Node deleteKEle(Node head,int k){
        if(head == null) return null;

        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        if (temp == null) return head; // k is out of bounds
        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null && front == null){
            return null;
        }else if(prev == null){
           return deleteHead(head);
        }else if(front == null){
            return deleteTail(head);
        }
        prev.next = front;
        front.back = prev;
        temp.next = temp.back = null;
        return head;
      }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = doublyCreate(arr);
        head = deleteKEle(head,3);
        System.out.print("Printing forward: ");
        printForward(head);
    }
}