package test;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String [] args){

        //0 1, 1, 2, 3,5,8,13,21,34,55,89
        System.out.println(rec(12));
        System.out.println(mem(12));
        System.out.println(iter(12));
    }

    private static int rec(int n){
        if (n <= 1) {
            return n;
        }
        return rec(n-1)+rec(n-2);    }

    private static int mem(int n){
        if (n <= 1) {
            return n;
        }
        if(map.containsKey(n))
            return map.get(n);
        map.put(n, mem(n-1)+ mem(n-2));
        return map.get(n);
    }
    private static int iter(int n){
        if (n <= 1) {
            return n;
        }
        int current = 0;
        int prev1 = 1;
        int prev2 = 0;
        for(int i=2; i<=n; i++){
           current =prev1+prev2;
           prev2=prev1;
           prev1=current;
        }
        return current;
    }
}
