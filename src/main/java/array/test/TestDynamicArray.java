package main.java.array.test;

import main.java.array.DynamicArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: TestDynamicArray
 * PackageName: main.java.array
 * Description:
 *
 * @Create: 2024/10/1-下午 02:59
 */
public class TestDynamicArray {
    @Test
    public void test_insert(){
        DynamicArray array = new DynamicArray();
        array.insertLast(10);
        array.insertLast(12);
        array.insertLast(13);
        array.insert(1,11);
        Assert.assertEquals(array.getElement(0),10);
        Assert.assertEquals(array.getElement(1),11);
        Assert.assertEquals(array.getElement(2),12);
        Assert.assertEquals(array.getElement(3),13);


    }

    @Test
    public void test_forEach(){
        DynamicArray array = new DynamicArray();
        array.insertLast(10);
        array.insertLast(12);
        array.insertLast(13);
        array.insert(1,11);
        array.myForEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_forEach_iterator(){
        DynamicArray array = new DynamicArray();
        array.insertLast(10);
        array.insertLast(12);
        array.insertLast(13);
        array.insert(1,11);
        for(Integer element : array){
            System.out.println(element);
        }
    }


    @Test
    public void test_remove(){
        DynamicArray array = new DynamicArray();
        array.insertLast(10);
        array.insertLast(12);
        array.insertLast(13);
        array.insert(1,11);
        int remove2 = array.remove(2);
        for (int e : array){
            System.out.println(e);
        }
        System.out.println(array.getElement(2));
    }


    @Test
    public void test_expand(){
        DynamicArray array = new DynamicArray();
        array.insertLast(10);
        array.insertLast(12);
        array.insertLast(13);
        array.insert(1,11);
        array.insertLast(13);
        array.insertLast(13);
        array.insertLast(13);
        array.insertLast(13);
        array.insertLast(13);
        array.myForEach(integer -> System.out.println(integer));
    }

}
