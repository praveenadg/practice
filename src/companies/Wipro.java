package companies;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    public class Wipro {

        public static void main(String[] args) {

            int[] origArray = new int[]{3,4,8,13,50};
            int[] finalArray = merge(new int[]{1,2,3,0,0,0},6, new int[]{2,5,6}, 3);

            for(int i=0;i< finalArray.length;i++) {
                System.out.println(finalArray[i]);
            }
            System.out.println("-------------------");
            int[] finalArray1 = insertInSortedArray(origArray, new int[]{2,12,55});

            for(int i=0;i< finalArray1.length;i++) {
                System.out.println(finalArray1[i]);
            }
        }

        public static int[] insertInSortedArray(int[] origArray, int [] toBeInserted) {
            int newLength=origArray.length+toBeInserted.length;
            int[] result = new int[newLength];
            int i=0;
            int j=0;

            //Write your code here

            for(int k=0; k<newLength; k++){
                if(j>=newLength ||
                        i<origArray.length && origArray[i]<toBeInserted[j]){
                    result[k]= origArray[i++];
                } else {
                    result[k]=toBeInserted[j++];
                }

            }
            return result;
        }


        public static  int[]  merge(int[] nums1, int m, int[] nums2, int n) {
            int mergedArrayLength= nums1.length+nums2.length;
            int[] result = new int[mergedArrayLength];

            int a=0, b=0;
            for(int i=0; i<mergedArrayLength; i++){
                if(a<nums1.length && b<nums2.length){
                    if(nums1[a]!=0 && nums1[a]<=nums2[b]){
                        result[i]=nums1[a++];
                    } else{
                        result[i]=nums2[b++];
                    }
                }
               else if(a<nums1.length){
                    result[i]=nums1[a++];
                }
                else if(b<nums2.length){
                    result[i]=nums2[b++];
                }
            }
    return result;
        }

    }


