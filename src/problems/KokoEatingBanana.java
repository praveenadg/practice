package problems;

import java.util.Arrays;
import java.util.BitSet;

public class KokoEatingBanana {
    public static void main(String[] args) {
       String paragraph =
                "Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] array = paragraph.replaceAll("^[^a-zA-Z0-9]", " ").toLowerCase().split(" ");

        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        BitSet bitSet = new BitSet();
        bitSet.set(2);
        bitSet.set(3);
        bitSet.set(4);

        BitSet bitSet1 = new BitSet();
        bitSet1.set(1);
        bitSet1.set(3);
        bitSet1.set(4);
        bitSet1.and(bitSet);
        System.out.println(bitSet1);


       System.out.println(minEatingSpeed(new int[]{30,11,23,4,20},6));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left=1; int right=piles[piles.length-1];

        while(left<right){
            int mid = left+(right-left)/2;
            int rate = hoursToFinishAtRate(mid, piles);
            if(rate<=h){
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return right;

    }

    static int  hoursToFinishAtRate(int rate, int[] piles){
        int hours=0;
        for( int num : piles){
            hours= hours+ (int)Math.ceil((double) num / rate);//convert num to double to get ceiling number
        }
        return hours;
    }
}
