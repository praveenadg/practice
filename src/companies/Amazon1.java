package companies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//merge intervals
public class Amazon1 {
//    Write a function that detects if two integer intervals overlap.
//
//            `**Input:** interval1 = [1,3] inverval2 = [2,6]`
//    Output: true
//
//
//
//    Now write a function that merges any overlapping intervals
//
//`**Input:** intervals = [[1,3],[2,6],[8,10],[15,18]]`

   // class Intervals{
        public static void main(String args[]){

            System.out.println(detectOverlap(new int[]{1,3}, new int[]{2,6}));
            List<List<Integer>> result = detectOverlap(new int[][]{{1,3},{2,6},{8,10},{15,18}});

            for(List<Integer> list : result){
                System.out.println(Arrays.toString(list.toArray()));
            }

            int[][] mergeInterval = mergeInterval(new int[][]{{1,3},{2,6},{8,10},{15,18}});
            for(int[] interval : mergeInterval){
                System.out.println(Arrays.toString(interval));
            }
        }

        static boolean detectOverlap (int[] interval1, int[] interval2){
            if(interval1 !=null && interval2 !=null && interval1.length==2 && interval2.length==2){
                Arrays.sort(interval1);
                Arrays.sort(interval2);
                return interval1[1] > interval2[0];

            }
            return false;

        }

 //   [1,3],[2,6],[5,7]


    static int[][] mergeInterval(int[][] interval){
        LinkedList<int[]> result = new LinkedList<>();
            result.add(interval[0]);

            for(int i = 1; i < interval.length; i++){
                if(result.getLast()[1]>interval[i][0]){
                    result.getLast()[1]=Math.max(result.getLast()[1],interval[i][1]);
                } else {
                    result.add(interval[i]);
                }
            }
            return result.toArray(new int[result.size()][]);
    }


    //modified version after interview
        static List<List<Integer>> detectOverlap (int[][] intervals) {

            List<List<Integer>> result = new ArrayList<>();

            if (intervals != null) {
                Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
                LinkedList<Integer> list = new LinkedList<>();//{1,6},{8,10},{15,18}
                list.add(intervals[0][0]);//1
                list.add(intervals[0][1]);//3 {1,3}

                for (int i = 1; i < intervals.length; i++) {
                    if (list.getLast() > intervals[i][0]) {
                        list.remove(list.size() - 1);
                        list.add(Math.max(list.getLast(), intervals[i][1]));
                        if(result.size()>0) {
                            result.remove(result.size() - 1);
                        }
                        result.add(list);
                    } else {
                        list.add(intervals[i][0]);
                        list.add(intervals[i][1]);
                        result.add(list);
                    }

                }

            }
            return result;
        }
}
//Interview
//    Write a function that detects if two integer intervals overlap.
//
//            `**Input:** interval1 = [1,3] inverval2 = [2,6]`
//    Output: true
//
//
//
//    Now write a function that merges any overlapping intervals
//
//`**Input:** intervals = [[1,3],[2,6],[8,10],[15,18]]`
//
//    class Intervals{
//        public static void main(String args[]){
//
//        }
//
//        static boolean detectOverlap (int[] interval1, int[] interval2){
//            if(interval1 !=null && interval2 !=null && interval1.length==2 && interval2.length==2){
//                Arrays.sort(interval1);
//                Arrays.sort(interval2);
//                if(interval1[1]>interval2[0]){
//                    return true;
//                }
//
//            }
//            return false;
//
//        }
//
//    [1,3],[2,6],[5,7]
//
//        static List<List<Integers>> detectOverlap (int[][] intervals){
//
//            List<List<Integers>> result = new ArrayList();
//
//            if(interval1 !=null){
//                Arrays.sort(intervals, (a,b)->a[0]-b[0]);
//                List<Integer> list = new LinkedList();//{1,6},{8,10},{15,18}
//                list.add(intervals[0][0]);//1
//                list.add(intervals[0][1]);//3 {1,3}
//
//                for(int i=1; i<intervals.length; i++){
//                    if(list.getLast()>intervals[i][0]){
//                        list.remove(list.size()-1);
//                        list.add(Math.max(list.getLast()[1], intervals[i][1]));
//                        result.remove(result.size()-1);
//                        result.add(list);
//                    } else {
//                        list.add(intervals[i][0]);
//                        list.add(intervals[i][1]);
//                        result.add(list);
//                    }
//
//                }
//                return result;
//
//
//
//
//
//
//
//
//
//            }
