import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa"));
        System.out.println( 3+(0x1F));
        int[][] result = new int[][]{};
    }
        public static boolean wordBreak(String s, List<String> wordDict) {
            StringBuilder stringBuilder = new StringBuilder();
            int left=0; int right=1;
            while(left<right && right <= s.length()){
                if(wordDict.contains(s.substring(left, right))){
                    stringBuilder.append(s.substring(left, right));
                    System.out.println(s.substring(left, right));
                    left=right;
                }
                right=right+1;
            }
            return  stringBuilder.toString().equals(s);

        }

}
