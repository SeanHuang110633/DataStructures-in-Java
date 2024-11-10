package main.java.queue.test;

import main.java.queue.CircularLinkedListQueue;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * ClassName: BasicTest
 * PackageName: main.java.queue.test
 * Description:
 *
 * @Create: 2024/10/3-下午 08:05
 */
public class LinkedListTest {

    @Test
    public void test_offer() {
        CircularLinkedListQueue<Integer> queue = new CircularLinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5), queue);
    }

    @Test
    public void test_peak() {
        CircularLinkedListQueue<Integer> queue = new CircularLinkedListQueue<>();
        queue.offer(1);
        assertEquals(1, queue.peek());
        queue.offer(3);
        assertEquals(1, queue.peek());
    }

    @Test
    public void test_poll() {
        CircularLinkedListQueue<Integer> queue = new CircularLinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
        assertEquals(5, queue.poll());
        assertNull(queue.poll());
    }

    @Test
    public void test_full() {
        CircularLinkedListQueue<Integer> queue = new CircularLinkedListQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        Assertions.assertIterableEquals(List.of(1,2,3),queue);
    }
}
