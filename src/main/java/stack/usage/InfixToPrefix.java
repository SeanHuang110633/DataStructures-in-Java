package main.java.stack.usage;

import java.util.LinkedList;

/**
 * ClassName: InfixToPrefix
 * PackageName: main.java.datastructure.stack
 * Description:
 *
 * @Create: 2024/10/4-下午 02:34
 */
public class InfixToPrefix {
    public static void main(String[] args) {
        String[] expressions = {
                "a+b",
                "a+b-c",
                "a*b+c",
                "a+b*c",
                "a+b*c-d",
                "(a+b)*c",
                "(a+b*c-d)*e",
                "a*(b+c)"
        };

        for (String exp : expressions) {
            System.out.println("Infix: " + exp);
            System.out.println("Prefix: " + infixToPrefix(exp));
            System.out.println();
        }
    }

    static String infixToPrefix(String exp) {
        // 1. 反轉表達式，並將括號反向
        StringBuilder reversedExp = new StringBuilder(exp).reverse();
        for (int i = 0; i < reversedExp.length(); i++) {
            if (reversedExp.charAt(i) == '(') {
                reversedExp.setCharAt(i, ')');
            } else if (reversedExp.charAt(i) == ')') {
                reversedExp.setCharAt(i, '(');
            }
        }

        // 2. 使用類似 infixToPostfix 的邏輯處理反轉後的表達式
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder(reversedExp.length());

        for (int i = 0; i < reversedExp.length(); i++) {
            char c = reversedExp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    while (!stack.isEmpty() && getPriority(stack.peek()) > getPriority(c)) {
                        res.append(stack.pop());
                    }
                    stack.push(c);
                }
                case '(' -> stack.push(c);
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        res.append(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                }
                default -> res.append(c);
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        // 3. 再次反轉結果得到 prefix 表達式
        return res.reverse().toString();
    }

    static int getPriority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("Invalid operator: " + c);
        };
    }
}
