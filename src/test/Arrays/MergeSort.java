package test.Arrays;
//inplace o(nlogn)
public class MergeSort {
    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };

        mergeSort(actual,actual.length);
        for(int i=0; i<actual.length; i++){
            System.out.print(actual[i]+" ");
        }
       // System.out.println(2069%2069);
    }

    //recursively divide array into two parts and then sort and merge
    // find mid and create two arrays left and right recursively and then call merge method with left right and original array

    private static void mergeSort(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if(arr.length <2){
            return;
        }
        int mid = arr.length/2;
        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for(int i = mid; i < arr.length; i++){
            right[i-mid] = arr[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n-mid);

        merge(arr, left, right);

    }

    private static void merge(int[] arr, int[] left, int[] right){
        int i = 0, j = 0, k=0;
        while(i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
            while(i < left.length){
                arr[k++] = left[i++];
            }
            while(j < right.length){
                arr[k++] = right[j++];
            }

    }
}
