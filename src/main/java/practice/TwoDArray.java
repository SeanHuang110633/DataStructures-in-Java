package main.java.practice;

import org.junit.Test;

/**
 * ClassName: TwoDArray
 * PackageName: main.java.prac
 * Description:
 *
 * @Create: 2024/11/2-下午 01:27
 */
public class TwoDArray {
    @Test
    public void test() {
        int[][] arr = {{1, 1, 0, 0, 0, 1}, {1, 0, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 1, 0, 1, 1}};
        String[] name = {"Bob", "AAA", "BBB", "CCC"};
        System.out.println(func(arr,name));
    }

    String func(int[][] arr, String[] nameList) {
        int max = 0;
        String res = null;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[i].length; j++) {
                count += arr[i][j];
            }
            if (count > max) {
                max = count;
                res = nameList[i];
            }
        }
        return res;
    }
}
