package test.meta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Subsets {

    public static void main(String args[]){
        List<List<Integer>> res = (subsets(new int []{1,2,3}));
        res.forEach(a->System.out.print(a+","));

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, list, new ArrayList<>(), nums);
        return list;
    }

    //{},{1},{2},{3},{1,2},{2,3},{1,3},{1,2,3} subset of 0 subset of 1 subset of 2 subset of 3
    private  static void backtrack(int first, List<List<Integer>> list , List<Integer> tempList, int [] nums){
        // if(tempList.size()==currentSize){
        list.add(new ArrayList<>(tempList));
        // return;
        // }
        for(int i = first; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(i+1, list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
