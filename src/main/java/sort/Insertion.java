package main.java.sort;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: Insertion
 * PackageName: main.java.sort
 * Description: 插入排序
 */
public class Insertion {

    // iteration寫法
    void iteration(int[] arr) {
        for (int low = 1; low < arr.length; low++) {
            int target = arr[low];
            int sortedPointer = low - 1;
            while (sortedPointer >= 0 && target < arr[sortedPointer]) {
                arr[sortedPointer + 1] = arr[sortedPointer];
                sortedPointer --;
            }
            arr[sortedPointer + 1] = target;
        }
    }

    @Test
    public void test1() {
        int[] arr = {3, 55, 1, 2, 6, 4, 77, 9, 5};
        iteration(arr);

        // 將 arr 轉換為 List<Integer>
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 9, 55, 77), arrList);
    }

    // 遞迴寫法
    public void recursion(int[] arr, int low) {
        if (low == arr.length) { // 為何不是arr.length-1 ? 因為arr.length-1也要比較
            return;
        }

        int target = arr[low]; // 未排序區域的最左值
        int sortedPointer = low - 1; // 已排序區域的指針

        while (sortedPointer >= 0 && target < arr[sortedPointer]) {  // 如target值小於已排序區域的值 且 已排序區域的指針還在有效範圍內
            arr[sortedPointer + 1] = arr[sortedPointer]; // 比target大的值要向右移動將位置空出來
            sortedPointer--;
        }

        // 找到比target小的值
        arr[sortedPointer + 1] = target;

        // 完成一輪比較,相同邏輯遞迴執行下一輪
        recursion(arr, low + 1);
    }

    @Test
    public void test2() {
        int[] arr = {3, 55, 1, 2, 6, 4, 77, 9, 5};
        recursion(arr, 1);

        // 將 arr 轉換為 List<Integer>
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 9, 55, 77), arrList);
    }


    // 另種寫法
    // 1. 進行實際的插入
    public void insert(int[] arr, int key, int sortedPointer) {
        while (sortedPointer >= 0 && key < arr[sortedPointer]) {
            arr[sortedPointer + 1] = arr[sortedPointer];
            sortedPointer--;
        }

        arr[sortedPointer + 1] = key;
    }

    // 2. 控制從第二筆資料開始進行排序直到n-1次
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insert(arr, arr[i], i - 1);
        }
    }

    @Test
    public void test3() {
        int[] arr = {3, 55, 1, 2, 6, 4, 77, 9, 5};
        sort(arr);

        // 將 arr 轉換為 List<Integer>
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 9, 55, 77), arrList);
    }

}
