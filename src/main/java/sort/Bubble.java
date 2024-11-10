package main.java.sort;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: Bubble
 * PackageName: main.java.sort
 */
public class Bubble {

    void basic(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void test_basic() {
        int[] arr = {17, 14, 16, 1, 3, 4, 188, 29};

        basic(arr);

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 3, 4, 14, 16, 17, 29, 188), arrList);
    }

    // 每次將邊界
    void optimize(int[] arr) {
        int rightBound = arr.length - 1;
        while (true) {
            int x = 0;  // 紀錄每次交換後沒有完成排序的右邊界
            for (int j = 0; j < rightBound; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    x = j; // 代表j+1已經排好了，0-j還沒，所以右邊界是j
                }
            }
            rightBound = x; // 更換右邊界的值
            if (rightBound == 0) {
                break;
            }
        }
    }

    @Test
    public void test_optimize() {
        int[] arr = {1,2,3,7,6,5};

        optimize(arr);

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 2, 3, 5, 6, 7), arrList);
    }

    // 如果已經排序好就不用浪費時間了
    void flag(int[] arr) {
        for (int right = arr.length - 1; right > 0 ; right --) {
            boolean flag = false; // 如果發生交換則改為true
            for (int j = 0; j < right; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                break;
            }
        }
    }

    @Test
    public void test_flag() {
        int[] arr = {1,2,3,4,5,6};

        flag(arr);

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1,2,3,4,5,6), arrList);
    }


    void recursive(int[] arr, int rightBound) {

        if (rightBound == 0) {
            return;
        }

        int x = 0;  // 紀錄每次交換後沒有完成排序的右邊界()
        for (int j = 0; j < rightBound; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                x = j; // 代表j+1已經排好了，0-j還沒，所以右邊界是j
            }
        }

        recursive(arr, x);
    }

    @Test
    public void test_recursive() {
        int[] arr = {17, 14, 16, 1, 3, 4, 188, 29};
        recursive(arr, arr.length - 1);
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 3, 4, 14, 16, 17, 29, 188), arrList);
    }
}
