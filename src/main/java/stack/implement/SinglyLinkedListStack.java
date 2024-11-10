package main.java.stack.implement;

import java.util.Iterator;

/**
 * ClassName: SinglyLinkedListStack
 * PackageName: main.java.datastructure.stack.test
 * Description: 用單向鏈表實現stack
 *
 */
public class SinglyLinkedListStack<E> implements myStack<E>,Iterable<E> {


    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);
    private int size;
    private int capacity;

    public SinglyLinkedListStack(int capacity) {
        this.capacity = capacity;
    }


    public SinglyLinkedListStack() {
        this.capacity = 8;
    }

    @Override
    public boolean push(E e) {
        if(isFull()){
            return false;
        }
        head.next = new Node<>(e, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        if(first == null){
            return null;
        }
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        if(first == null){
            return null;
        }
        return first.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node pointer = head.next;
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                Object value = pointer.value;
                pointer = pointer.next;
                return (E)value;
            }
        };
    }
}
