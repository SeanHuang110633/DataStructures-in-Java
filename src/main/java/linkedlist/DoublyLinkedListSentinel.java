package main.java.linkedlist;

import java.util.Iterator;

/**
 * ClassName: DoublyLinkedListSentinel
 * PackageName: main.java.linkedlist
 * Description: 雙向鏈錶帶哨兵
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    private Node head; // 頭哨兵
    private Node tail; // 尾哨兵

    static class Node {
        private Node prev;
        private int val;
        private Node next;

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    public DoublyLinkedListSentinel() {
        this.head = new Node(null, 123, null);
        this.tail = new Node(null, 456, null);
        head.next = tail;
        tail.prev = head;
    }


    /**
     * 透過索引找到對應的Node
     *
     * @param index
     * @return Node
     */
    private Node findNode(int index) {
        if (index < -1) {
            throw new IllegalArgumentException("invalid param");
        }
        int i = -1; // 從哨兵開始遍歷
        Node pointer = head; // 指針指向哨兵
        while (pointer != tail) {
            if (index == i) {
                return pointer;
            }
            i++;
            pointer = pointer.next;
        }
        return null;
    }


    public void add(int index, int val) {
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException("invalid param");
        }
        Node nextNode = preNode.next;
        Node addNode = new Node(preNode, val, nextNode);
        preNode.next = addNode;
        nextNode.prev = addNode;
    }


    public void remove(int index) {
        Node preNode = findNode(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException("invalid param");
        }
        Node removeTarget = preNode.next;
        if (removeTarget == tail) {
            throw new IllegalArgumentException("invalid param");

        }
        preNode.next = removeTarget.next;
        removeTarget.next.prev = preNode;

    }

    // 雙向列表的特色
    public void addFirst(int val) {
        add(0, val);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int val) {
        Node preNode = tail.prev;
        Node addNode = new Node(preNode, val, tail);
        preNode.next = addNode;
        tail.prev = addNode;
    }

    public void removeLast() {
        Node removeNode = tail.prev;
        if(removeNode == head){
           throw new IllegalArgumentException("Invalid");
        }
        Node preNode = removeNode.prev;

        preNode.next = tail ;
        tail.prev = preNode;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node pointer = head.next; // 頭哨兵不用遍歷

            @Override
            public boolean hasNext() {
                return pointer != tail;
            }

            @Override
            public Integer next() {
                int res = pointer.val;
                pointer = pointer.next;
                return res;
            }
        };
    }
}
