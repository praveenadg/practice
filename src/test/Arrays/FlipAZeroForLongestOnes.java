package test.Arrays;

public class FlipAZeroForLongestOnes {
    /**
     * Sliding window
     * You are given a binary string s (a string containing only "0" and "1"). You may choose up to one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?
     *
     * For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string becomes 1111100111.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(flipAZeroForLongestOnes("1101100111"));
        String s = "\"";
    }
    private static int flipAZeroForLongestOnes(String binaryString){
        int count =0;
        int numOfZeros=0;
        int left=0;
        for(int right=0; right<binaryString.length(); right++){
            if(binaryString.charAt(right)=='0')
                numOfZeros++;
            while(numOfZeros>1){
                if(binaryString.charAt(left++)=='0')
                    numOfZeros--;
            }
            count=Math.max(count, right-left+1);
        }return count;
    }
}
