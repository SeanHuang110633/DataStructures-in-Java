package main.java.sort.linear;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Count
 * PackageName: main.java.sort.linear
 */
public class Count {

    @Test
    public void test() {
        int[] arr1 = {1, 1, 4, 4, 2, 0, 3, 3, 5};
        function1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {-1, -2, 4, 4, 2, 0, 3, 3, 5};
        function2(arr2);
        System.out.println(Arrays.toString(arr2));
    }


    void function1(int[] arr) {
        // 找到傳入陣列中的最大值，並創建大小為最大值+1的count陣列
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        int[] count = new int[arr[max] + 1];

        // count陣列的索引對應到原陣列的元素值，並統計該元素出現的次數
        for (int element : arr) {
            count[element]++;
        }

        // 遍歷count陣列，並將結果存入原陣列，完成排序後的
        int originArrPointer = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[originArrPointer] = i;
                originArrPointer++; // 原陣列指針往前
                count[i]--;
            }
        }
    }

    // 考慮 arr 中有負數的狀況
    void function2(int[] arr) {
        // 找到傳入陣列中的最大值、最小值，並創建一個大小為{最大值 - 最小值 + 1}的count陣列
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        int[] count = new int[arr[max] - arr[min] + 1];

        // count陣列的索引對應到原陣列的元素值，並統計該元素出現的次數
        for (int element : arr) {
            count[element - arr[min]]++; // 減去最小值才會是正確索引
        }

        // 遍歷count陣列，並將結果存入原陣列，完成排序後的
        int originArrPointer = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[originArrPointer] = i + arr[min];
                originArrPointer++; // 原陣列指針往前
                count[i]--;
            }
        }
    }
}
