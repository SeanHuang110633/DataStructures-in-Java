package main.java.sort.linear;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: Radix
 * PackageName: main.java.sort.linear
 */
public class Radix {
    @Test
    public void test(){
        String[] arr = new String[7];
        arr[0] = "158";
        arr[1] = "151";
        arr[2] = "234";
        arr[3] = "137";
        arr[4] = "157";
        arr[5] = "161";
        arr[6] = "112";

        function(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    public void function(String[] arr, int length) {
        // 準備bucket
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 逐輪將排序arr中的元素放入對應的桶中
        for (int i = length - 1; i >= 0; i--) { // 從最低位開始排

            // 元素放入對應的桶中
            for (String s : arr) {
                buckets[s.charAt(i) - '0'].add(s);
            }

            // 把放入桶中的元素依序拿出來放到原本的arr
            int pointer = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    arr[pointer] = s;
                    pointer++;
                }
                bucket.clear(); // 每次拿完都要清空桶子，後續尚須使用
            }
        }
    }
}
