package main.java.stack.implement;

/**
 * ClassName: myStack
 * PackageName: main.java.datastructure.stack
 * Description: 搭個架子
 *
 */
public interface myStack<E> {

    boolean push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();
}
