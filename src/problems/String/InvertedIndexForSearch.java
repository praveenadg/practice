package problems.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Inverted index class to store indeces of the words for searching
 * We store the docIds wherever the word appears.
 */
public class InvertedIndexForSearch {

    Map <String, HashSet<Integer>> index= new HashMap<>();

    public void  addDoc(int docId, String words){
        String[]  arr = words.split(" ");
        for(String word : arr){
            if(!index.containsKey(word)){
                index.put(word, new HashSet<>());
            }
            index.get(word).add(docId);
        }
    }

    public Set<Integer> searchWord(String word){
        return index.getOrDefault(word.toLowerCase(), new HashSet<>());
    }

}
