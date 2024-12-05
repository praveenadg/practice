package companies;

/**
 * Part 1: Sort simple semantic versions in either ascending or descending order.
 * Given an array of semantic version strings we want create a function to sort this array in either descending or ascending order.
 * There is a formal definition for semantic versions, however we will be using a paired down rule set.
 * * Each semantic string will contain major, minor and optional patch versions.
 * * Each version is an array of integers delimited by the character "."
 * * If a version does not include a patch, it is considered less than one that does include a patch.
 * Here are some examples of valid semantic versions:
 * 10.3 4.6.2 2.4.0 1.0.0 2.4 4.6.7
 * We would expect this list to be sorted into (if ascending): 1.0.0 2.4 2.4.0 4.6.2 4.6.7 10.3
 * Create a function that accepts two parameters, an array of semantic versions as strings, and a flag to indicate whether results should be ascending or descending. This function should return a collection of sorted strings in correct order.
 * You do not need to write quicksort or merge sort, please use any sorting functions built into the language or Google to look up APIs.
 * * [execution time limit] 3 seconds (java)
 * * [memory limit] 1 GB
 */
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Nextdoor {

    // Main class should be named 'Solution' and should not be public.

        public static void main(String[] args) {
            String [] sorted = sortVersions(new String[]{"10.3", "4.6.2","2.4.0","1.0.0","2.4","4.6.7"}, true);

            for(String version : sorted){
                System.out.println(version);
            }
            String [] sortedDesc = sortVersions(new String[]{"10.3", "4.6.2","2.4.0","1.0.0","2.4","4.6.7"}, false);

            for(String version : sortedDesc){
                System.out.println(version);
            }
        }

        public static String[] sortVersions(String[] versions, boolean isAsc){

            if(isAsc){
                Arrays.sort(versions, new VersionComparatorAsc());;
            } else {
                Arrays.sort(versions, new VersionComparatorAsc().reversed());
            }
            return versions;

        }

        static class VersionComparatorAsc implements Comparator<String>{
            @Override
            public int compare(String v1, String v2){
                String [] v1Array = v1.split("\\.");
                String [] v2Array = v2.split("\\.");

                int length = Math.max(v1Array.length, v2Array.length);

                for(int i=0; i< length; i++){
                    int p1 = i<v1Array.length ?  Integer.valueOf(v1Array[i]) :Integer.MIN_VALUE;
                    int p2 = i<v2Array.length ?  Integer.valueOf(v2Array[i]) :Integer.MIN_VALUE;

                    if(p1!=p2){
                        return Integer.compare(p1,p2);
                    }
                }

                return 0;
            }
        }
    }
