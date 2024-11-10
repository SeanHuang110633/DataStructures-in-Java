package main.java.linkedlist;

import java.util.Iterator;

/**
 * ClassName: CircularLinkedList
 * PackageName: main.java.linkedlist
 * Description: 雙向環形鏈表(帶哨兵)
 *
 * @Create: 2024/10/3-下午 01:51
 */
public class CircularLinkedList implements Iterable<Integer> {


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

    private Node sentinel = new Node(null, 123, null);

    public CircularLinkedList() {
        // 初始化，都是指向自己
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
    }

    public void addFirst(int val) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node addNode = new Node(a, val, b);
        a.next = addNode;
        b.prev = addNode;
        // 也可以處理鏈表中只有哨兵的情況
    }

    public void addLast(int val) {
        Node lastNode = sentinel.prev;
        Node addNode = new Node(lastNode, val, sentinel);
        lastNode.next = addNode;
        sentinel.prev = addNode;
        // 也可以處理鏈表中只有哨兵的情況
    }

    public void removeFirst() {
        Node a = sentinel;
        Node removedTarget = sentinel.next;
        if (removedTarget == sentinel) {
            throw new RuntimeException("Empty list");
        }
        Node b = removedTarget.next;
        a.next = b;
        b.prev = a;
    }

    public void removeLast() {
        Node a = sentinel;
        Node removedTarget = sentinel.prev;
        if (removedTarget == sentinel) {
            throw new RuntimeException("Empty list");
        }
        Node b = removedTarget.prev;
        b.next = a;
        a.prev = b;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node pointer = sentinel.next; // 頭哨兵不用遍歷

            @Override
            public boolean hasNext() {
                return pointer != sentinel;
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
