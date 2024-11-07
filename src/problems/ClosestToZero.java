package problems;

/**
 * Implement the method int computeClosestToZero(int[] ts) which takes an array of temperatures ts and returns the temperature closest to 0.
 *
 *
 * Constraints:
 * If the array is empty, the method should return 0
 * 0 ≤ ts size ≤ 10000
 * If two temperatures are equally close to zero, the positive temperature must be returned. For example, if the input is -5 and 5, then 5 must be returned.
 * Result is correct with a simple data set: {7 5 9 1 4} -> 1
 * Problem solving
 * +70 pts
 * It works with -273 alone
 * Problem solving
 * +20 pts
 * It works with 5526 alone
 * Problem solving
 * +20 pts
 * It works when inputs contains only negative numbers: : {-15 -7 -9 -14 -12} -> -7
 * Problem solving
 * +35 pts
 * It works with two negative temperatures that are equal: {-10 -10} -> -10
 * Problem solving
 * +35 pts
 * The solution displays 0 if no temperature
 * Problem solving
 * +35 pts
 * When two temperatures are as close to 0, then the positive wins: {15 -7 9 14 7 12} -> 7
 * Problem solving
 * +85 pts
 */

    import java.util.*;
import java.io.*;

public class ClosestToZero {
        public static int computeClosestToZero(int[] ts) {
            // Write your code here
            // To debug: System.err.println("Debug messages...");
            if(ts==null || ts.length==0)
                return 0;

            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(int i:ts){
                if(i>0){
                    min=Math.min(min, i);
                } else if(i<0){
                    max=Math.max(max, i);
                } else{
                    return i;
                }
            }
            if(Math.abs(max)==min){
                return min;
            } else {
                return Math.abs(max)>min?min:max;
            }



        }

        /* Ignore and do not change the code below */
        public static void main(String args[]) {
            int a=5;
            int b=2;
            System.out.println(a/b);
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] ts = new int[n];
            for (int i = 0; i < n; i++) {
                ts[i] = in.nextInt();
            }
            PrintStream outStream = System.out;
            System.setOut(System.err);
            int solution = computeClosestToZero(ts);
            System.setOut(outStream);
            System.out.println(solution);
        }
        /* Ignore and do not change the code above */
}
