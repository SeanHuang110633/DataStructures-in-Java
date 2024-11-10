package main.java.search.linearsearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: nonSential
 * PackageName: main.java.search.linearsearch
 * Description: 不帶崗哨的
 */
public class NonSential {

    @Test
    public void test() {
        int[] arr = {1, 2, 5, 7, 99, 12, 44, 55, 78};
        Assert.assertEquals(linear_search(arr, 99), 4);
        Assert.assertEquals(linear_search(arr, 7), 3);
        Assert.assertEquals(linear_search(arr, 55), 7);
        Assert.assertEquals(linear_search(arr, 78), 8);
    }

    public int linear_search(int[] arr, int target) {
        int pointer = 0;
        while (pointer < arr.length) {
            if (arr[pointer] == target) {
                return pointer; // 返回索引值
            }
            pointer++;
        }
        return -1; // 代表沒找到
    }
}
