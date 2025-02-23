package companies;

import companies.Snowflake.Solution.SearchOutput;

import java.util.*;

public class SnowflakeCorrected {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }

        Snowflake.Solution.SearchInput searchInput = new Snowflake.Solution.SearchInput("Fuzzy Wuzzy was a bear, Fuzzy Wuzzy had no hair, Fuzzy Wuzzy wasn't fuzzy, was he?",
                List.of("fuzzy", "Wuzzy", "hair"), true);

        Snowflake.Solution.SearchOutput searchOutput = searchKeywords(searchInput);
        System.out.println(searchOutput.isMatch);
        System.out.println(searchOutput.snippet);
        for (Map.Entry<String, Integer> entry : searchOutput.counts.entrySet()) {
            System.out.println("key= " + entry.getKey() + " value=" + entry.getValue());
        }
    }

    static Snowflake.Solution.SearchOutput searchKeywords(Snowflake.Solution.SearchInput searchInput) {
        Map<String, Integer> map = new HashMap<>();
        //if ignoreCase then store values in lowercase

        boolean ignoreCase = searchInput.ignoreCase;
        List<String> keywords = searchInput.keywords;
        String document = searchInput.document;
        Set<String> set = new HashSet<>();

        //get a list of caseInsensitive keywords
        List<String> allKeywords = new ArrayList<>();
        keywords.forEach(key -> {
            if (ignoreCase)
                key = key.toLowerCase();
            allKeywords.add(key);
        });

        String shortest = "";
        String[] arr = document.split("\\s+");//remove trailing spaces
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            String s = arr[right];
            s = s.replaceAll("[^A-Za-z0-9]", "");//remove non alphanumeric chars
            if (ignoreCase)
                s = s.toLowerCase();
            map.put(s, map.getOrDefault(s, 0) + 1);
            set.add(s);
            //get the snippet having all the words
            while (left < right && set.containsAll(allKeywords)) {
                StringBuilder snippet = new StringBuilder();
                for (int i = left; i <= right; i++) {
                    snippet.append(" ").append(arr[i]);
                }

                if (snippet.length() > shortest.length())
                    shortest = snippet.toString().trim();
                set.remove(arr[left++]);
            }

        }

        boolean isMatch = false;
        Map<String, Integer> counts = new TreeMap<>((a, b) -> keywords.indexOf(a) - keywords.indexOf(b));//to  preserve order

        int count = 0;
        for (String keyword : keywords) {
            String key = keyword;//preserve case in keyword
            if (ignoreCase)
                key = key.toLowerCase();
            if (map.containsKey(key)) {
                count++;
                counts.put(keyword, map.get(key));
            }
        }
        if (count == keywords.size())
            isMatch = true;


        return new SearchOutput(isMatch, counts, shortest);

    }
}
