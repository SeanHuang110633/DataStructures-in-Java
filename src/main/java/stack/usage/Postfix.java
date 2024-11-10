package main.java.stack.usage;

import java.util.LinkedList;

/**
 * ClassName: Postfix
 * PackageName: main.java.datastructure.stack
 * Description:
 *
 * @Create: 2024/10/4-下午 01:30
 */
public class Postfix {

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1" ,"+" , "3" , "*"};
        String[] tokens2 = {"4", "13" , "5" , "/" , "+"};
        System.out.println(postfix_method(tokens1));
        System.out.println(postfix_method(tokens2));
    }


    static int postfix_method(String[] tokens) {
        // 1. 遍歷tokens並用stack儲存非運算子的元素
        // 2. 遇到運算子就彈出前兩個進行運算並push到stack中
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String charactor = tokens[i];
            switch (charactor) {
                case "+" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                }
                default -> {
                    stack.push(Integer.parseInt(charactor));
                }
            }
        }
        // 3. 直到結束把最後還在stack中的就是答案
        return stack.peek();

    }
}
