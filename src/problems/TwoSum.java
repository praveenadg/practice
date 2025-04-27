package problems;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int target = 6;
        int[] result = twoSum(new int[]{3, 2, 4}, target);
        System.out.println(target);
        for(int num : result){
            System.out.println(num);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
    Arrays.sort(nums);
    for(int i=0; i<nums.length; i++){// 3,2,4 --- 6
        int compliment = target-nums[i];
        int complimentIndex = binarySearch(nums, compliment, i+1, nums.length);
        if(complimentIndex>0){
            return new int[]{i, complimentIndex};
        }
    }
return null;
}

private static  int binarySearch(int [] nums,int compliment, int left, int right){
    while(left<right){
        int mid = left+(right-left)/2;
        if(nums[mid]==compliment){
            return mid;
        } else if(nums[mid]>compliment){
            right=mid;
        } else {
            left=mid+1;
        }
    }
    return -1;
}
}
