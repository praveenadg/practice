package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianFinder {
    public static void main(String[] args) {
        System.out.println(findMedian(Arrays.asList(1,2,3)));

    }
    public static double findMedian(List<Integer> list) {
        Collections.sort(list);
        int mid;
        if(list.size()%2==0){
            mid=list.size()/2;
            return (list.get(mid)+list.get(mid-1))/2;

        }else{
            mid=(list.size()+1)/2;
            return list.get(mid);
        }
    }
}
