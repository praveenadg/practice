package problems;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    static Map<Character, Integer> charCountMap = new HashMap<>();
    static boolean isValid(String sub){
        Map<Character, Integer> subCharCountMap = new HashMap<>();
        for(char c : sub.toCharArray()){
            subCharCountMap.put(c, subCharCountMap.getOrDefault(c, 0)+1);
        }
        int count=0;
        for(Character c: charCountMap.keySet()){
            if( subCharCountMap.containsKey(c) && charCountMap.get(c).equals(subCharCountMap.get(c))){
                count++;
            }
        }
        return count==charCountMap.size();
    }
    public static void main(String[] args) {
        String s1="adc";
        String s2="dcda";

        int k=s1.length();
        for(char c : s1.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0)+1);
        }

        int left=0;
        for(int right=0; right<=s2.length()-k; right++){
            System.out.println(s2.substring(left,(right+k)));
            if(isValid(s2.substring(left, right+k))){
                System.out.println("found");
                break;
            }
            left++;

        }
        System.out.println("NOt found");



    }
    }
