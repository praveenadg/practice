package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * In this approach, we make use of a count variable, which is used to store the relative number of ones and zeros encountered so far while traversing the array. The count variable is incremented by one for every 1 encountered and the same is decremented by one for every 0 encountered.
 *
 * We start traversing the array from the beginning. If at any moment, the count becomes zero, it implies that we've encountered an equal number of zeros and ones from the beginning till the current index of the array(i).
 * Not only this, another point to be noted is that if we encounter the same count twice while traversing the array, it means that the number of zeros and ones are equal between the indices corresponding to the equal count values. The following figure illustrates the observation for the sequence [0 0 1 0 0 0 1 1]:->{(-1,0), (-2,1),(-1,2)}
 *
 * Contiguous_Array
 *
 * In the above figure, the subarrays between (A,B), (B,C), and (A,C) (lying between indices corresponding to count=−2) have an equal number of zeros and ones.
 *
 * Another point to be noted is that the largest subarray is the one between the points (A, C). Thus, if we keep a track of the indices corresponding to the same count values that lie farthest apart, we can determine the size of the largest subarray with equal no. of zeros and ones easily.
 *
 * Now, the count values can range between -n to +n, with the extreme points corresponding to the complete array being filled with all 0's and all 1's respectively. Thus, we make use of an array arr(of size 2n+1to keep track of the various count's encountered so far. We make an entry containing the current element's index (i) in the arr for a new count encountered everytime. Whenever we come across the same count value later while traversing the array, we determine the length of the subarray lying between the indices corresponding to the same count values.
 */

public class ContiguousArray {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println( findMaxLength(new int[]{0, 1, 0}));
    }

        public static int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
           // map.put(0, -1);
            int maxlen = 0, count = 0;
            for (int i = 0; i < nums.length; i++) {// [0, 1, 0] -> {(-1,0),(1--1(2), 1), (1,2)}}
                count = count + (nums[i] == 1 ? 1 : -1);
                if(count==0){
                    maxlen=i+1;
                }
                else if (map.containsKey(count)) {
                    maxlen = Math.max(maxlen, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }
            return maxlen;
        }
}
