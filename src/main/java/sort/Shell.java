package main.java.sort;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: Shell
 * PackageName: main.java.sort
 * Description: Insert的變形
 */
public class Shell {

    void function(int[] arr) {
        for (int gap = arr.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < arr.length; low++) {
                int target = arr[low];
                int sortedPointer = low - gap;
                while (sortedPointer >= 0 && target < arr[sortedPointer]) {
                    arr[sortedPointer + gap] = arr[sortedPointer];
                    sortedPointer -= gap;
                }
                arr[sortedPointer + gap] = target;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {3, 55, 1, 2, 6};
        function(arr);

        for (int i : arr) {
            System.out.print(i + ", ");
        }
        // 將 arr 轉換為 List<Integer>
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 2, 3, 6, 55), arrList);
    }
}
