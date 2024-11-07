package companies;

import java.util.*;

public class KarratPayP {

    /*
While grading papers as an assistant, you've noticed some of them are surprisingly similar. You've decided to write a simple plagiarism detector to try to combat this, including checking for swapped in synonyms.

You've found a list of synonyms online. These synonyms come in a list of pairs, and sometimes you may have to link together multiple pairs to see if the words are synonyms.

In this example, "paper", "composition" and "essay" are all synonyms:
synonyms1_1 = [
  ("paper", "composition"),
  ("composition", "essay")
]
So these lines are considered equal:
line1_1 = "this paper is totally an original paper"
line1_2 = "this composition is totally an original essay"

similar(line1_1, line1_2, synonyms1_1) => True

Write a function that takes in two lines and a list of synonym pairs, and returns whether the two lines are considered equal.

Additional input data:
line2_1 = "the man in the blue shirt sat by the blue sea in a blue chair under the blue sky"
line2_2 = "the man in the teal shirt sat by the cerulean sea in a navy chair beneath the cyan sky"
synonyms2_1 = [("teal", "turquoise"), ("teal", "cyan"), ("cerulean", "navy"), ("blue", "navy"), ("navy", "teal"), ("under", "beneath")]
synonyms2_2 = [("teal", "turquoise"), ("teal", "cyan"), ("cerulean", "navy"), ("blue", "navy"), ("under", "beneath")]

Here is a diagram of how synonyms2_1 and synonyms2_2 connect together:

   ===synonyms2_1===            ===synonyms2_2===

   cerulean     blue            cerulean     blue
           \    /                       \    /
            navy                         navy
              |
            teal                         teal
           /    \                       /    \
    turquoise   cyan             turquoise   cyan

     under - beneath              under - beneath

With synonyms2_1, all of the instances of blue in the first sentence have synonyms in the second. However, without the (navy, teal) synonym, such as in synonyms2_2, blue would not be considered a synonym of teal, turquoise, and cyan, so with those synonyms we return False.

line3_1 = "also these sentences are not really related in any way"
line3_2 = "i like cats a lot but dogs are ok too"
synonyms3_1 = [("too", "also"), ("cats", "felines"), ("dogs", "canines")]

line4_1 = "it is important to play in spring"
line4_2 = "it is important to plow in spring"
synonyms4_1 = [("lay", "low"), ("spring", "springtime")]

Test Cases:
similar(line1_1, line1_2, synonyms1_1) => True
similar(line2_1, line2_2, synonyms2_1) => True
similar(line2_2, line2_1, synonyms2_1) => True
similar(line2_1, line2_2, synonyms2_2) => False
similar(line3_1, line3_2, synonyms3_1) => False
similar(line4_1, line4_2, synonyms4_1) => False

Complexity Variables:
N = length of the lines
S = number of synonym pairs

*/

        public static void main(String[] argv) {
            String line1_1 = "this paper is totally an original paper";
            String line1_2 = "this composition is totally an original essay";
            String[][] synonyms1_1 = {
                    {"paper", "composition"},
                    {"composition", "essay"}
            };

            String line2_1 = "the man in the blue shirt sat by the blue sea in a blue chair under the blue sky";
            String line2_2 = "the man in the teal shirt sat by the cerulean sea in a navy chair beneath the cyan sky";
            String[][] synonyms2_1 = {
                    {"teal", "turquoise"},
                    {"teal", "cyan"},
                    {"cerulean", "navy"},
                    {"blue", "navy"},
                    {"navy", "teal"},
                    {"under", "beneath"}
            };
            String[][] synonyms2_2 = {
                    {"teal", "turquoise"},
                    {"teal", "cyan"},
                    {"cerulean", "navy"},
                    {"blue", "navy"},
                    {"under", "beneath"}
            };

            String line3_1 = "also these sentences are not really related in any way";
            String line3_2 = "i like cats a lot but dogs are ok too";
            String[][] synonyms3_1 = {
                    {"too", "also"},
                    {"cats", "felines"},
                    {"dogs", "canines"}
            };

            String line4_1 = "also these sentences are not really related in any way";
            String line4_2 = "i like cats a lot but dogs are ok too";
            String[][] synonyms4_1 = {
                    {"lay", "low"},
                    {"spring", "springtime"}
            };

           /*
            similar(line1_1, line1_2, synonyms1_1) => True
            similar(line2_1, line2_2, synonyms2_1) => True
            similar(line2_2, line2_1, synonyms2_1) => True
            similar(line2_1, line2_2, synonyms2_2) => False
            similar(line3_1, line3_2, synonyms3_1) => False
            similar(line4_1, line4_2, synonyms4_1) => False

            */

            System.out.println(isSynonym(line1_1, line1_2, synonyms1_1));
            System.out.println(isSynonym(line2_1, line2_2, synonyms2_1));
            System.out.println(isSynonym(line2_2,line2_1, synonyms2_1));
            System.out.println(isSynonym(line2_1, line2_2, synonyms2_2));
            System.out.println(isSynonym(line3_1, line3_2, synonyms3_1));
            System.out.println(isSynonym(line4_1, line4_2, synonyms4_1));


        }

    /**
     * working solution
     * @param line1
     * @param line2
     * @param synonyms
     * @return
     */
        private static boolean isSynonym(String line1, String line2, String[][] synonyms){
            Map<String, List<String>> map = new HashMap<>();
            for(String[] array : synonyms){
                String first = array[0];
                String second = array[1];

                if(!map.containsKey(first)){
                    map.put(first, new ArrayList<>());
                }
                map.get(first).add(second);
                if(!map.containsKey(second)){
                    map.put(second, new ArrayList<>());
                }
                map.get(second).add(first);

            }

            String [] lineOneWords = line1.split(" ");
            String [] lineTwoWords = line2.split(" ");

            if(lineOneWords.length != lineTwoWords.length)
                return false;

            int length = lineOneWords.length;

            for(int i=0; i<length; i++){
                if(!lineOneWords[i].equalsIgnoreCase(lineTwoWords[i])){
                    //System.out.println(map.get(lineOneWords[i]));
                    if(!dfs(map,lineOneWords[i], lineTwoWords[i], new HashSet<>())){
                        return false;
                    }
                }
            }
            return true;
        }

        static boolean dfs(Map<String, List<String>> map,  String wordOne, String wordTwo, Set<String> visited){
            if(map.get(wordOne)==null)
                return false;
            if(map.get(wordOne).contains(wordTwo)){
                return true;
            }
            for(String word : map.get(wordOne)){
                if(!visited.contains(word)) {
                    visited.add(word);
                    return dfs(map, wordTwo, word, visited);
                }
            }
            return false;
        }

    }

