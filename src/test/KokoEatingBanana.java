package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class KokoEatingBanana {
    public static void main(String[] args) {
       String paragraph =
                "Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] array = paragraph.replaceAll("^[^a-zA-Z0-9]", " ").toLowerCase().split(" ");

        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        BitSet bitSet = new BitSet();
        bitSet.set(2);
        bitSet.set(3);
        bitSet.set(4);

        BitSet bitSet1 = new BitSet();
        bitSet1.set(1);
        bitSet1.set(3);
        bitSet1.set(4);
        bitSet1.and(bitSet);
        System.out.println(bitSet1);


        minEatingSpeed(new int[]{30,11,23,4,20},6);
    }
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left=piles[0], right=piles[piles.length-1];
        while(left<right){
            int mid=left+(right-left)/2;
            int rate=hoursTofinishAtThisRate(piles,mid);
            if(rate>h){
                left=mid+1;
            } else if(rate<h){
                right=mid-1;
            } else{
                return mid;
            }
        }
        return left;

    }

    public static int hoursTofinishAtThisRate(int[] piles, int rate){
        int hours=0;
        //Map<Integer, Integer> linkedHashMap= new LinkedHashMap<>();
      //  List<String> list = new ArrayList();

       // linkedHashMap.keySet().iterator().remove();
       // List<Integer> stack = new ArrayList<>();
        //stack.set()
        for(int banana : piles){
            hours +=  Math.ceil((double) banana / rate)+1;
        }
        return hours;
    }
}
