package problems;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(nextPermutation(new int[]{1,2,3}))
        );
    }
    public static int[]  nextPermutation(int[] nums) {

        //find first decreasing element from right
        //find the number which is just larger than the first element.
        //swap these two and reverse the int's b/w these two

        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
