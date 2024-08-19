package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static  String decodeString(String s) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i)==']'){
                List<Character> list = new ArrayList();
                while(stack.peek()!='['){
                    list.add(stack.pop());
                }
                stack.pop();//pop the [
                int num = stack.pop()-'0';// pop the number
                while(num!=0){
                    for(int j=list.size()-1;j>=0; j--){
                        stack.push(list.get(j));
                    }
                    num--;
                }

            } else {
                stack.push(s.charAt(i));
            }
        }
        for (int i =0; i<stack.size(); i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}
