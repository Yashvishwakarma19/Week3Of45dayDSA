public class DetectLoopHareTor{
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
    public static boolean detectLoop(Node head){
       Node slow = head;
       Node fast = head;
       while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) return true;
       }
       return false;
    }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = ReturnHead(arr);
        
        if(detectLoop(head)){
            System.out.println("Loop is Present");
        }else{
            System.out.println("No loop Present");
        }
    }
}