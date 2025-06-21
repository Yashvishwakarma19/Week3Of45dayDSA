public class DeleteHeadLL{
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
        public static Node DeleteHead(Node head){
            if(head == null) return head;
            head = head.next;
            return head;
        }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4};
        Node head = ReturnHead(arr);
        System.out.println("Head before deleting is: "+ head.data);
        head = DeleteHead(head);
        System.out.println("Head after deleting is: " +head.data);
    }
}