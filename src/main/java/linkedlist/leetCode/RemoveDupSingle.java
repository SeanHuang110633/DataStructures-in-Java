package main.java.linkedlist.leetCode;

import java.util.ArrayList;


//去重
public class RemoveDupSingle {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(2, o5);
        ListNode o3 = new ListNode(2, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(2, o2);
        //System.out.println(function1(o1));
        System.out.println(function2(o1));

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



    //保留一個重複值
    static ListNode function1(ListNode head){

        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p2 != null){
            if(p1.val == p2.val){
                p1.next = p2.next;
            }else{
                p1 = p1.next;
            }
            p2 = p2.next;
        }

        return head;
    }

    //全刪:我的
    static ListNode function2(ListNode head){
        ListNode s = new ListNode(666,head);
        ListNode p1 = head;
        ListNode p2 = head.next;
        boolean count = false;
        while(p2 != null){
            if(p1.val == p2.val){
                p1.next = p2.next; //刪除p2
                p2 = p2.next;   //指針後移
                count = true;
            }else{
                if(count){
                    s = s.next;  //s後移
                    s.next = p1.next; // 刪掉p1
                    count = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s;
    }

}
