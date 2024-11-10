package main.java.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: Interpolation
 * PackageName: main.java.search
 * Description: 插補搜尋法
 */
public class Interpolation {

    @Test
    public void test(){
        int[] arr = {1, 2, 5, 7, 12, 44, 55, 78};
        Assert.assertEquals(interpolation(arr, 7), 3);
        Assert.assertEquals(interpolation(arr, 55), 6);
        Assert.assertEquals(interpolation(arr, 78), 7);
        Assert.assertEquals(interpolation(arr, 1), 0);

        // 不存在數列中的會返回第一個元素(崗哨)
        Assert.assertEquals(interpolation(arr, 66), -1);
    }


    public int interpolation(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        int mid;
        int denominator;
        if (arr[low] <= target && target <= arr[high]) {
            while (low <= high && res == -1) {
                // 求出比較值
                denominator = arr[high] - arr[low];
                if (denominator == 0) {
                    mid = low; // 陣列中只有一個數字
                } else {
                    mid = low + ((target - arr[low]) * (high - low))/denominator;
                }

                // 跟二分查找差不多
                if(target == arr[mid]){
                    res = mid;
                }else if(target < arr[mid]){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }
        }
        return res;
    }
}
