package main.java.stack.test;

import main.java.stack.implement.ArrayStack;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * ClassName: ArrayStackTest
 * PackageName: main.java.datastructure.stack.test
 * Description:
 *
 * @Create: 2024/10/4-下午 04:43
 */
public class ArrayStackTest {

    @Test
    public void test_push() {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Assertions.assertIterableEquals(List.of(3, 2, 1), stack);
    }

    @Test
    public void test_pop() {
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assertions.assertEquals(4,stack.pop());
        Assertions.assertEquals(3,stack.pop());
        Assertions.assertEquals(2,stack.pop());
        Assertions.assertEquals(1,stack.pop());
        Assertions.assertNull(stack.pop());
    }
}
