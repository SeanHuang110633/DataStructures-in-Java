package main.java.stack.implement;

/**
 * ClassName: myStack
 * PackageName: main.java.datastructure.stack
 * Description:
 *
 * @Create: 2024/10/3-下午 09:58
 */
public interface myStack<E> {

    boolean push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();
}
