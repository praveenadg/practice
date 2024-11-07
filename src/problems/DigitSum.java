package problems;

public class DigitSum {
    /**
     *
     * Write a function, given integer n, that returns the smallest non-negative integer whose digits sum to n.
     *
     * Test Cases:
     * Input: 16
     * Output: 79
     * Explanation: There are many numbers whose digits sum to 16 (i.e. 79, 97, 808, 5551, 22822), The smallest is 79.
     *
     * Input: 19
     * Output: 199
     *
     * Input: 7
     * Output: 7
     *
     * Constraints:
     * 0 <= n <= 50 -> max is 50 9*5+5 6 digits 999995</=>
     */
    public static void main(String [] args){
        System.out.println(digitSum(49));

        System.out.println(digitSum1(49));

    }

    private static int digitSum1(int n) {
        return (int) ((n % 9 + 1) * Math.pow(10, (n / 9)) - 1);
    }
    private static int digitSum(int n){
        if(n>9){
            int temp= n/9;
            int nines=buildNines(temp);
            int reminder =n%9;
            if(reminder==0) {
                return nines;
            }
            else{
                nines=(nines*10)+reminder;
            }
            return nines;
        } else
            return n;

    }

    private static int buildNines(int temp){
        int result=9;
        for(int i=1; i<temp; i++){
            result=(result*10)+9;
        }
        return result;
    }

}
