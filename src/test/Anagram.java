package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
 * "Listen = Silent"
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Math.random();
        System.out.println(anagram(new String[]{"eat","tea","tan","ate","nat","bat"}));//[[eat, tea, ate], [bat], [tan, nat]]
    }
    public static List<List<String>> anagram(String [] arr){
        HashMap<String, List<String>> anagramMap = new HashMap();
        for(String text : arr) {
            char [] chars = text.toCharArray();
             Arrays.sort(chars);
            String key = new String(chars);
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(text);
        }
        return new ArrayList(anagramMap.values());
    }
}
