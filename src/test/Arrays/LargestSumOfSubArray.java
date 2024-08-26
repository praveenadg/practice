package test.Arrays;

public class LargestSumOfSubArray {
    /**
     *
     *  Given an integer array nums and an integer k, find the sum of the subarray with the largest sum whose length is k.
     */
    public static void main(String[] args) {
        System.out.println(largestSumOfSubArray(new int[]{10,100,2,124,3,7,101,18},3));
        String s = "\"";
    }

    private static int largestSumOfSubArray(int[] nums, int k){
        int largestSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<k;i++){
            sum=sum+nums[i];
        }
        for(int i=k; i<nums.length; i++){
            sum=sum+nums[i]-nums[i-k];
            largestSum=Math.max(largestSum,sum );
        }
        return largestSum;
    }
}
