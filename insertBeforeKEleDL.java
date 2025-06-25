public class insertBeforeKEleDL{
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
     public static Node insertbefK(Node head,int val,int k){
        if(k == 1) return insertbefhead(head, val);

        Node temp = head;
        int cnt = 0;
        while(temp.next != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val,prev,temp);
        prev.next = newNode;
        temp.back = newNode;
        return head;
     }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = doublyCreate(arr);
        head = insertbefK(head,22,3);
        printForward(head);
    }
}