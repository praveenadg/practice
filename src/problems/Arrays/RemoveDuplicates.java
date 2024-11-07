package problems.Arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int a;
        int A;
        int[] arr = new int[]{5,1,1,2,2,3,3,4};
        int [] res = removeDuplicates(new int[]{5,1,1,2,2,3,3,4});
        for(int i : res){
            System.out.println(i);
        }
        System.out.println("-------------------");

        int[] result = Arrays.stream(arr).distinct().toArray();
        for(int i : result){
            System.out.println(i);
        }


    }
    //using set
    public static int[] removeDuplicatesUsingSet(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : nums) {
            set.add(i);
        }
       // return set.toArray();
        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set) {
            result[index++] = i;
        }
        return result;
    }

    public static int[] removeDuplicates(int[] nums) {

        int end = nums.length;
    for (int i = 0; i < end; i++) {
        for (int j = i + 1; j < end; j++) {
            if(nums[i] == nums[j]){
                nums[j] = nums[end-1];//replace duplicate element with last element and decrement end and j
                end--;
                j--;//decrement j to recheck whether last element is also a duplicate
            }
        }
    }
        int[] result = new int[end];
        System.arraycopy(nums, 0, result, 0, end);
        return result;
    }


}
