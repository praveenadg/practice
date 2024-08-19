package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println( firstMissingPositiveUsingSet(new int []{-1,-2,-60,40,43}));
    }
    public static int firstMissingPositive(int[] nums) {
        //sort and find the smallest positive int
        //see if the next positive int present in the arr until you find the missing

        Arrays.sort(nums);
        if(nums.length>0 && nums[0]>1){
            return 1;
        }
        for(int i=1; i<nums.length-1; i++){
            if(nums[i+1]-nums[i]>1  && nums[i]>=0 ){
                return Math.min(1,nums[i]+1);
            }
            if(nums[i+1]-nums[i]<0 && nums[i]>=0){
                return Math.min(1,nums[i]+1);
            }
        }
        return nums[nums.length-1]<0? 1: nums[nums.length-1]+1;
    }

    public static int firstMissingPositiveUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=1; i<nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    // int left=0; right=nums.length;
    // for(int i=left; i<right; i++){
    //     int mid = left+(right-left)/2;
    //     if (nums[mid]>0){
    //         right=mid-1;
    //     } else {
    //         left=mid+1;
    //     }
    // }

    // }

}
