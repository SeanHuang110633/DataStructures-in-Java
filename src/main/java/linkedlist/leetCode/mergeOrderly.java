package main.java.linkedlist.leetCode;

import java.util.ArrayList;

public class mergeOrderly {

    public static void main(String[] args) {
        ListNode o3 = new ListNode(6, null);
        ListNode o2 = new ListNode(3, o3);
        ListNode o1 = new ListNode(1, o2);

        ListNode a3 = new ListNode(5, null);
        ListNode a2 = new ListNode(3, a3);
        ListNode a1 = new ListNode(1, a2);
        System.out.println(function(o1, a1));
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

    static ListNode function(ListNode merge1, ListNode merge2) {
        ListNode result = new ListNode(-1, null);
        ListNode resultPointer = result;
        while (merge1 != null && merge2 != null) {
            if (merge1.val <= merge2.val) {
                resultPointer.next = merge1;
                merge1 = merge1.next;
            } else {
                resultPointer.next = merge2;
                merge2 = merge2.next;
            }
            resultPointer = resultPointer.next;
        }

        if(merge1 != null){
            resultPointer.next = merge1;
        }
        if(merge2 != null){
            resultPointer.next = merge2;
        }

        return result.next;
    }
}
