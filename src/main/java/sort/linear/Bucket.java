package main.java.sort.linear;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: Bucket
 * PackageName: main.java.sort.linear
 */
public class Bucket {

    @Test
    public void test() {
        int[] arr1 = {11, 12, 43, 41, 23, 20, 3, 57, 55};
        function(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public void function(int[] arr) {
        // 準備分類用的bucket (編號0 - 9)
        ArrayList buckets = new ArrayList(10);
        for (int i = 0; i < buckets.size(); i++) {
            buckets.set(i, new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            buckets.add(arr[i] / 10, arr[i]);
            // 桶內部排序
            for (int j = 0; j < buckets.size(); j++) {
                ArrayList elements =(ArrayList)buckets.get(j);
            }


        }
    }

    private void insertion(int[] arr) {
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
}
