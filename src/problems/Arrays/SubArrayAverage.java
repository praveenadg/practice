package problems.Arrays;

public class SubArrayAverage {

    public static void main(String[] args) {
        int[]  nums =getAverages(new int[]{7,4,3,9,1,8,5,2,6},3);
        for(int num: nums){
            System.out.println(num);
        }

    }

    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int[] avg = new int[nums.length];
        long[] sum =new long[nums.length];
        int windowSize = 2 * k+1 ;
        sum[0]=nums[0];

        for(int i=1; i<nums.length; i++){
            sum[i]=nums[i]+sum[i-1];
            System.out.print(sum[i]+" ");
        }
        // Arrays.fill(avg, -1);
        for(int i=0 ;i<nums.length; ++i){
            if(i-k<0 || i+k>=nums.length){
                avg[i]=-1;
            } else {
                long summ=sum[i+k] - sum[i-k];
                avg[i] = (int)(summ/windowSize);
            }
        }
        return avg;

    }

}
