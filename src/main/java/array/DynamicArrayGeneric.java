package main.java.array;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName: DynamicArrayGeneric
 * PackageName: main.java.array
 * Description: 使用泛型接收
 *
 */
public class DynamicArrayGeneric<T> implements Iterable<T>{
    private int size = 0;
    private int capacity = 8;
    private Object[] array = new Object[capacity];

    public DynamicArrayGeneric() {
        this.size = 0;
    }

    public DynamicArrayGeneric(int size) {
        this.size = size;
        this.capacity = Math.max(size, capacity);
        this.array = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public T getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    public void setElement(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    public void insertLast(T element) {
        insert(size, element);
    }

    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        checkExpand();
        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkExpand() {
        if (size == capacity) {
            capacity += capacity >> 1;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removed = (T) array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        array[--size] = null; // Clear to let GC do its work
        return removed;
    }

    public void myForEach(Consumer<? super T> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(getElement(i));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public T next() {
                return getElement(i++);
            }
        };
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
