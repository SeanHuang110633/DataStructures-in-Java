package main.java.recursion;

import org.junit.Test;

/**
 * ClassName: Sum
 * PackageName: main.java.recursion
 * Description:
 *
 * @Create: 2024/11/6-下午 02:45
 */
public class Sum {

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
