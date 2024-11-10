package main.java.linkedlist.leetCode;

import java.util.ArrayList;

public class RemoveByValue {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(removeByVal(o1,2));
    }

    //靜態內部類
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            ArrayList<Integer> nodeVal = new ArrayList<>();
            ListNode currentNode = this;

            while (currentNode != null) {
                nodeVal.add(currentNode.val);
                currentNode = currentNode.next;
            }

            return nodeVal.toString();
        }
    }


    public static ListNode removeByVal(ListNode head, int removeVal) {

        // 处理头节点是目标值的情况
        while (head != null && head.val == removeVal) {
            head = head.next;
        }

        // 用 current 遍历链表, pre 记录当前节点的前一个节点
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            if (current.val == removeVal) {
                if (pre != null) {
                    pre.next = current.next; // 刪除 current 節點
                }
            } else {
                pre = current; // 更新 pre 位置
            }
            current = current.next; // 移动到下一个节点
        }

        return head; // 返回新的头节点
    }
}
