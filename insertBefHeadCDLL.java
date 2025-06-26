public class insertBefHeadCDLL{
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
    public static Node doublyCircularCreate(int[] arr) {
        Node head = new Node(arr[0]);
        Node back = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            back.next = temp;
            temp.back = back;
            back = temp;
        }
        // Making it circular
        back.next = head;
        head.back = back;

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
        public static void printForwardCircular(Node head){
            if (head == null) return;
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
    }
    public static Node insertheadbef(Node head, int val){
        Node tail = head.back;
        Node newNode = new Node(val,tail,head);
        tail.next = newNode;
        head.back  = newNode;
        return newNode;
    }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = doublyCircularCreate(arr);
        head = insertheadbef(head, 22);
        printForwardCircular(head);
    }
}