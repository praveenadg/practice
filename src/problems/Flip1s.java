package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Flip1s {

    /**
     * Two brothers were playing a game. Their mother gave them an array of numbers, with ea i,ch element being either 0 or 1,
     * she then asked them to find out the maximum number of 1s they could obtain by inversion of bits that is changing all 0' to 1s and 1s to 0s
     * for ny contiguous portion of the array.  The younger brother thought he could solve in his head,
     * but elder brother chose to write a program for optimal solution. Can you write a java code
     */

    public static void main(String[] args) {
        System.out.println(maxOnes(new int[]{1, 0, 0, 1, 0, 1, 0, 1}));

    }
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue(Comparator.naturalOrder());
        return 0;
    }

    private static int maxOnes(int[] arr){
        int ones=0;
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i]==1){
                arr[i]=-1;
                ones++;
            } else{
                arr[i]=1;
            }
            maxEndingHere=Math.max(arr[i], maxEndingHere+arr[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        if (ones == arr.length) {
            return ones - 1;
        }

        // Maximum 1s will be original ones + maxSoFar (from the flipped subarray)
        return ones + maxSoFar;
    }

}
