package main.java.stack.usage;

import java.util.LinkedList;

/**
 * ClassName: InfixToPostFix
 * PackageName: main.java.datastructure.stack
 * Description:
 *
 * @Create: 2024/10/4-下午 01:46
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        String a = "a+b";
        String b = "a+b-c";
        String c = "a*b+c";
        String d = "a+b*c";
        String e = "a+b*c-d";
        String f = "(a+b)*c";
        String g = "(a+b*c-d)*e";
        String h = "a*(b+c)";

        System.out.println(infixToPostfix_method(a));
        System.out.println(infixToPostfix_method(b));
        System.out.println(infixToPostfix_method(c));
        System.out.println(infixToPostfix_method(d));
        System.out.println(infixToPostfix_method(e));
        System.out.println(infixToPostfix_method(f));
        System.out.println(infixToPostfix_method(g));
        System.out.println(infixToPostfix_method(h));
    };

    static String infixToPostfix_method(String exp) {
        /**
         * 1.建立一個StringBuffer儲存轉換後的結果,一個stack用來控制順序
         * 2.如果遇到數字就直接拼接
         * 3.遇到運算子就比較優先級，比stack中大的就push進去，比stack中小或相等就要全數彈出
         * 4.如果遇到 ( 就直接入stack，優先級低
         * 5.遇到 )就彈出到 ( 為止的所有運算子
         * 6.最後要把stack所有剩餘的彈出來拚到StringBuffer
         */
        LinkedList<Character> stack = new LinkedList<>();
        StringBuffer res = new StringBuffer(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (getPriority(c) > getPriority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                                res.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (stack.peek() !='('){
                        res.append(stack.pop());
                    }
                    // 比'('彈出扔掉
                    stack.pop();
                }
                default -> {
                    res.append(c);
                }
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }


    // 判斷優先級方法
    static int getPriority(char c) {
        switch (c) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '(' -> {
                return 0;
            }
            default -> throw new IllegalArgumentException("Invalid");
        }
    }
}
