package problems.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FndSmallestInteger {
    public static void main(String args[]){
        //  String res = (rankTeams(new String []{"ABC","ACB","ABC","ACB","ACB"}));
        int res = (findSmallestInteger(new int []{1,-10,7,13,6,8}, 5));
        System.out.println(res);

    }
    public static int findSmallestInteger(int[] nums, int value) {

        for(int i=0; i<nums.length; i++){
            if(nums[i]<0)
                nums[i]=nums[i]*-1;
            nums[i]=nums[i]%value;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(int i=0; i<nums.length; i++){
            if(!set.contains(i))
                return i;
        }
        return nums.length+1;


    }
}
