package problems.Arrays;


class Solution {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("gt12cty65mt1"));
        System.out.println(largestOddNumber("mkf43kdlcmk32klmv123"));

    }
    public static String largestOddNumber(String num) {

        char[] arr = num.toCharArray();
        int i=0;
        int max=Integer.MIN_VALUE;
        while(i<arr.length){
            if(!Character.isDigit(arr[i])){
                i++;
            } else {
                int intN=0;
                while(i<arr.length && Character.isDigit(arr[i])){
                    intN=intN*10+(arr[i]-'0');
                    i++;
                }
                if(intN%2!=0){
                    max=Math.max(max,intN);
                }

            }
        }
        if(max==Integer.MIN_VALUE){//line 40
            max=-1;
        }
        return String.valueOf(max);//just return max;

    }
}