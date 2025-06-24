public class breakALoop{
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
     public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void removeLoop(Node head){
       Node slow = head;
       Node fast = head;
       while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) break;
       }
       if(slow != fast) return; //checking once again if their is a loop

       slow = head;     //now starting slow again from head and fast from same position
       while(slow.next != fast.next){
        slow = slow.next;
        fast = fast.next;
       }
       fast.next = null;
    }
    public static void main(String[] args) {
        int[] arr= {66,87,21,90,54};
        Node head = ReturnHead(arr);
        
       // Creating a loop for testing: point last node to second node
        head.next.next.next.next.next = head.next;  // 54 -> 87 (loop)

        if (detectLoop(head)) {
            System.out.println("Loop is Present");
            removeLoop(head);
        } else {
            System.out.println("No loop Present");
        }
        // Check again
        if (!detectLoop(head)) {
            System.out.print("Loop removed successfully, Final Linked List: ");
            printList(head);
        } else {
            System.out.println("Loop still exists.");
        }
    }
}