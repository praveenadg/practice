package test;

import java.util.*;
public class SmallestPositiveInteger {
    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
    public static void main(String args[]) {
        System.out.println(solution(new int[]{-1,-2,-60,40,43}));
        System.out.println(  Integer.toBinaryString(9));
        int n=9;String s="";
        while(n>0){
            s=((n%2)==0?"0":"1")+s;
            n=n/2;
        }
        System.out.println(s);



    }
        public static int solution(int[] A) {
            int n=A.length;
            boolean [] seen = new boolean[n+1];
            //BitSet bitSet = new BitSet();
            for(int i : A){
                if(i<=n && i>0){
              //      bitSet.set(i);
                    seen[i]=true;
                }
            }
            for(int i=1 ; i<=seen.length; i++){
                if(!seen[i]){//(!bitSet.get(i)){
                    return i;
                }
            }
            return n;
            // Implement your solution here
        }

    public static int solution2(int[] A) {
        int n=A.length;
      Arrays.sort(A);
      int minSoFar=1;
      for(int i=1; i<n-1; i++){
          if(A[i+1]-A[i]>1 && A[i]>0){
              return Math.min(minSoFar, A[i]+1);
          }
      }
        return A[A.length-1]<0? 1: A[A.length-1]+1;
        // Implement your solution here
    }

}
