package test.meta;

import java.util.*;

public class GroupShifterString {

    public static void main(String args[]){
        List<List<String>> res = (groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}));
        res.stream().flatMap(Collection::stream).forEach(a-> System.out.println(a));

    }
    public static List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String hashKey = getHashKey(s);
            if(!map.containsKey(hashKey)){
                map.put(hashKey , new ArrayList<>());
            }
            map.get(hashKey).add(s);
        }

        List<List<String>> results = new ArrayList();

        for(List<String> values : map.values()){
            results.add(values);
        }
        return results;

    }

   static  String getHashKey(String s){
        char[] chars = s.toCharArray();
        StringBuilder hashKey = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            hashKey.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));//get the diff between two consecutive chars. Numbers with same shift will have same diff, since we are doing modulo 26
        }

        return hashKey.toString();
    }
}
