package test.String;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(customSortString("bcafg","abcd"));
    }
    public static String customSortString(String order, String s) {
        // Create a frequency table
        //keep the frequency count of each character of s in a map or frequency array,
        // then iterate over the order and keep pushing the ones that match in the new resultant string.
        // Once this is done add all the remaining ones in the resultant string in any order.
        Map<Character, Integer> freq = new HashMap<>();

        // Initialize frequencies of letters
        // freq[c] = frequency of char c in s
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char letter = s.charAt(i);
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }

        // Iterate order string to append to result
        int K = order.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < K; i++) {
            char letter = order.charAt(i);
            while (freq.getOrDefault(letter, 0) > 0) {
                result.append(letter);
                freq.put(letter, freq.get(letter) - 1);
            }
        }

        // Iterate through freq and append remaining letters in any order
        // This is necessary because some letters may not appear in `order`
        for (char letter : freq.keySet()) {
            int count = freq.get(letter);
            while (count > 0) {
                result.append(letter);
                count--;
            }
        }

        // Return the result
        return result.toString();
    }

}
