package main.java.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Selection
 * PackageName: main.java.prac
 * Description:
 *
 * @Create: 2024/11/5-下午 08:56
 */
public class SelectionSort {

    @Test
    public void test() {
        int[] arr = {4, 5, 9, 1, 77, 22, 55, 3};
        function(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    void function(int[] arr, int low) {
        if(low <= 0){
            return;
        }

        int max = low;

        for (int i = 0; i < low; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        swap(arr, max, low);
        function(arr, low - 1);
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
