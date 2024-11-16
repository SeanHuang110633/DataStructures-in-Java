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
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // 將元素擺放到對應的桶
        for (int value : arr) {
            int bucketIndex = value / 10;  // 取得對應的桶號
            buckets.get(bucketIndex).add(value);
        }

        // 排序桶內元素
        for(ArrayList<Integer> bucket : buckets){
            bucket.sort(Integer::compareTo);
        }

        // 合併各桶的元素到原始陣列中
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
