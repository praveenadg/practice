package test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

//[1,2,3,4,5,6,7] find shortest sub array sum=k
public class MockInterview {

    public static void main(String [] args){
        System.out.println(findShortestSubArray(new int[]{1,2,3,4,5,6,7}, 9));//if array has positive and negative int we can use prefix sum.

        //String=(((5+2)*(3-1))/7) //what are the supported operators?
        System.out.println(stringArithmeticEvaluator("(((5+2)*(3-1))/7)"));
        PriorityQueue<Integer> heap = new PriorityQueue<>();


        //
    }
    private static int stringArithmeticEvaluator(String expression){ //(((5+2)*(3-1))/7)
        int result=0;//validity, supported operators, number digits
        Stack<Character> operatorsStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        for( char c : expression.toCharArray()){
            if(c =='('){
                continue;
            }

            if(Character.isDigit(c)){
                intStack.push(Integer.parseInt(String.valueOf(c)));
            } else if(c ==')'){
                int rightVal = intStack.pop();
                char operator=operatorsStack.pop();
                int leftVal = intStack.pop();
                int temp=0;
                if(operator =='+'){
                    temp=leftVal+rightVal;
                }
                if(operator =='-'){
                    temp=leftVal-rightVal;
                }
                if(operator =='*'){
                    temp=leftVal*rightVal;
                }
                if(operator =='/'){
                    temp=leftVal/rightVal;
                }//extract to sep method.
                intStack.push(temp);
            } else {
                operatorsStack.push(c);
            }


        }
        return intStack.pop();

    }


    private  static int findShortestSubArray(int [] arr, int k){

        if(arr==null)
            return 0;
        int ans=Integer.MAX_VALUE;
        int left=0;
        int sum=0;

        for(int right=0; right< arr.length; right++){

            sum=sum+arr[right];

            while(sum>k){
                sum=sum-arr[left];
                left++;
                if(sum==k){
                    ans = Math.min(ans, (right-left)+1);
                }
            }

        }
        //edge case if array doesnt satisfy condition
        if(ans==Integer.MAX_VALUE)
                return -1;
        return ans;

    }
}
