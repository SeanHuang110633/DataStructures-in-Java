package main.java.recursion;

import org.junit.Test;

import java.util.Arrays;

public class Fib {
    public static void main(String[] args) {
        System.out.println(basic(5));
        System.out.println(basic_iterative(5));
//        System.out.println(memorization1(6));
//        System.out.println(memorization1(7));
//        System.out.println(memorization1(8));
//        System.out.println(memorization1(9));
//        System.out.println(memorization1(10));
    }

    private static int basic(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return basic(n - 1) + basic(n - 2);
    }


    //記憶法
    private static int memorization1(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return (memorization2(n, cache));
    }

    private static int memorization2(int n, int[] cache) {

        if (cache[n] != -1) {
            return cache[n];
        }

        int x = memorization2(n - 1, cache);
        int y = memorization2(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

    private static int basic_iterative(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int a = 0, b = 1, c=0;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }


    public void fib_iteration(){
        int[] arr = new int[100];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            if(arr[i] >= 1000 ){
                break;
            }
        }

        int j=0;
        while(arr[j] <= 1000){
            System.out.print(arr[j] + ", ");
            j++;
        }
    }

    @Test
    public void test(){
        fib_iteration();
    }
}
