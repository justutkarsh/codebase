package linkedlist;

import java.util.Stack;

public class LinkedLIstExercises {

    public static void main(String[] args) {
        SingleLinkedList<Integer> sl = new SingleLinkedList<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2);
        sl.add(3);
        Node<Integer> n1 = sl.add(1);
        sl.add(10);
        sl.add(3);
        sl.add(1);
        Node<Integer> n2 = sl.add(10);

        n2.next = n1;

        // detectLoopNode(sl.root);

        SingleLinkedList<Integer> sl1 = new SingleLinkedList<Integer>();
        sl1.add(1);
        sl1.add(2);
        sl1.add(3);
        sl1.add(4);
        sl1.add(5);
        sl1.add(6);
        sl1.add(7);
        sl1.add(8);
        sl1.add(9);


        printList(sl1.root);

        reverseOddEven(sl1.root);

        printList(sl1.root);


        // System.out.println(isPalindrome(sl1.root));

        // System.out.println(isPalindromeRecursive(sl1.root, sl1.size()).flag);

        // Node<Integer> head = sl1.root;
        // nthToLast(head,3);
        // partitionList(head, 2);

        // Node<Integer> head = addLists(sl.root,sl1.root,0);
        // SingleLinkedList.print(head);

    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

    private static Node<Integer> reverseOddEven(Node<Integer> integerNode) {
        //1 2 3 4 5 6 7 8   -> 1 3 5 7 8 6 4 2
        Node n = integerNode, evenNode, preEvenNode = null;
        if (n == null || n.next == null)
            return n;
        else {
            while (n != null) {
                System.out.println(n.data);
                evenNode = n.next;
                n.next = n.next.next;

                n = n.next;

                evenNode.next = preEvenNode;
                preEvenNode = evenNode;

                if (n.next == null) {
                    n.next = evenNode;
                    return integerNode;
                }
            }
        }
       return null;
    }

    private static Node<Integer> addLists(Node<Integer> head1,
                                          Node<Integer> head2, int carry) {

        if (head1 == null || head2 == null) {
            return null;
        }

        Node<Integer> result = new Node<Integer>();
        int data = head1.data + head2.data + carry;
        int value = data % 10;
        carry = data / 10;

        result.data = value;
        Node<Integer> t = addLists(head1.next, head2.next, carry);

        result.next = t;

        return result;

    }

    private static int nthToLast(Node<Integer> head, int k) {
        // TODO Auto-generated method stub
        if (head == null)
            return 0;

        int i = nthToLast(head.next, k) + 1;
        if (i == k)
            System.out.println(head.data);
        return i;

    }

    private static void partitionList(Node<Integer> head, Integer d) {
        Node<Integer> bHead = null;
        Node<Integer> aHead = null;

        Node<Integer> t = head;

        while (t != null) {
            if (t.data <= d) {
                Node<Integer> node = new Node<Integer>(t.data);
                node.next = bHead;
                bHead = node;
            } else {
                Node<Integer> node = new Node<Integer>(t.data);
                node.next = aHead;
                aHead = node;
            }
            t = t.next;
        }

        t = bHead;
        while (t.next != null) {
            t = t.next;
        }

        t.next = aHead;

        new SingleLinkedList<Integer>(bHead).print();

    }

    private static void detectLoopNode(Node<Integer> head) {

        Node<Integer> slowPtr = null;
        Node<Integer> fastPtr = null;

        slowPtr = fastPtr = head;
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;

        while (slowPtr != fastPtr && slowPtr != null && fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        slowPtr = head;

        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;

        }

        System.out.println(slowPtr.data);

    }

    public static Boolean isPalindrome(Node<Integer> head) {

        Stack<Integer> st = new Stack<Integer>();
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            st.push(slow.data);
            slow = slow.next;
        }

        // 1,2,3,4,5,6,7
        if (fast != null) {
            slow = slow.next;

            while (slow != null) {
                if (st.pop() != slow.data)
                    return false;
            }
        }

        return true;
    }

    public static class Result<T> {
        Boolean flag;
        Node<T> node;

        public Result(Boolean arg1, Node<T> arg2) {
            flag = arg1;
            node = arg2;
        }
    }

    public static Result<Integer> isPalindromeRecursive(Node<Integer> head,
                                                        int length) {

        if (head == null || length == 0)
            return new Result<Integer>(true, null);

        if (length == 1)
            return new Result<Integer>(true, head.next);

        if (length == 2)
            return new Result<Integer>(head.data == head.next.data,
                    head.next.next);

        Result<Integer> c1 = isPalindromeRecursive(head.next, length - 2);

        if (!c1.flag) {
            return c1;
        }

        if (c1.node.data != head.data) {
            c1.flag = false;

        }
        c1.node.data = head.next.data;
        return c1;

    }

}

