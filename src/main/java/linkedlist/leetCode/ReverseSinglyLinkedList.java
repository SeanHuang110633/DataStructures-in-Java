package main.java.linkedlist.leetCode;

import java.util.ArrayList;

/**
 * 反轉單項鏈表
 */
public class ReverseSinglyLinkedList {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println("before reverse: " + o1);
        ListNode listNode1 = reverse5(o1);
        System.out.println("reverse5: " + listNode1);
    }


    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ReverseSinglyLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            ArrayList<Integer> nodeVal = new ArrayList<>();
            ReverseSinglyLinkedList.ListNode currentNode = this;

            while (currentNode != null) {
                nodeVal.add(currentNode.val);
                currentNode = currentNode.next;
            }

            return nodeVal.toString();
        }
    }


    /**
     * 方法1: 基於舊值創建新鏈表並將新的節點指向頭部，即上一個節點
     *
     * @param o1
     * @return
     */
    public static ReverseSinglyLinkedList.ListNode reverse1(ReverseSinglyLinkedList.ListNode o1) {
        ReverseSinglyLinkedList.ListNode newList = null;  //等於創建一個空的新鏈表
        ReverseSinglyLinkedList.ListNode oldList = o1;
        while (oldList != null) {
            newList = new ReverseSinglyLinkedList.ListNode(oldList.val, newList);
            oldList = oldList.next;
        }

        return newList;
    }

    /**
     * 方法2: 刪除舊列表的頭節點加到新列表的頭部，就不需要創造新的節點，
     * 舉例方法1要創造10個node(測試是5個舊的所以是10個)，但方法2不用
     *
     * @param o1
     * @return
     */
    public static ListNode reverse2(ListNode o1) {
        List oldList = new List(o1);
        List newList = new List(null);

        while (true) {
            ListNode listNode = oldList.removeFirst();
            if (listNode == null) {   //刪沒了就break
                break;
            }
            newList.addFirst(listNode);
        }
        return newList.head; //只要頭就可以找到剩下的
    }

    //方法2必須創建一個容器類
    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }


    /**
     * 方法3: 遞迴
     *
     * @param node
     * @return
     */
    static ListNode reverse3(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode lastNode = reverse3(node.next);
        node.next.next = node;
        node.next = null;
        return lastNode;
    }

    /**
     * 方法5:思路同方法2，但是過程導向，2是物件導向
     */
    static ListNode reverse5(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ListNode newNode = null;
        ListNode p = null;

        while (node != null) {
            p = node.next;
            node.next = newNode;
            newNode = node;
            node = p;
        }
        return newNode;
    }
}
