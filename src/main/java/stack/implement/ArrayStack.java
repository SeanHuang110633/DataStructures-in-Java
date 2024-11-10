package main.java.stack.implement;

import java.util.Iterator;

/**
 * ClassName: ArrayStack
 * PackageName: main.java.datastructure.stack
 * Description:
 *
 * @Create: 2024/10/4-下午 04:37
 */
public class ArrayStack<E> implements myStack<E>, Iterable<E> {

    private E[] array;
    private int top;

    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }


    @Override
    public boolean push(E e) {
        if(isFull()){
            return false;
        }
        array[top++] = e;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        E res = array[top - 1];
        top--;
        return res;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pointer = top;
            @Override
            public boolean hasNext() {
                return pointer > 0;
            }

            @Override
            public E next() {
                return array[--pointer];
            }
        };
    }
}
