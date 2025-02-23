package companies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snowflake {
    /*
     * Click `Run` to execute the snippet below!
     */


    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

    class Solution {
        public static void main(String[] args) {
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("Hello, World!");
            strings.add("Welcome to CoderPad.");
            strings.add("This pad is running Java " + Runtime.version().feature());

            for (String string : strings) {
                System.out.println(string);
            }

            SearchInput searchInput = new SearchInput("Fuzzy Wuzzy was a bear, Fuzzy Wuzzy had no hair, Fuzzy Wuzzy wasn't fuzzy, was he?",
                    List.of("fuzzy", "Wuzzy", "bear"), true);

            SearchOutput searchOutput = searchKeywords(searchInput);
            System.out.println(searchOutput.isMatch);
            for (Map.Entry<String, Integer> entry : searchOutput.counts.entrySet()) {
                System.out.println("key= " + entry.getKey() + " value=" + entry.getValue());
            }

        }
//}

        static class SearchInput {
            String document;
            List<String> keywords;
            boolean ignoreCase;

            SearchInput(String document, List<String> keywords, boolean ignoreCase) {
                this.document = document;
                this.keywords = keywords;
                this.ignoreCase = ignoreCase;
            }

        }

        static class SearchOutput {
            boolean isMatch;
            String snippet;
            Map<String, Integer> counts;

            SearchOutput(boolean isMatch, Map<String, Integer> counts, String snippet) {
                this.isMatch = isMatch;
                this.counts = counts;
                this.snippet = snippet;
            }
        }


        static SearchOutput searchKeywords(SearchInput input) {
            String document = input.document;
            Map<String, Integer> countsMap = new HashMap();

            String[] words = document.split(" ");
//[^A-Za-z0-9]replaceAll("/[^A-Za-z0-9]/", "");
            for (String word : words) {
                // word=word.replaceAll("/[^A-Za-z0-9]/", "").toLowerCase();
                word = word.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                System.out.println("word=" + word);
                countsMap.put(word, countsMap.getOrDefault(word, 0) + 1);
            }
            Map<String, Integer> responseCounts = new HashMap<>();
            for (String keyword : input.keywords) {
                //if(input.ignoreCase){
                if (countsMap.containsKey(keyword)) {
                    responseCounts.put(keyword, countsMap.get(keyword));
                }
                // }
                //
            }
            boolean isMatch = false;
            String snippet = "";
            System.out.println("responseCounts=" + responseCounts);
            System.out.println("size=" + responseCounts.size());
            if (responseCounts.size() == input.keywords.size()) {
                isMatch = true;
            }
            if (!isMatch) {
                responseCounts = new HashMap();
            }

            return new SearchOutput(isMatch, responseCounts, snippet);

        }
    }

// Your previous Plain Text content is preserved below:

// ## How to use CoderPad


// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: [https://app.coderpad.io/settings](https://app.coderpad.io/settings)

// Enjoy your interview!
// ----

// Let's build a search engine!

// ## Problem definition

// 1. We want to build a function that can find and count keywords in an input document, as well as generate a short snippet from the input text that contains all of the searched keywords.
// 2. We'd also like it to optionally be able to ignore the case of both input and keywords when performing the search.

// ## Specifications


// Given the input:

// "document": <string>,
// "keywords": [<string>, ...],
// "ignore_case": <boolean>

// Produce an output containing:

// "match": <boolean>
// "counts": {
// <string>: <int>
// },
// "snippet": <string>

// where:


// - match: true iff all keywords in keywords appear in document at least once
// - count: a count of how many times each keyword appears in document
// - snippet: a substring of document that contains all keywords at least once (ideally, the shortest such substring)

// ## Examples


// For example, given the input:

// "document": "Fuzzy Wuzzy was a bear, Fuzzy Wuzzy had no hair, Fuzzy Wuzzy wasn't fuzzy, was he?",
// "keywords": ["fuzzy", "wuzzy", "bear"],
// "ignore_case": true

// The expected output would be:

// "match": true,
// "counts": {
// "fuzzy": 4,
// "wuzzy": 3,
// "bear": 1
// },
// "snippet": "bear, Fuzzy Wuzzy"

// ## Additional details


// Note that:


// - Regardless of the value of 'ignoreCase', the case in the output should be the same as originally supplied in the input. (e.g. the keys in 'counts' should match 'keywords', and 'snippet' should preserve the case of 'document')
// - If 'match' is false, the value of the other two output fields is undefined, and can be set to implementation-convenient values.

// ## Example function

// - Note too that inputs and outputs are shown in a language neutral way, but you should feel free to use whatever format is most natural in your chosen language. For example, in python, this might be:

// def Search(document, keywords, ignore_case):
// return {
// "match": False,
// "counts": {},
// "snippet": ""
// }

}
