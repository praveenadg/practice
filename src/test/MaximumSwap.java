package test;

/**
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 *
 *
 * Constraints:
 *
 * 0 <= num <= 108
 *
 *
 *
 */
public class MaximumSwap {
    public static void main(String[] args){
        System.out.println(maximumSwap(2736));
    }

    public static int maximumSwap(int num) {
        if(num < 10) return num;

        char[] arr = String.valueOf(num).toCharArray();

        int[] rightIndex = new int[10]; // to hold the last index of each digit

        for(int i=0; i<arr.length; i++){
            rightIndex[arr[i] - '0'] = i;  // arr[i] - '0' converts char to num
        }
        //arr [2,7,3,6]
        //
        for(int i=0; i<arr.length; i++){  // index of present digit we are looking at
            for(int j=9; j>arr[i] - '0'; j--){ // max digit could be 9 and min be GREATER than the present digit we looking at
                if(rightIndex[j] > i){  // if index of 'j' (starts with 9) is greater than present index (basically, is the bigger digit at RIGHT of present digit)
                    // swap and return the answer
                    char temp = arr[i];
                    arr[i] = arr[rightIndex[j]];
                    arr[rightIndex[j]] = temp;
                    return Integer.valueOf(new String(arr)); // return here
                }
            }
        }

        // if we reach till here, that means no swapping is required in the input number.
        return num;
    }

    //not working for 120
    public static int maximumSwap1(int num) {
        char [] arr = String.valueOf(num).toCharArray();

        int min=Integer.MAX_VALUE;
        int minIndex=-1;
        //find first index of smallest element and then find last index of largest element to right of the smallest and swap
        for(int i=0; i<arr.length; i++){
            int val=arr[i]-'0';
            if(val<min){
                min=val;
                minIndex=i;
            }
        }
        if(minIndex>=0){
            // int max=Integer.M_VALUE;
            int maxIndex=-1;
            for(int i=minIndex; i<arr.length; i++){
                int val=arr[i]-'0';
                if(val>=min){
                    min=val;
                    maxIndex=i;
                }
            }

            if(maxIndex>=0){
                char temp=arr[minIndex];
                arr[minIndex]=arr[maxIndex];
                arr[maxIndex]=temp;
            }
            return Integer.valueOf(new String(arr));

        } else return num;


    }
}
