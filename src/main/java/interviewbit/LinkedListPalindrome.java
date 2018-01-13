package interviewbit;

/**
 * Created by utkarsh on 05-09-2016.
 */

//Definition for singly-linked list.

class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void print() {
        ListNode current = this;
        while (current != null) {
            System.out.println(current.val + "->");
            current = current.next;
        }
    }
}


public class LinkedListPalindrome {

    public static void main(String[] args) {

        ListNode root = new ListNode(6);
        root.next = new ListNode(3);
        root.next.next = new ListNode(7);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(6);

        root = new ListNode(3);
        root.next = new ListNode(1);
        root.next.next = new ListNode(3);

        LinkedListPalindrome solution = new LinkedListPalindrome();
        System.out.println(solution.lPalin(root));
    }

    public int lPalin(ListNode A) {

        ListNode slow = A, fast = A, mid, preslow = null;

        if (A == null || A.next == null) return 0;

        while (fast != null && fast.next != null) {
            preslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        ListNode curr = null, prev = null, next = null;

        if (fast == null) {
            curr = mid;
        } else {
            curr = mid.next;
        }

        preslow.next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        mid = A;
        curr = prev;
        while (mid != null && curr != null) {
            if (mid.val == curr.val) {
                mid = mid.next;
                curr = curr.next;
            } else return 0;
        }
        if (mid == null && curr == null) return 1;
        return 0;
    }

}


