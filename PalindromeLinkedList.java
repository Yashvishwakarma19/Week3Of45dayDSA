public class PalindromeLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Solution class with isPalindrome and reverse
    static class Solution {
        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode newHead = reverse(head.next);
            ListNode front = head.next;
            front.next = head;
            head.next = null;
            return newHead;
        }

        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode newHead = reverse(slow.next);
            ListNode first = head;
            ListNode second = newHead;

            while (second != null) {
                if (first.val != second.val) {
                    slow.next = reverse(newHead);
                    return false;
                }
                first = first.next;
                second = second.next;
            }

            slow.next = reverse(newHead);
            return true;
        }
    }

    // Utility to create a linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 1};
        ListNode head = createList(input);

        Solution sol = new Solution();
        boolean result = sol.isPalindrome(head);

        System.out.println("Is Palindrome: " + result);
    }
}
