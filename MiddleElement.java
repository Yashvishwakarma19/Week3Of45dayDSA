public class MiddleElement{
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
    public static Node Middle(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;          // T: O(n + n/2)
        }                               // S: O(1)
        temp = head;
        int midNode = (cnt/2) + 1;
        while(temp != null){
            midNode = midNode - 1;
            if(midNode == 0) break;
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = ReturnHead(arr);
        
        Node ele = Middle(head);
         System.out.print("Middle element of LinkedList is: "+ele.data);   
    }
}