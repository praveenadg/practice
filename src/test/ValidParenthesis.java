package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String args[]){
        System.out.println(isValid(")("));
    }
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }
            else if(c==')'){
                if(stack.peek()=='('){
                    stack.pop();
                } else
                    return false;
            }
            else if(c==']'){
                if(stack.peek()=='['){
                    stack.pop();
                } else
                    return false;
            }
            else if(c=='}'){
                if(stack.peek()=='{'){
                    stack.pop();
                } else
                    return false;
            }

        }
        return true;
    }

}
