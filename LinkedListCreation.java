public class LinkedListCreation{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Node y = new Node(arr[2]);
        System.out.println("Array Element inserted to LinkedList is: " +y.data);
        
    }
}