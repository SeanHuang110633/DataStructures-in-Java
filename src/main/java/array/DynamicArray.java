package main.java.array;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName: DynamicArray
 * PackageName: main.java.array
 * Description: 實現動態array
 */
public class DynamicArray implements Iterable<Integer> {

    // 數組元素個數(從0開始所以相當於索引)
    private int size = 0;

    // 數組可以容納的最大元素量
    private int capacity = 8;

    // 儲存的元素 (用懶加載)
    private int[] array = {};

    public DynamicArray() {
        this.size = 0;
    }

    public DynamicArray(int size) {
        this.size = size;
    }

    // get by index
    public int getElement(int index) {
        return array[index];
    }

    // set by index
    public void setElement(int index, int element) {
        array[index] = element;
    }


    public void insertLast(int element) {
        insert(size, element);
    }


    // insert by index
    public void insert(int index, int element) {
        // 檢查是否擴容
        check_expand();

        if (index >= 0 && index < size) {
            // 先將插入後面的索引複製並往後挪
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;
    }

    // expand the array
    private void check_expand() {
        if (this.size == 0) {
            this.array = new int[capacity];
        }

        if (this.size == capacity) {
            System.out.println("需要擴容");
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    // remove by index
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        int removed = array[index];
        if (index < size - 1) {
            // 將後面的元素往前挪
            System.arraycopy(array, index + 1, array, index, size - index - 1);

        }

        array[size - 1] = 0; // 將最後一個元素設置為0
        size--;
        return removed;
    }

    // 遍歷1
    public void myForEach(Consumer<Integer> consumer) {
        // 思考這個方法可以提供甚麼(這邊就是array中的元素)，再決定接口函數的類型，這邊就用consumer
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    // 遍歷2
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                int res = array[i];
                i++;
                return res;
            }
        };
    }
}
