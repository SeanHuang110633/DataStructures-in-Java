package main.java.linkedlist.reverse;

import org.junit.Test;

/**
 * ClassName: myTest
 * PackageName: main.java.linkedlist.reverse
 * Description:
 *
 * @Create: 2024/10/3-下午 02:53
 */
public class Solution {


    @Test
    public void test1_simple() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(node1);
        ListNode node = solution_1(node1);
        System.out.println(node);
    }

    @Test
    public void test2_recursive() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(node1);
        ListNode node = recursive(node1);
        System.out.println(node);

    }

    @Test
    public void test3_FOP() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(node1);
        ListNode node = solution_3(node1);
        System.out.println(node);

    }

    @Test
    public void test4_OOP() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(node1);

        ListNode node = solution_4(node1);
        System.out.println(node);

    }



    // 最簡單
    public ListNode solution_1(ListNode head) {
        ListNode pointer = head;
        ListNode newHead = null;
        while (pointer != null) {
            newHead = new ListNode(pointer.val, newHead);
            //ListNode node = new ListNode(pointer.val, newHead);
            pointer = pointer.next;
            //newHead = node;
        }
        return newHead;
    }


    public ListNode recursive(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ListNode last = recursive(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    // 錯的 結果是[1]，實際上是有反轉但回傳的是最後一個值[1]
    public ListNode recursive2(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ListNode last = recursive2(node.next);
        last.next = node;
        node.next = null;
        return node;
    }

    // 雙指針
    public ListNode solution_3(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode oldHead = node;
        while (oldHead != null) {
            ListNode oldHeadNext = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = oldHeadNext;
        }
        return newHead;
    }

    //OOP解法
    public ListNode solution_4(ListNode node) {
        List list = new List(node);
        List list2 = new List(null);
        while (true) {
            ListNode first = list.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

}

//OOP解法
class List {
    ListNode head;

    public List(ListNode head) {
        this.head = head;
    }

    // 把舊鏈表的第一個節點拔掉
    public ListNode removeFirst() {
        ListNode firstNode = head;
        if (firstNode == null) {
            return firstNode;
        }
        this.head = firstNode.next;
        return firstNode;
    }

    // 插在新鏈表的頭
    public void addFirst(ListNode node) {
        node.next = head;
        this.head = node;
    }

}