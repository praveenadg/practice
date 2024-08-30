package test;

public class MaxSlidingWindow {
    public static void main(String[] args) {
       int[] result =maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
       for(int i : result){
           System.out.println(i);
       }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int r = length-k+1;
        int[] result = new int[r];
        //int ans=Integer.MIN_VALUE;
        int left=0;
        // int i=0;
        int right=0;
        for(int i=0; i<r;i++){
           int ans=Integer.MIN_VALUE;
            while(right<length && right-left<k){
                ans = Math.max(ans,nums[right]);
                right++;
            }
            left=right-k+1;
            right=left;
            result[i]= ans;
        }

        return result;
    }
}
