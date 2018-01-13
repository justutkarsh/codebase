package linkedlist;

public class ReverseKLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node head = null; // Create head node

    // Simple iterative Reversal of a linked list
    private static Node iterativeReverse(Node node) {

        if (node == null || node.next == null)
            return node;
        Node curr = node, prev = null, next = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    // Simple Recursive Reverse of a linked list
    private static Node recursiveReverse(Node node) {
        if (node == null || node.next == null)
            return node;

        Node rest = recursiveReverse(node.next);

        node.next.next = node;
        node.next = null;
        return rest;
    }

    // Recursive Reversal of a group of k elements
    // 1. Reverse the first sub-list of k element and keep track of next and
    // previous nodes
    // 2. head.next = reverse(next,k ) - recursively call this function on
    // sub-groups
    // 3. return prev - prev becomes new next
    private static Node reverse(Node node, int k) {
        Node current = node;
        Node next = node, prev = null;
        int count = 0;
        // reverse first k elements
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        // next is now pointer to k+1th node. Recursively call reverse
        // for the list starting from that point
        if (next != null) {
            node.next = reverse(next, k);
        }
        // prev is the new head
        return prev;
    }

    // 1,2,3,4,5,6,7,8
    private static Node reversek(Node root, int k) {
        Node prev = null, curr = root, next = root;
        int count = 0;
        while (curr != null && count < k) {
            System.out.println();
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count++;
            System.out.format("prev:%d curr %d next:%d count:%d",
                    prev == null ? -1 : prev.data, curr == null ? -1
                            : curr.data, next == null ? -1 : next.data, count);
        }
        if (next != null)
            root.next = reversek(curr, k);
        return prev;
    }

    // 1,2,3,4,5,6,7,8
    private static Node reverse1k(Node root, int k) {
        if (root == null)
            return root;
        Node prev = null, curr = root, next = root;
        int count = 1;
        while (curr != null && count < k) {
            System.out.println();
            next = curr.next;
            // curr.next = prev;
            prev = curr;
            curr = next;

            count++;
            System.out.format("prev:%d curr %d next:%d count:%d",
                    prev == null ? -1 : prev.data, curr == null ? -1
                            : curr.data, next == null ? -1 : next.data, count);
        }
        if (curr == null)
            return root;
        else {
            next = curr.next;
            prev.next.next = root.next;
            prev.next = root;
            root.next = reverse1k(next, k);
            return curr;
        }
    }

    // Push all the odds behind the list
    // 1-2-3-4-5-6-7-8-1-2-3-4-5-6-7-8-null
    // 2-2-4-3-5-7
    /*
     * System.out.print("curr->"); System.out.println(curr.data);
	 * System.out.print("prev->"); System.out.println(prev.data);
	 * System.out.print("next->"); System.out.println(next == null ? -1 :
	 * next.data); System.out.print("head->"); printList(head);
	 * System.out.print("oddhead->"); printList(oddHead);
	 * 
	 * System.out.println("-----------");
	 */
    private static Node pushOddBack(Node head) {
        if (head == null || head.next == null)
            return head;
        Node oddHead = null, oddTail = null; //head and tail of new linked list which contains odd no.
        while (head.data % 2 != 0) {
            Node newHead = head.next;
            if (oddHead == null) {
                oddHead = head;
                oddTail = head;
            } else {
                oddTail.next = head;
                oddTail = head;
            }
            oddTail.next = null;
            head = newHead;
        }
        Node curr = head, prev = head, next = null;
        while (curr != null) {
            next = curr.next;
            if (curr.data % 2 != 0) {
                oddTail.next = curr;
                oddTail = curr;
                oddTail.next = null;
                prev.next = next;
                curr = next;
            } else {
                prev = curr;
                curr = next;
            }
        }
        prev.next = oddHead; // appending odd list to the end
        return head;

    }

    // utility methods
    // push a node in the ll
    private static void push(int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;

    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ReverseKLL kll = new ReverseKLL();
        kll.push(8);
        kll.push(8);
        kll.push(8);
        kll.push(7);
        kll.push(6);
        kll.push(5);
        kll.push(4);
        kll.push(3);
        kll.push(2);
        kll.push(1);
        kll.push(8);
        kll.push(7);
        kll.push(6);
        kll.push(5);
        kll.push(4);
        kll.push(3);
        kll.push(2);
        kll.push(1);
        kll.push(3);
        kll.push(3);
        kll.push(3);

        kll.printList(head);
        // head = kll.reverse(head, 3);
        // head = kll.reverse1k(head, 5);
        // head = kll.recursiveReverse(head);
        // head = kll.iterativeReverse(head);
        head = kll.pushOddBack(head);
        System.out.println("===========================");
        kll.printList(head);

    }
}