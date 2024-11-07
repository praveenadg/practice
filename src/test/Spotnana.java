package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.LinkedList;
import java.util.regex.*;


public class Spotnana {

    /**
     Imagine that you want to schedule a meeting of a certain duration with a co-worker.
     You have access to your calendar and your co-worker's calendar in the form of
     [startTime, endTime], as well as both of your daily bounds(i.e., the earliest and
     lastest times at which you're available for meetings every day, in the form of
     [earliestTime, latestTime]).

     Write a function that takes in your calendar, your daily bounds, your co-worker's
     calendar, your co-worker's daily bounds, and the duration of the meeting that you
     want to schedule, and returns a list of all the time blocks(in the form of
     [startTime, endTime]) during which you could schedule the meeting, ordered from
     earliest time block to latest.

     Your method signature should look like this:
     findMeetingTime(cal_1, daily_Bound_1, cal_2, daily_bound_2, duration)

     Sample Input
     calendar1 = [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]] - sorted
     dailyBounds1 = ["9:00", "20:00"] - start and end
     calendar2 = [["10:00", "11:30"], ["12:30", "14:30"], ["14:30", "15:00"], ["16:00", "17:00]] - sorted
     dailyBounds2 = ["10:00", "18:30"]
     duration = 30 - in minutes

     Sample Output
     [["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
     */


        public static void main(String[] args) {


            System.out.println(getAvailableTimes(new String[][]{{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}},
                    new String[] {"9:00", "20:00"}, new String[][]{{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}},  new String[] {"10:00", "18:30"}, 30));
        }

        static List<List<Integer>> getAvailableTimes(String[][] calendar1, String[] userOneBound,String[][] calendar2, String[] userTwoBound, int duration){


            PriorityQueue<int[]> pq = mergeCalendars(calendar1, calendar2);
            System.out.println(pq);
            java.util.LinkedList<int[]> list = new LinkedList<>();

            while(!pq.isEmpty()){
                System.out.println(pq.peek()[0]+"=="+pq.peek()[1]);
                list.add(pq.poll());
            }

            List<List<Integer>> result = new ArrayList<>();

            int start =Math.max(covertToMin(userOneBound[0]),covertToMin(userTwoBound[0]));
            int end =Math.min(covertToMin(userOneBound[1]),covertToMin(userTwoBound[1]));

            int[] first = list.getFirst();
            if( list.getFirst()[0] - start >= duration){
                List<Integer> slot = new ArrayList<>();
                slot.add(start);
                slot.add(list.getFirst()[0]);
                result.add(slot);
            }

            int[] last = list.getLast();
            if( last[0] - end >= duration){
                List<Integer> slot = new ArrayList<>();
                slot.add(last[0]);
                slot.add(end);
                result.add(slot);
                // System.out.println("slot="+slot);
            }

            for(int[] current : list){
                if(first[1] - current[0]> duration){

                    List<Integer> slot = new ArrayList<>();
                    slot.add(first[1]);
                    slot.add(current[0]);
                    result.add(slot);
                    System.out.println("slot="+slot);
                }
            }
            return result;

        }

        static  PriorityQueue<int[]> mergeCalendars(String[][] calendar1, String[][] calendar2){

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

            for(String[] cal : calendar1){
                pq.add(new int[]{covertToMin(cal[0]), covertToMin(cal[1])});
            }

            for(String[] cal : calendar2){
                pq.add(new int[]{covertToMin(cal[0]), covertToMin(cal[1])});
            }
            return pq;

        }

        static int covertToMin(String time){
            String[] split = time.split(":");
            return Integer.valueOf(split[0])*60+ Integer.valueOf(split[1]);
        }


        // interview end


    static String covertBackToHrAndMins(int time){
       int hour = time/60;
       int min= time%60;

        return hour + ":" + min;
    }


    static List<List<Integer>> getAvailableTimes1(String[][] calendar1, String[] userOneBound,String[][] calendar2, String[] userTwoBound, int duration){


        PriorityQueue<int[]> pq = new PriorityQueue<>();// mergeCalendars1(calendar1, calendar2);
        System.out.println(pq);
        java.util.LinkedList<int[]> list = new LinkedList<>();

        while(!pq.isEmpty()){
            System.out.println(pq.peek()[0]+"=="+pq.peek()[1]);
            list.add(pq.poll());
        }

        List<List<Integer>> result = new ArrayList<>();

        int start =Math.max(covertToMin(userOneBound[0]),covertToMin(userTwoBound[0]));
        int end =Math.min(covertToMin(userOneBound[1]),covertToMin(userTwoBound[1]));

        int[] first = list.getFirst();
        if( list.getFirst()[0] - start >= duration){
            List<Integer> slot = new ArrayList<>();
            slot.add(start);
            slot.add(list.getFirst()[0]);
            result.add(slot);
        }

        int[] last = list.getLast();
        if( last[0] - end >= duration){
            List<Integer> slot = new ArrayList<>();
            slot.add(last[0]);
            slot.add(end);
            result.add(slot);
            // System.out.println("slot="+slot);
        }

        for(int[] current : list){
            if(first[1] - current[0]> duration){

                List<Integer> slot = new ArrayList<>();
                slot.add(first[1]);
                slot.add(current[0]);
                result.add(slot);
                System.out.println("slot="+slot);
            }
        }
        return result;

    }

    static  List<List<Integer>> mergeCalendars1(String[][] calendar1, String[][] calendar2){

     List<List<Integer>> result = new ArrayList<>();
        int[][] mergedCal = new int[calendar1.length+calendar2.length][];
        int i=0;
        for(String[] cal : calendar1){
            List<Integer> list = new ArrayList<>();
            list.add(covertToMin(cal[0]));
            list.add(covertToMin(cal[1]));
            mergedCal[i]=new int[]{covertToMin(cal[0]), covertToMin(cal[1])};
            result.add(list);
        }

        for(String[] cal : calendar2){
            List<Integer> list = new ArrayList<>();
            list.add(covertToMin(cal[0]));
            list.add(covertToMin(cal[1]));
            mergedCal[i]=new int[]{covertToMin(cal[0]), covertToMin(cal[1])};
            result.add(list);
        }

        mergeIntervals(mergedCal);
        return result;

    }

    static LinkedList<int[]>  mergeIntervals(int[][]  times){
        LinkedList<int[]> result = new LinkedList<>();
        result.add(times[0]);

        for(int i=1; i< times.length; i++){
            if(result.getLast()[1]>= times[i][0]){
                result.getLast()[1] = Math.max(result.getLast()[1], times[i][1]);
            } else{
                result.add(times[i]);
            }
        }
        return result;

}
    }
