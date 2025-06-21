public class InsertByValue{
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
    //Insert at k position
    public static Node InsertValue(Node head,int ele,int value){
        if(head == null){
            return head;
        }
        if(head.data == value){
            Node temp = new Node(ele);
            temp.next = head;
            return temp;
        }
            Node temp = head;
            while(temp != null){
                if(temp.next.data == value){
                    Node x = new Node(ele);
                    x.next = temp.next;
                    temp.next = x;
                    break;
                }
                temp= temp.next;
            }
            return head;
        }
        public static void main(String[] args) {
        int[] arr= {77,98,43,11,36};
        Node head = ReturnHead(arr);
        head = InsertValue(head,200,11);
        printList(head);
       
    }
}