package main.java.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassName: SinglyLinkedListSentinel
 * PackageName: main.java.linkedlist
 * Description: 單向鏈表(不帶哨兵)
 *
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head = new Node(777, null); // 頭節點緊接著哨兵


    //節點類；對外暴露的東西越少越好，使用者只須要知道一個類，知道怎麼操作他的憎刪改查
    //加static代表他跟整個類相關，不是跟著類實體
    private static class Node {
        int value; //節點的值
        Node next; //指向下一個節點

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // 新增節點
    public void addFirst(int value) {
        //1.鏈表為空:直接讓head指向新結點
        //head = new Node(value, null);
        //2.鏈表非空 : 插入head和已存在的node之間;這段可以處理為空個狀況，保留這個就好
        //head = new Node(value, head);
        insertByIndex(0, value);
    }

    // 找到並返回最後節點
    private Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    // 從尾部插入節點
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);

    }

    //透過索引找到對應的節點
    private Node findIndex(int index) {
        int i = -1; // 哨兵索引值設定為-1
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

    // 根據索引插入新節點
    public void insertByIndex(int index, int value) {

        Node preNode = findIndex(index - 1);
        if (preNode == null) {
            throw new IllegalArgumentException(String.format("input index [%d] is not found", index));
        }

        preNode.next = new Node(value, preNode.next);
    }

    // 根據索引刪除節點
    public void deleteByIndex(int index) {

        Node preNode = findIndex(index-1);
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

    //遍歷

    /**
     * 創建一個pointer不斷指向下一個node,如果指到null就代表迭代完畢
     * 迭代取得元素通常都是要另外使用,利用consumer
     **/
    public void loop(Consumer<Integer> consumer) {
        Node pointer = head.next;
        while (pointer != null) {
            //System.out.println(pointer.value);
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    /**
     * 用匿名內部類，但也可以把他轉成一個實體內部類
     * 增強for循環默認使用迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head.next;

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
