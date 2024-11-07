package problems.Arrays;

public class LongestSubArray {
    /***
     * Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum is less than or equal to k. This is the problem we have been talking about above. We will now formally solve it.
     */

    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{10,9,2,5,3,7,101,18},15));
        String s = "\"";
    }

    private static int longestSubArray(int[] nums, int k){
        int result=0;
        int left=0;
       // int right=0;
        int sum=0;
        for(int right=0; right<nums.length; right++){
            sum=sum+nums[right];
            while(sum>k){
                sum=sum-nums[left];
                left++;
            }
            result=Math.max(result, right-left+1);
        }
        return result;
    }
}
