public class CheckIfPresent{
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
    public static void CheckIfPresent(Node head,int k){
         Node temp = head;
        while(temp != null){
            if(temp.data == k){
                System.out.println("Element is present");
                return;
        }
            temp = temp.next;
        }
        System.out.println("Element is not presnet!!");
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node head = ConvertArr(arr);
        CheckIfPresent(head,7);
        CheckIfPresent(head,3);
    }
}