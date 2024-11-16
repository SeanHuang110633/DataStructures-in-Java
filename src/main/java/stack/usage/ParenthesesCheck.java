package main.java.stack.usage;

import org.junit.Test;

import java.lang.invoke.VarHandle;
import java.util.LinkedList;

/**
 * ClassName: ParenthesesCheck
 * PackageName: main.java.stack.usage
 * Description: 確認expression中的括弧是否合規
 */
public class ParenthesesCheck {

    @Test
    public void test(){
        String express1 = "{[2*(a+b)]-c}*3(d+e)";
        String express2 = "{{{((([(())])))}}}";
        String express3 = "{{{(([(())])))}}}";
        boolean check1 = check(express1);
        System.out.println(check1);
        boolean check2 = check(express2);
        System.out.println(check2);
        boolean check3 = check(express3);
        System.out.println(check3);
    }

    boolean check(String str) {
        // 建立一個stack存放的{[(
        LinkedList<Character> stack = new LinkedList<>();

        // 遍歷str，如果遇到{[(，就將其對應的)]} push到stackv
        // 如果遇到)]}，先確認stack中是否有東西，沒東西代表順序錯誤，有東西就pop出來比對
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != ')'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != ']'){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '}'){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        // 遍歷結束，stack還有東西就錯誤，空了就代表沒問題
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


}
