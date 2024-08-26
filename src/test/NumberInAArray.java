package test;

/**
 * The aim of this exercise is to check the presence of a number in an array.
 *
 * Specifications:
 * The items are integers arranged in ascending order
 * The array can contain up to 1 million items
 * The array is never null
 * Implement the method boolean A.exists(int[] ints, int k) so that it returns true if k belongs to ints, otherwise, the method should return false.
 *
 * Important note: Try to save CPU cycles if possible.
 *
 * Example:
 *
 * int[] ints = {-9, 14, 37, 102};
 * A.exists(ints, 102) returns true
 * A.exists(ints, 36) returns false
 *
 * All failed
 * he solution works with a 'small' array
 * Problem solving
 * +55 pts
 * The solution works with an empty array
 * Reliability
 * +25 pts
 * The solution works in a reasonable time with one million items
 * Problem solving
 * +140 pts
 * The solution works if k is the first element in the array
 * Reliability
 * +25 pts
 * The solution uses the J2SE API to perform the binary search
 * Language knowledge
 * +55 pts
 */
public class NumberInAArray {
    static boolean exists(int[] ints, int k) {
        int left=0;
        int right=ints.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(ints[mid]==k){
                return true;
            } else if(ints[mid]>k){
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return false;

    }
}
