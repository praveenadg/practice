package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * Data analysts at amazon are  studying the trends in movies and shows popular on prime video in order to enhance the viewer experience.
 * They have identified the best critic rated and the best audience rated web series represented by integer IDs series1 and series2.
 * They also define the watch score of a contiguous period of some days as the number of distinct series watched by a viewer  during that period.
 * Given an array watch_history, of size n days, and two integers, series1 and series2 report the minimum watch score of a contiguous period of days in
 * which both series1 and series2 have been viewed at least once. If series1 and series2 are the same value, one occurrence during the period is sufficient.
 * Example n = 5, series1 = 1, series2 = 2, watch_history = [1,3,2,1,4],The contiguous periods of days in which series1 and series2 have been watched at least once.
 * In a table of period of days (subarray of watch_history vs watch score,
 * period of days [1,3,2] watch score 3, for [3,2,1] watch score 3, for [2,1] watch score 2, for [1,3,2,1] watch score 3, for [1,3,2,1,4] watch score 4,
 * This whole table returns the minimum watch score 2. Complete the function getMinscore.
 */
public class AmazonVideoAnalysis {

    public static void main(String[] args) {
        int n = 5;
        int series1 = 1;
        int series2 = 2;
        int[] watch_history = {1, 3, 2, 3, 4};

        int result = getMinScore(n, series1, series2, watch_history);
        System.out.println("Minimum watch score: " + result);
    }
    public static int getMinScore(int n, int series1, int series2, int[] watch_history) {
        int left=0;
        int minScore =Integer.MAX_VALUE;
        Map<Integer, Integer> wh=new HashMap<>();
        boolean seenSeries1=false;
        boolean seenSeries2=false;
        for(int right=0; right<n; right++){
            wh.put(watch_history[right], wh.getOrDefault(watch_history[right],0)+1);

            if(watch_history[right]==series1)
                seenSeries1=true;
            if(watch_history[right]==series2)
                seenSeries2=true;

            while(left<right && seenSeries1 && seenSeries2){
                if(watch_history[left]==series1){
                    if(wh.get(series1)>0) {
                        wh.put(watch_history[left], wh.getOrDefault(watch_history[left], 0) - 1);
                    } if(wh.get(series1)==0) {
                        wh.remove(watch_history[left]);
                        seenSeries1=false;
                    }

                }
                if(watch_history[left]==series2){
                    if(wh.get(series2)>0) {
                        wh.put(watch_history[left], wh.getOrDefault(watch_history[left], 0) - 1);
                    } if(wh.get(series2)==0) {
                        wh.remove(watch_history[left]);
                        seenSeries2=false;
                    }

                }
                left++;
                minScore = Math.min(minScore, wh.size());

            }
        }
        return minScore==Integer.MAX_VALUE?-1: minScore;
    }
}
