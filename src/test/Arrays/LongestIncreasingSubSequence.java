package test.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        String s = "\"";
    }

        public static int lengthOfLIS(int[] nums) {
            if(nums==null || nums.length==0)
                return 0;
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[0]);

            for(int i=1; i<nums.length; i++){
                if(nums[i]>sub.get(sub.size()-1)){
                    sub.add(nums[i]);
                } else {
                    // int j=0;
                    // while(nums[i]>sub.get(j)){
                    //     j++;
                    // }
                        int j=binarySearch(sub, nums[i]);//since the sub list is sorted we can do binary search
                        sub.set(j, nums[i]);//find the index where this value can be inserted and replace the element
                }
            }
            return sub.size();
        }

        private static int binarySearch(List<Integer> sub, int num) {
            int left = 0;
            int right = sub.size() - 1;
            while(left<right) {
               int mid = left + (right - left) / 2;
                if (sub.get(mid) == num) {
                    return mid;
                } else if (sub.get(mid) > num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

}
