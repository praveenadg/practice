package problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        List<List<Integer>> ans = permute(new int[]{1,2,3});
        ans.stream().flatMap(Collection::stream).forEach(System.out::println);
       // System.out.println(permute(new int[]{1,2,3}));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(new ArrayList<>(), result, nums);
        return result;
    }

    private static void backtrack(List<Integer> current, List<List<Integer>> result, int[] nums)
    {
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i : nums){
            if(!current.contains(i)){
                current.add(i);
                backtrack(current, result, nums);
                current.remove(current.size()-1);
            }
        }

    }
}
