package main.java.queue.test;

import main.java.queue.CircularArrayQueue;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * ClassName: ArrayTest
 * PackageName: main.java.queue.test
 * Description:
 *
 * @Create: 2024/10/3-下午 09:13
 */
public class ArrayTest {

    @Test
    public void test() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<Integer>(6);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5, 6), queue);

        Assertions.assertEquals(1,queue.poll());

        queue.offer(7);
        Assertions.assertIterableEquals(List.of(2, 3, 4, 5, 6,7), queue);

        Assertions.assertEquals(2,queue.peek());

    }
}
