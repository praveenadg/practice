package companies;



import java.util.ArrayList;
import java.util.List;
import java.util.*;

    public class Wipro2 {
        //count vowels and consonants
        public static void main(String[] args) {

            String str = "This is a really simple sentence A1 B2";
            String modified="A man, a plan, a canal: Panama".replaceAll("[^a-zA-Z]", "");
            List<Integer> countList = getVowelsAndConsonantsForUpperAndLowerCases(str);
            countList.forEach(a->System.out.println(a));
        }

        public static List getVowelsAndConsonantsForUpperAndLowerCases(String str) {
            // Write your code here
            Map<String,Integer> map = new HashMap();
            Set<Character> vowels = new HashSet(Arrays.asList('a','e','i','o','u'));//new HashSet();//
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            //Character.isAlphabetic(str.charAt(0));
            char [] array =str.toLowerCase().replaceAll("[^a-zA-Z]","").toCharArray();
            for(char c: array){
                if(vowels.contains(c)){
                    map.put("vowels", map.getOrDefault("vowels",0)+1);
                } else {
                    map.put("consonants", map.getOrDefault("consonants",0)+1);
                }
            }
            List<Integer> result = new ArrayList();
            result.add(map.getOrDefault("vowels",0));
            result.add(map.getOrDefault("consonants",0));
            return result;
        }
    }


