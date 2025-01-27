package problems.stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        System.out.println(simplifyPath("/../"));
        SimplifyPath s = new SimplifyPath();
        s.clone();
    }

    @Override
    public SimplifyPath clone() {
        return new SimplifyPath();
    }

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        for (String st : path.split("/")) {
            // System.out.println(st);
            if (st.isBlank() || st.equals(".")) {
                continue;
            } else if (!stack.isEmpty() && st.equals("..")) {
                stack.pop();
            } else {
                stack.push(st);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String st : stack) {
            sb.append("/");
            if (!st.equals("..")) {
                sb.append(st);
            }
        }

        return sb.toString();
    }
}
