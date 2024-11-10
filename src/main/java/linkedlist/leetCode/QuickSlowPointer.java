package main.java.linkedlist.leetCode;

import java.util.ArrayList;

public class QuickSlowPointer {

    public static void main(String[] args) {
        ListNode o6 = new ListNode(6, null);
        ListNode o5 = new ListNode(5, o6);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        //System.out.println(function(o1));
        System.out.println(function1(o1, 2));
    }

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            ArrayList<Integer> nodeVal = new ArrayList<>();
            ListNode currentNode = this;

            while (currentNode != null) {
                nodeVal.add(currentNode.val);
                currentNode = currentNode.next;
            }

            return nodeVal.toString();
        }
    }

    static ListNode function(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }


    static ListNode function1(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
