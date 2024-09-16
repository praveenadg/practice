package companies.walmart;

/* Given are two integer arrays which are sorted in ascending order and an integer k.
    A pair (x,y) is defined as, x belongs to first array and y belongs to second array.

    Find the k pairs (x1,y1),(x2,y2) ...(xk,yk) with the smallest sums.

    Example 1:

    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    Output: [[1,2],[1,4],[1,6]]
    Explanation: The first 3 pairs are returned from the sequence:
                 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
    Example 2:

    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
    Output: [[1,1],[1,1]]
    Explanation: The first 2 pairs are returned from the sequence:
                 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
    Example 3:

    Input: nums1 = [1,2], nums2 = [3], k = 3
    Output: [[1,3],[2,3]]
    Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
    */

import java.io.*;
import java.util.*;

public class kSmallestPairs {

    public static List<List<Integer>> kSmallestPairsInterview(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums1==null && nums2==null)
            return result;

        // int i=0, j=0;
        int length1=nums1.length;
        int length2=nums2.length;
        //, nums2 = [2,4,6] [1,7,11]

        for(int i=0; i< length1; i++){
            int num1=nums1[i];
            for(int j=0; j<length2; j++){

                if(result.size()==k){
                    return result;
                }
                List<Integer> pairs = new ArrayList<>();

                int num2=nums2[j];
                pairs.add(num1);
                pairs.add(num2);

                result.add(pairs);
                if(num1>num2){
                    break;
                }
            }
        }

        // while(i<length1-1 && j<length2-1 && result.size()<k){
        //     List<Integer> pairs = new ArrayList<>();
        //     int num1=nums1[i];
        //     int num2=nums2[j];
        //      pairs.add(num1);
        //     pairs.add(num2);

        //     if(num1>num2 && num2>nums1[i+1]){
        //         j++;
        //     } else {
        //         i++;
        //     }


        //     result.add(pairs);
        // }
        return result;

    }

    public static void main(String[] args) {
        int []nums1 = {1,1,2};
        int []nums2 = {1,2,3};
        int k = 2;
        System.out.println(kSmallestPairsInterview(nums1, nums2, k));
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)->(b[0]+b[1]) -(a[0]+a[1]));

        for(int i: nums1){
            for(int j: nums2){
                Integer[] arr = new Integer[]{i,j};
                pq.offer(arr);
                while(pq.size()>k){
                    pq.poll();
                }
            }
        }
        while(!pq.isEmpty()){
            Integer[] arr = pq.poll();
            result.add(Arrays.asList(arr));
        }
        return result;
    }
}