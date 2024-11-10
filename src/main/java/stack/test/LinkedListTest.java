package main.java.stack.test;

import main.java.stack.implement.LinkedListStack;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * ClassName: LinkedListTest
 * PackageName: main.java.datastructure.stack.test
 * Description:
 *
 * @Create: 2024/10/3-下午 10:10
 */
public class LinkedListTest {

    @Test
    public void test_push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Assertions.assertIterableEquals(List.of(3, 2, 1), stack);
    }

    @Test
    public void test_pop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();

        Assertions.assertIterableEquals(List.of(3, 2, 1), stack);
    }

}