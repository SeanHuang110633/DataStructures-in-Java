package main.java.array.test;

import main.java.array.DynamicArrayGeneric;
import org.junit.Test;

/**
 * ClassName: TestDynamicArrayGeneric
 * PackageName: main.java.array
 * Description:
 *
 * @Create: 2024/10/1-下午 07:46
 */
public class TestDynamicArrayGeneric {
    @Test
    public void test(){
        DynamicArrayGeneric<Integer> integers = new DynamicArrayGeneric<>();
        integers.insertLast(1);
        integers.insertLast(2);
        integers.insertLast(3);
        integers.insertLast(4);
        integers.myForEach(integer -> System.out.println(integer));
        DynamicArrayGeneric<String> strings = new DynamicArrayGeneric<>();
    }

}
