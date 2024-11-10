package main.java.recursion;

import java.util.LinkedList;

public class HanoiTower1 {
    public static void main(String[] args) {
        init(3);
        print();
        move(3,x,y,z);
    }

    static LinkedList<Integer> x = new LinkedList<>();
    static LinkedList<Integer> y = new LinkedList<>();
    static LinkedList<Integer> z = new LinkedList<>();

    /**
     *
     * @param n  盤子個數
     * @param a  來源
     * @param b  借道
     * @param c  目標
     */
    public static void move(int n,
                            LinkedList<Integer> a,
                            LinkedList<Integer> b,
                            LinkedList<Integer> c){

        if(n == 0){
              return;
        }
        move(n-1,a,c,b);            //a --> b  by  c
        c.addLast(a.removeLast());  //只移動一次的情況 a -> c
        print();                   // 盤子真正發生變化的地方
        move(n-1,b,a,c);       // b-->c  by  a
    }

    public static void init(int n){
        for (int i = n; i >=1 ; i--) {
            x.addLast(i);
        }
    }

    public static void print(){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println("=================================");
    }
}
