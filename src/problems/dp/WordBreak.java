package problems.dp;

import java.util.List;

public class WordBreak {
    public static void main(String[] vv) {
        System.out.println(wordBreak("catsanddog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i < word.length() - 1)
                    continue;
                if (i == word.length() - 1 || dp[i - word.length()]) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
