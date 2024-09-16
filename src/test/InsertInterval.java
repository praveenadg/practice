package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] result = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        Arrays.stream(result).flatMapToInt(Arrays::stream).forEach(System.out::println);

        // System.out.println(permute(new int[]{1,2,3}));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int i=0, n=intervals.length;

        while(i<n && intervals[i][1]<newInterval[0]){//end is less than start of new interval
            result.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){//start is less than or equal to end of new interval
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while(i<n){
            result.add(intervals[i]);
            i++;
        }


    return result.toArray(new int[result.size()][]);
    }
}
