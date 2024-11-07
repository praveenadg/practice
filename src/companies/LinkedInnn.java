package companies;
import java.util.List;
import java.util.PriorityQueue;

public class LinkedInnn {

        public static void main(String[] args){
            //Prints "Hello, World" to the terminal
            System.out.println("Hello, World");
            System.out.println(getNthLargestElement(List.of(1,2,3,4,5), 3));
        }

        private static int getNthLargestElement(List<Integer> list, int n){
            if(list==null || list.size()==0)
                return 0;
            if(n==list.size())
                return list.get(0);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            //for(Integer i : list){
            for(int i=1; i<list.size(); i++){
                if(list.get(i)!=list.get(i-1)){
                    pq.add(i);
                    if(pq.size()>n){
                        pq.poll();
                    }
                }

            }
            return pq.poll();
        }






// Write a function that, given a List returns the Nth largest element in that List

// Please implement the function reverseDepthSum


    /**
     * Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed level #.
     * For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
     * Given the list {1,{4,{6,2}}} the function should return 19 (1 with weight 3, 4 with weight 2, 6 with weight 1, 2 with weight 1)
     *
     * It is the "reverse depth" of the item in the list: eg for the above item { 1, {4, { 6, 2 } } }
     *
     *  1 (reverse-depth 3) . = 1 * 3 = 3
     *   \
     *   { 4 } (reverse-depth 2) = 4 * 2 = 8
     *      \
     *      { 6, 2 } (reverse-depth 1) = 6 * 1 + 2 * 1 = 8
     *
     *                                  = 3 + 8 + 8 = 19
     */

    int maxDepth;
    public int reverseDepthSum (List<NestedInteger> input)
    {
        maxDepth=calculateDepth(input);
        return calculateSum(input, 0);


    }
    private int calculateDepth(List<NestedInteger> input){
        int depth=1;
        for(NestedInteger nest : input){
            if(!nest.isInteger() && nest.getList().size()!=0){
                depth=Math.max(depth, 1+calculateDepth(nest.getList()));
            }
        }
        return depth;
    }
    //{{1,1},2,{1,1}}
    private int calculateSum(List<NestedInteger> input, int depth){
        int sum=0;
        for(NestedInteger nest : input){
            if(!nest.isInteger()){
                sum=sum+calculateSum(nest.getList(), maxDepth-depth);
            } else {
                sum=sum+nest.getInteger()*(maxDepth-depth);
            }
        }
        return sum;
    }

    /**
     * This is the interface that represents nested lists.
     * You should not implement it, or speculate about its implementation.
     */
    public interface NestedInteger
    {
        /** @return true if this NestedInteger holds a single integer, rather than a nested list */
        boolean isInteger();

        /** @return the single integer that this NestedInteger holds, if it holds a single integer
         * Return null if this NestedInteger holds a nested list */
        Integer getInteger();

        /** @return the nested list that this NestedInteger holds, if it holds a nested list
         * Return null if this NestedInteger holds a single integer */
        List<NestedInteger> getList();
    }

}
