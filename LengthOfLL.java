public class LengthOfLL{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node ConvertArr(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static int Length(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node head = ConvertArr(arr);
        System.out.print("Length of the Linked List is: " +Length(head));
    }
}