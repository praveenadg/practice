package problems.Arrays;

public class MinValueToGetPositiveStepSum {

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{1,2}));
    }


    public static int minStartValue(int[] nums) {
        int sum=0;
        int minVal=0;
        for (int num : nums) {
            sum = sum + num;
            minVal = Math.min(minVal, sum);
        }
        return -minVal+1;//minVal is -4 so doing -minVal becomes -(-4)=4


    }
}
