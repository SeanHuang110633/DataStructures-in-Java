package main.java.search.linearsearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: Sential
 * PackageName: main.java.search.linearsearch
 * Description: 使用崗哨 (比不用崗哨少一次判斷)
 */
public class Sential {

    @Test
    public void test(){
        int[] arr = {1, 2, 5, 7, 99, 12, 44, 55, 78};
        Assert.assertEquals(linear_search(arr, 99), 4);
        Assert.assertEquals(linear_search(arr, 7), 3);
        Assert.assertEquals(linear_search(arr, 55), 7);
        Assert.assertEquals(linear_search(arr, 78), 8);
        Assert.assertEquals(linear_search(arr, 1), 0);

        // 不存在數列中的會返回第一個元素(崗哨)
        Assert.assertEquals(linear_search(arr, 66), 0);
    }

    public int linear_search(int[] arr, int target) {
        // 直接把第一個元素設定為欲找尋的目標值
        arr[0] = target;
        // 從最後元素開始往前找
        int index = arr.length - 1;
        while (index > 0 && arr[index] != target) {
            // 沒找到就繼續往陣列起始位置找,找到就退出循環，或是到index=0時還沒找到那就返回0
            index--;
        }
        return index;
    }
}
