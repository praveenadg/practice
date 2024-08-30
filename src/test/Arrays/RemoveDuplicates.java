package test.Arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int [] res = removeDuplicates(new int[]{5,1,1,2,2,3,3,4});
        for(int i : res){
            System.out.println(i);
        }

    }
    //using set
    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : nums) {
            set.add(i);
        }
       // return set.toArray();
        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set) {
            nums[index++] = i;
        }
        return result;
    }

}
