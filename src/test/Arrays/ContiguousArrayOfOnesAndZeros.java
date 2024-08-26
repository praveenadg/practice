package test.Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayOfOnesAndZeros {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));

        String s="test";
        String t= new String("test");
        System.out.println(s==t);
        System.out.println(s.equals(t));


    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
