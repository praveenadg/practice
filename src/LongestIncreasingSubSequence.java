import java.util.ArrayList;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        String s = "\"";
    }

        public static int lengthOfLIS(int[] nums) {
            if(nums==null || nums.length==0)
                return 0;
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(nums[0]);

            for(int i=1; i<nums.length; i++){
                if(nums[i]>sub.get(sub.size()-1)){
                    sub.add(nums[i]);
                } else {
                    int j=0;
                    while(nums[i]>sub.get(j)){
                        j++;
                    }
                    sub.set(j, nums[i]);
                }
            }
            return sub.size();
        }

}
