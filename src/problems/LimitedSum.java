package problems;

import java.util.Arrays;

public class LimitedSum {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println( answerQueries(new int []{4,5,2,1}, new int [] {3,10,21}));
    }
        public static int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {

                int left = 0;
                int right = nums.length - 1;
                if (nums[0] > queries[i]) {
                    result[i] = 0;
                }
                // while(left<=right){
                int mid = left + (right - left) / 2;

                if (nums[mid] > queries[i]) {
                    right = mid - 1;
                }
                int sum = 0;
                for (int j = left; j <= right; j++) {
                    sum = sum + nums[j];
                    if (queries[i] <= sum) {
                        result[i] = (j+1);
                       // Math.ceil();
                    }
                }


                // }

            }
            return result;
        }


}
