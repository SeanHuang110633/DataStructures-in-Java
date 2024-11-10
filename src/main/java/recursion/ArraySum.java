package main.java.recursion;

import org.junit.Test;

/**
 *  陣列求和
 */
public class ArraySum {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4};
        System.out.println(sum(arr, arr.length - 1));
    }

    int sum(int[] arr, int n) {
        if (n < 0) {
            return 0;
        }

        return arr[n] + sum(arr, n - 1);
    }
}
