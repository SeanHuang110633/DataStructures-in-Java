package main.java.sort;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: Selection
 * PackageName: main.java.sort
 * Description: 選擇排序
 */
public class Selection {
    @Test
    public void test1() {
        int[] arr = {3, 55, 1, 2, 6, 4, 77, 9, 5};
        function(arr);

        // 將 arr 轉換為 List<Integer>
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 9, 55, 77), arrList);
    }

    void function(int[] arr) {
        for (int right = arr.length - 1; right > 0; right--) {
            int max = right;
            for (int i = 0; i < right; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            int temp = arr[max];
            arr[max] = arr[right];
            arr[right] = temp;
        }
    }

}
