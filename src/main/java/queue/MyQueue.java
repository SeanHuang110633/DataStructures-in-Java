package main.java.queue;

/**
 * ClassName: MyQueue
 * PackageName: main.java.queue
 * Description:
 *
 * @Create: 2024/10/3-下午 05:24
 */
public interface MyQueue<E> {

        /**
         * 向尾插入值
         * Params: value - 待插入值
         * Returns: 插入成功返回 true, 插入失敗返回 false
         */
        boolean offer(E value);

        /**
         * 從頭取出值, 並移除
         * Returns: 若隊列非空返回隊列頭值, 若隊列為空返回 null
         */
        E poll();

        /**
         * 從頭取出值, 不移除
         * Returns: 若隊列非空返回隊列頭值, 若隊列為空返回 null
         */
        E peek();

        /**
         * 檢查是否為空
         * Returns: 為空返回 true, 不為空返回 false
         */
        boolean isEmpty();

        /**
         * 檢查是否已滿
         * Returns: 滿返回 true, 不滿返回 false
         */
        boolean isFull();
}
