package companies.yahoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator {
    /*
     * Click `Run` to execute the snippet below!
     */


    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     * [1, [2, 3], 4] -> 1, 2 , 3
     * [1, [3, [4, 2]], 1]
     */

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        List<NestedInteger> nestedList;
        List<Integer> list = new ArrayList<>();
        int pointer = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            flattenList(nestedList);
            buildStack(nestedList);
        }

        private void flattenList(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    flattenList(nestedInteger.getList());
                }
            }
        }

        Stack<NestedInteger> stack = new Stack<>();

        private void buildStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i > 0; i--) {
                stack.push(nestedList.get(i));
            }
        }


//[1, [[4,2], 3], 5]
// stack
// [4, 2]
// 3
// 5

        // 2
// [3,4]
// 5
        @Override
        public Integer next() {
            if (!stack.isEmpty()) {
                NestedInteger nestedInteger = stack.pop();
                if (nestedInteger.isInteger()) {
                    return nestedInteger.getInteger();
                } else {
                    buildStack(nestedInteger.getList());
                    NestedInteger innerNestedInteger = stack.peek();
                    while (!innerNestedInteger.isInteger()) {

                    }

                    return stack.pop().getInteger();
                }
            }
            return list.get(pointer++);
        }


        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
            // return pointer<list.size();
        }
    }


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
