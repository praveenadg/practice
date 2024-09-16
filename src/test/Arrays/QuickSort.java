package test.Arrays;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,12,3,8,6,7,5,10,2,16,4,8};

       quicksort(array, 0, array.length-1);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void quicksort(int[] array, int start, int end){
        if (start < end) {
                int pivot=partition(array, start, end);
                quicksort(array,start, pivot-1);
                quicksort(array,pivot+1, end);
            }
        }

    /**
     *   // This function takes last element as pivot,
     *     // places the pivot element at its correct position
     *     // in sorted array, and places all smaller to left
     *     // of pivot and all greater elements to right of pivot
     * @param array
     * @param start
     * @param end
     * @return
     */
        private static int partition(int[] array, int start, int end){
        int pivot=array[end];
        int i=start-1;
        for(int j=start; j<end; j++){
            if(array[j]<pivot){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, end);
        return i+1;
        }
        private static void swap(int[] array, int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        }
}
