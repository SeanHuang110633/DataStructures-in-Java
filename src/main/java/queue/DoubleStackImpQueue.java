package main.java.queue;

import main.java.stack.implement.ArrayStack;

/**
 * ClassName: DoubleStack
 * PackageName: main.java.queue
 * Description: 兩個 ArrayStack模擬 queue，ArrayStack是自己寫的 (leetCode題)
 *
 */
public class DoubleStackImpQueue {

    ArrayStack<Integer> s1 = new ArrayStack<>(100); // 頭部
    ArrayStack<Integer> s2 = new ArrayStack<>(100); // 尾巴


    public void push(int val) {
        s2.push(val);
    }


    public int pop() {
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }



    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    };


}
