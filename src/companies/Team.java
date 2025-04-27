package companies;

import java.util.*;

public class Team {
 //   What happens when a user uploads a profile picture?
/*
Our local radio station is running a show where the songs are ordered in a very specific way.  The last word of the title of one song must match the first word of the title of the next song - for example, "Silent Running" could be followed by "Running to Stand Still".  No song may be played more than once.

Given a list of songs and a starting song, find the longest chain of songs that begins with that song, and the last word of each song title matches the first word of the next one.  Write a function that returns the longest such chain. If multiple equivalent chains exist, return any of them.

Example:
songs1 = [
    "Down By the River",
    "River of Dreams",
    "Take me to the River",
    "Dreams",
    "Blues Hand Me Down",
    "Forever Young",
    "American Dreams",
    "All My Love",
    "Cantaloop",
    "Take it All",
    "Love is Forever",
    "Young American",
    "Dreamship",
    "Every Breath You Take",
]
song1_1 = "Every Breath You Take"
chaining(songs1, song1_1) => ['Every Breath You Take', 'Take it All', 'All My Love', 'Love is Forever', 'Forever Young', 'Young American', 'American Dreams', 'Dreams']

Additional Input:
song1_2 = "Dreams"
song1_3 = "Blues Hand Me Down"
song1_4 = "Cantaloop"

songs2 = [
    "Bye Bye Love",
    "Nothing at All",
    "Money for Nothing",
    "Love Me Do",
    "Do You Feel Like We Do",
    "Bye Bye Bye",zz
    "Do You Believe in Magic",
    "Bye Bye Baby",
    "Baby Ride Easy",
    "Easy Money",
    "All Right Now",
]
song2_1 = "Bye Bye Bye"
song2_2 = "Bye Bye Love"

songs3 = [
    "Love Me Do",
    "Do You Believe In Magic",
    "Magic You Do",
    "Magic Man",
    "Man In The Mirror"
]
song3_1 = "Love Me Do"

All Test Cases:
chaining(songs1, song1_1) => ['Every Breath You Take', 'Take it All', 'All My Love', 'Love is Forever', 'Forever Young', 'Young American', 'American Dreams', 'Dreams']
chaining(songs1, song1_2) => ['Dreams']
chaining(songs1, song1_3) => ['Blues Hand Me Down', 'Down By the River', 'River of Dreams', 'Dreams']
chaining(songs1, song1_4) => ['Cantaloop']
chaining(songs2, song2_1) => ['Bye Bye Bye', 'Bye Bye Baby', 'Baby Ride Easy', 'Easy Money', 'Money for Nothing', 'Nothing at All', 'All Right Now']
chaining(songs2, song2_2) => ['Bye Bye Love', 'Love Me Do', 'Do You Feel Like We Do', 'Do You Believe in Magic']
chaining(songs3, song3_1) => ['Love Me Do', 'Do You Believe in Magic', 'Magic Man', 'Man In The Mirror']

Complexity Variable:
n = number of songs in the input
*/

    //working
    public static List<String> chaining(List<String> songs, String startSong) {
        Map<String, List<String>> firstWordMap = new HashMap<>();
        Map<String, String[]> songWordsMap = new HashMap<>();

        // Preprocess: map first words and split songs into words
        for (String song : songs) {
            String[] words = song.split("\\s+");
            songWordsMap.put(song, words);
            String first = words[0].toLowerCase();
            firstWordMap.computeIfAbsent(first, k -> new ArrayList<>()).add(song);
        }

        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        dfs(startSong, songs, firstWordMap, songWordsMap, visited, new ArrayList<>(), result);

        return result;
    }

    private static void dfs(String currentSong, List<String> songs,
                            Map<String, List<String>> firstWordMap,
                            Map<String, String[]> songWordsMap,
                            Set<String> visited,
                            List<String> path,
                            List<String> result) {
        visited.add(currentSong);
        path.add(currentSong);

        // Update result if this path is longer
        if (path.size() > result.size()) {
            result.clear();
            result.addAll(new ArrayList<>(path));
        }

        String[] words = songWordsMap.get(currentSong);
        String lastWord = words[words.length - 1].toLowerCase();

        List<String> nextSongs = firstWordMap.getOrDefault(lastWord, Collections.emptyList());
        for (String nextSong : nextSongs) {
            if (!visited.contains(nextSong)) {
                dfs(nextSong, songs, firstWordMap, songWordsMap, visited, path, result);
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
        visited.remove(currentSong);
    }


    //interview
        private static String[] formTheLongestChain(String firstSong, String[] songs) {
            Map<String, List<String>> startMap = new HashMap<>();
          //  Map<String, List<String>> endMap = new HashMap<>();
            Set<String> visited = new HashSet<>();
            for (String song : songs) {
                String beginWord = song.substring(0, song.indexOf(" "));
                startMap.putIfAbsent(beginWord, new ArrayList());
                startMap.get(beginWord).add(song);
            }
            //dfs();
            return null;
        }


    public static void main(String[] argv) {
        String[] songs1 = {
                "Down By the River",
                "River of Dreams",
                "Take me to the River",
                "Dreams",
                "Blues Hand Me Down",
                "Forever Young",
                "American Dreams",
                "All My Love",
                "Cantaloop",
                "Take it All",
                "Love is Forever",
                "Young American",
                "Dreamship",
                "Every Breath You Take"
        };
        String song1_1 = "Every Breath You Take";
        String song1_2 = "Dreams";
        String song1_3 = "Blues Hand Me Down";
        String song1_4 = "Cantaloop";

        String[] songs2 = {
                "Bye Bye Love",
                "Nothing at All",
                "Money for Nothing",
                "Love Me Do",
                "Do You Feel Like We Do",
                "Bye Bye Bye",
                "Do You Believe in Magic",
                "Bye Bye Baby",
                "Baby Ride Easy",
                "Easy Money",
                "All Right Now"
        };
        String song2_1 = "Bye Bye Bye";
        String song2_2 = "Bye Bye Love";

        String[] songs3 = {
                "Love Me Do",
                "Do You Believe In Magic",
                "Magic You Do",
                "Magic Man",
                "Man In The Mirror"
        };
        String song3_1 = "Love Me Do";
    }
    //time o(n) space o(n)
    public static String[] findSongs(String[][] songs){
        Map<Integer, String> map = new HashMap<>();
        int totalSeconds=420;
        for(String[] song : songs){
            int songDuration = getDuration(song[1]);
            int compliment = totalSeconds - songDuration;
            if(map.containsKey(compliment)){
                return new String[]{song[0], map.get(compliment)};
            }
            map.put(songDuration, song[0]);
        }
        return new String[]{};

    }

    private static int getDuration(String time){
        String [] array = time.split(":");
        return Integer.valueOf(array[0])*60+Integer.valueOf(array[1]);
    }

}
