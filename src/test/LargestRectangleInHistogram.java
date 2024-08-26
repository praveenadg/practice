package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestRectangleInHistogram {
    public static void main(String args[]){
        Queue<Integer> q= new LinkedList<>();
        System.out.println(holdsMaxWater(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleInHistogram(new int[]{2,1,5,6,2,3}));
    }

    private static int holdsMaxWater(int [] array){
        int maxArea=Integer.MIN_VALUE;
        for(int i=0; i<array.length;  i++){
            for(int j=i;  j<array.length; j++){
                maxArea=Math.max(maxArea, Math.min(array[i], array[j])*(j-i+1));//for holding max water
            }
        }
        return maxArea;

    }

    private static int largestRectangleInHistogram(int [] array){
        int maxArea=Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            int minHeight=Integer.MAX_VALUE;
            for(int j=i; j<array.length; j++){
                minHeight=Math.min(minHeight, array[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));

            }
        }
        return maxArea;
    }
}
