package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak1("catsanddog", Arrays.asList("cats","dog","and","cat")));
        System.out.println( 3+(0x1F));
        int[][] result = new int[][]{};
    }
//        public static boolean wordBreak(String s, List<String> wordDict) {//this doesn't work
//            StringBuilder stringBuilder = new StringBuilder();
//            int left=0; int right=1;
//            while(left<right && right <= s.length()){
//                if(wordDict.contains(s.substring(left, right))){
//                    stringBuilder.append(s.substring(left, right));
//                    System.out.println(s.substring(left, right));
//                    left=right;
//                }
//                right=right+1;
//            }
//            return  stringBuilder.toString().equals(s);
//
//        }

    public static boolean wordBreak1(String s, List<String> wordDict) {


        boolean [] dp = new boolean[s.length()+1];
       // Set<String> wordSet = new HashSet<>(wordDict);
        dp[0]=true;

        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j]&& wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        for(boolean val:dp){
            System.out.print(val+",");
        }
        return dp[s.length()];
    }


































    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set= new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }


    }
