public class InsertlnKPosition{
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
    public static Node InsertInKPosition(Node head,int k,int ele){
        if(head == null){
            if(k == ele){
                return new Node(ele);
            }else{
                return head;
            
            }
        }
        if(k == 1){
            Node temp = new Node(ele);
            temp.next = head;
            return temp;
        }
            int cnt = 0;
            Node temp = head;
            while(temp != null){
                cnt++;
                if(cnt == (k-1)){
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
        head = InsertInKPosition(head,3,100);
        printList(head);
       
    }
}