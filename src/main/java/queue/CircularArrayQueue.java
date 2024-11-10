package main.java.queue;

import java.util.Iterator;

/**
 * ClassName: CircularArrayQueue
 * PackageName: main.java.queue
 * Description: 環形數組實現
 *
 */
public class CircularArrayQueue<E> implements MyQueue<E>, Iterable<E> {

    private int head;
    private int tail;
    private E[] array;

    public CircularArrayQueue(int capacity) {
        this.array = (E[]) new Object[capacity + 1];
        // +1是因為要留最後一個位置給tail用
        // 如果不保留，滿跟空的條件會重合
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
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    /**
     * 從對列頭取出值, 並移除
     * Returns: 若隊列非空返回隊列頭值, 若隊列為空返回 null
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    /**
     * 從隊列頭取出值, 不移除
     * Returns: 若隊列非空返回隊列頭值, 若隊列為空返回 null
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
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
        return (tail + 1) % array.length == head;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != tail;
            }

            @Override
            public E next() {
                E value = array[pointer];
                pointer = (pointer + 1) % array.length;
                return value;
            }
        };
    }
}
