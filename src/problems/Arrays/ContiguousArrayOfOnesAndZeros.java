package problems.Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayOfOnesAndZeros {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1, 0, 0, 1, 1, 0}));

        String s= "problems";
        String t= new String("problems");
        System.out.println(s==t);
        System.out.println(s.equals(t));


    }
//use map to count the ones and zeros at each index, whenever count matches we have found equal number of 1s 0s now find max length
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
       // map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if(count==0){
                maxlen=i+1;
            }
           else if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
