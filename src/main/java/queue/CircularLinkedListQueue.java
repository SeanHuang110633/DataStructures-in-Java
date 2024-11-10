package main.java.queue;

import java.util.Iterator;

/**
 * ClassName: LinkedListqueue
 * PackageName: main.java.queue
 * Description:
 *
 * @Create: 2024/10/3-下午 07:52
 */
public class CircularLinkedListQueue<E> implements MyQueue<E>,Iterable<E>{

    static class Node<E>{
         E val;
         Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null,null);
    private Node<E> tail = head;
    private int size; //
    private int capacity = Integer.MAX_VALUE;


    {
        // 兩個構造器都要初始化
        this.tail.next = head;
    }

    public CircularLinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public CircularLinkedListQueue() {
    }

    /**
     * 向隊列尾插入值
     * Params: value - 待插入值
     * Returns: 插入成功返回 true, 插入失敗返回 false
     *
     * @param value
     */
    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        Node<E> node = new Node<>(value, head);
        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    /**
     * 從對列頭取出值, 並移除
     * Returns: 若隊列非空返回隊列頭值, 若隊列為空返回 null
     */
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> firstNode = head.next;
        head.next = firstNode.next;
        if(firstNode == tail){
            tail = head;
        }
        size--;
        return firstNode.val;
    }

    /**
     * 從隊列頭取出值, 不移除
     * Returns: 若隊列非空返回隊列頭值, 若隊列為空返回 null
     */
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        Node<E> firstNode = head.next;
        return firstNode.val;
    }

    /**
     * 檢查隊列是否為空
     * Returns: 為空返回 true, 不為空返回 false
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 檢查隊列是否已滿
     * Returns: 滿返回 true, 不滿返回 false
     */
    @Override
    public boolean isFull() {
        return size == capacity;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> pointer = head.next;
            @Override
            public boolean hasNext() {
                return pointer != head;
            }

            @Override
            public E next() {
                E res = pointer.val;
                pointer = pointer.next;
                return res;
            }
        };
    }
}
