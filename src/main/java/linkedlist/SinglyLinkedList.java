package main.java.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName: SingleLinledList
 * PackageName: main.java.datastructure.list
 * Description: 單向鏈表(不帶哨兵)
 */
public class SinglyLinkedList implements Iterable<Integer> {

    private Node head = null; // 頭節點


    // 類與類之間如果是組合關係，可以設計成內部類和外部類
    // 節點類；對外暴露的東西越少越好，使用者只須要知道一個類，知道怎麼操作他的增刪改查
    // 加static代表他跟整個類相關，不是跟著類實體，如果內部類裡面要用到外部類的屬性，那就不能加static
    private static class Node {
        int value; //節點的值
        Node next; //指向下一個節點

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //增
    public void addFirst(int value) {
        //1.鏈表為空:直接讓head指向新結點
        //head = new Node(value, null);
        //2.鏈表非空 : 插入head和已存在的node之間;這段可以處理為空個狀況，保留這個就好
        head = new Node(value, head); // head is null
    }

    private Node findLast() {
        Node p = head;
        if (p == null) {
            return null;
        }
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
        } else {
            last.next = new Node(value, null);
        }
    }

    //透過索引找到對應的值
    private Node findIndex(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int getByIndex(int index) {
        Node node = findIndex(index);
        if (node == null) {
            throw new IllegalArgumentException(String.format("input index [%d] is not found", index));
        } else {
            return node.value;
        }
    }

    public void insertByIndex(int index, int value) {
        if (index == 0) {
            addFirst(value);
        }
        Node preNode = findIndex(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException(String.format("input index [%d] is not found", index));
        }
        //Node postNode = findIndex(index);
        //preNode.next = new Node(value, postNode);
        preNode.next = new Node(value, preNode.next);
    }

    public void deleteByIndex(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node preNode = findIndex(index - 1);
            if (preNode == null) {
                //可能輸入一個不存在的索引
                throw new IllegalArgumentException(String.format("input index [%d] is illegal", index));
            }
            Node remove = preNode.next;
            if (remove == null) {
                throw new IllegalArgumentException(String.format("input index [%d] is not found", index));
            }
            preNode.next = remove.next;
        }

    }

    //遍歷

    /**
     * 創建一個pointer不斷指向下一個node,如果指到null就代表迭代完畢
     * 迭代取得元素通常都是要另外使用,利用consumer
     **/
    public void loop(Consumer<Integer> consumer) {
        Node pointer = head;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    public void loop2(Consumer before, Consumer after) {
        recursion(head,before,after);
    }

    public void recursion(Node curr,Consumer before, Consumer after) {
        if (curr == null) {
            return;
        }
        before.accept(curr.value);
        recursion(curr.next,before,after);
        after.accept(curr.value);
    }


    /**
     * 這是一個匿名內部類，可以把他轉成一個實體內部類
     * 增強for循環默認使用迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public Integer next() {
                int v = pointer.value;
                pointer = pointer.next;
                return v;
            }
        };
    }
}
