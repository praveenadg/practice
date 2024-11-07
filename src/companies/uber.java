package companies;

    //import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

    /*

    Given a 2-dimensional grid of characters, and a dictionary, find all words in the grid that also appear in the dictionary. A word can be formed by traversing the grid by going either left, right, top, or down, but NOT diagonal. Also, a single grid position can not be used more than once in a word.
    For instance, in the following 3x3 grid, with a dictionary of [ CAT, COPY, ASK, SOS ]
    C A T
    O S K
    P Y U

    The first 3 words can be found in the grid, but not SOS, since one cannot use S twice.

    return: [ CAT, COPY, ASK ]

    */
// Main class should be named 'Solution' and should not be public.
    class uber {
        public static void main(String[] args) {
            System.out.println("Hello, World");
            char[][] grid = new char[][]{{'C','A','T'},{'O','S','K'},{'P','Y','U'}};
                Set<String> result = wordSearch(grid, Arrays.asList( "CAT", "COPY", "ASK", "SOS"));
            result.forEach(a->System.out.println(a));
            System.out.println("problems");

        }

        public static Set<String> wordSearch(char [][] grid, List<String> words){
            if(grid == null)
                return null;

            Set<String> result = new HashSet<>();

            boolean [][] visited = new boolean[grid.length][grid[0].length];
            for(String word : words){

                // char[] charArray = word.toCharArray();
                // for(int a; i<charArray.length; a++){
                int n = grid.length;
                for(int i=0; i<n; i++){
                    for(int j=0;j<grid[0].length;j++){
                        //if(c == grid[i][j]){
                        dfs(grid,i,j,word, 0, visited, result);
                        // }
                    }
                }

            }
            return result;
        }

//interview
//        private static void dfs(char [][] grid, int i, int j, String word, int charIndex,  boolean [][] visited,  List<String> result){
//            if(i>=grid.length || j >= grid.length || i<0 || j<0 || visited[i][j] || charIndex>=word.length())
//                return;
//
//            if(word.charAt(charIndex) == grid[i][j]){
//                visited[i][j]=true;
//                dfs(grid, i+1, j, word, charIndex+1,visited, result);
//                dfs(grid, i-1, j, word, charIndex+1,visited,result);
//                dfs(grid, i, j+1, word, charIndex+1,visited,result);
//                dfs(grid, i, j-1, word, charIndex+1,visited,result);
//
//            }
//            visited[i][j]=false;
//            if(charIndex==word.length()){
//                result.add(word);
//            }
//
//        }

        private static void dfs(char [][] grid, int i, int j, String word, int charIndex,  boolean [][] visited,  Set<String> result){
            if(i>=grid.length || j >= grid.length || i<0 || j<0 || visited[i][j] || charIndex>word.length())
                return;
            if(charIndex==word.length()){
                result.add(word);
                return;
            }
            if(word.charAt(charIndex) == grid[i][j]){
                visited[i][j]=true;
                dfs(grid, i+1, j, word, charIndex+1,visited, result);
                dfs(grid, i-1, j, word, charIndex+1,visited,result);
                dfs(grid, i, j+1, word, charIndex+1,visited,result);
                dfs(grid, i, j-1, word, charIndex+1,visited,result);

            }
            visited[i][j]=false;


        }
    }

