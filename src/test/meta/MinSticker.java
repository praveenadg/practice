package test.meta;

import java.util.HashMap;
import java.util.Map;

/***
 *
 *
 * Given a string sticker that represents the set of characters available on a single sticker and a string word that represents the target word to spell out, return the minimum number of stickers that you need to spell out word. Each sticker can be used more than once, and you have an unlimited supply of stickers.
 * Meta version of https://leetcode.com/problems/stickers-to-spell-word/description/
 *
 * If the word cannot be spelled out using the letters on the sticker, return -1.
 *
 * Note:
 *
 * The sticker and word consist of lowercase English letters only.
 * The lengths of the sticker and word strings are both in the range [1, 1000].
 * Function Signature:
 *
 * public int minStickers(String sticker, String word) {
 * }
 * Example 1:
 * Input: sticker = "ban", word = "banana"
 * Output: 3
 * Explanation: We can use 3 stickers "bana" to spell out the word "banana". Each sticker provides one "b", one "a", and one "n". Three stickers provide all the letters needed to spell out "banana".
 *
 * Example 2:
 * Input: sticker = "abc", word = "def"
 * Output: -1
 * Explanation: The sticker does not contain any of the letters needed to spell out "def". Therefore, it is impossible to spell out the word.
 *
 * Constraints:
 * 1 <= sticker.length, word.length <= 1000
 * sticker and word consist of lowercase English letters.
 */
public class MinSticker {

    public static void main(String args[]){
        System.out.println(minStickers("ban","banana"));
        System.out.println(minStickers("ban","def"));
    }
    public static int minStickers(String sticker, String word) {

        Map<Character, Integer> stickerCount = new HashMap<>(); // Frequency array for the sticker
        Map<Character, Integer> wordCount = new HashMap<>(); //// Frequency array for the target word
        for(char c : sticker.toCharArray()){
            stickerCount.put(c, stickerCount.getOrDefault(c,0)+1);
        }
        for(char c : word.toCharArray()){
            wordCount.put(c, wordCount.getOrDefault(c,0)+1);
        }
        int maxCount=0;
        for(char c: wordCount.keySet()){
            if(!stickerCount.containsKey(c))
                return -1;  // If the letter is not in the sticker, return -1
            int currentCount = (int)Math.ceil((double)wordCount.get(c)/stickerCount.get(c)); // Calculate the number of stickers needed for this letter and update ans
            maxCount =Math.max(maxCount, currentCount);
        }
    return maxCount;
    }

}
