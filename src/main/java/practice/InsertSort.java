package main.java.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: InsertSort
 * PackageName: main.java.prac
 * Description:
 *
 * @Create: 2024/11/2-下午 02:45
 */
public class InsertSort {

    @Test
    public void test() {
        int[] arr = {4, 5, 9, 1, 77, 22, 55, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr){
        insertion(arr,1);
    }

    void insertion(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }

        int target = arr[low];
        int sortedPointer = low - 1;
        while (sortedPointer >= 0 && target < arr[sortedPointer]) {
            arr[sortedPointer + 1] = arr[sortedPointer];
            sortedPointer--;
        }
        arr[sortedPointer + 1] = target;
        insertion(arr, low + 1);
    }
}
