package problems;

/*
You are running a classroom and suspect that some of your students are passing around the answers to multiple choice questions.

You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice question in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
    ['b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'],
    ['b', 'a', 'c', 'c', 'e', 's', 'c', 'n'],
    ['a', 'l', 't', 'e', 'w', 'c', 'e', 'w'],
    ['a', 'l', 'o', 's', 's', 'e', 'c', 'c'],
    ['w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'],
    ['i', 'b', 'w', 'o', 'w', 'w', 'o', 'w']
]
word1_1 = "access"      # [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
word1_2 = "balloon"     # [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]

word1_3 = "wow"         # [(4, 3), (5, 3), (5, 4)] OR
                        # [(5, 2), (5, 3), (5, 4)] OR
                        # [(5, 5), (5, 6), (5, 7)]

word1_4 = "sec"         # [(3, 4), (3, 5), (3, 6)] OR
                        # [(3, 4), (3, 5), (4, 5)]

word1_5 = "bbaal"       # [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]


grid2 = [
  ['a'],
]
word2_1 = "a"

grid3 = [
    ['c', 'a'],
    ['t', 't'],
    ['h', 'a'],
    ['a', 'c'],
    ['t', 'g']
]
word3_1 = "cat"
word3_2 = "hat"

grid4 = [
    ['c', 'c', 'x', 't', 'i', 'b'],
    ['c', 'a', 't', 'n', 'i', 'i'],
    ['a', 'x', 'n', 'x', 'p', 't'],
    ['t', 'x', 'i', 'x', 't', 't']
]
word4_1 = "catnip"      # [(1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)] OR
                        # [(0, 1), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)]


All test cases:

search(grid1, word1_1) => [(1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4)]
search(grid1, word1_2) => [(0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (1, 7)]
search(grid1, word1_3) => [(4, 3), (5, 3), (5, 4)] OR
                          [(5, 2), (5, 3), (5, 4)] OR
                          [(5, 5), (5, 6), (5, 7)]
search(grid1, word1_4) => [(3, 4), (3, 5), (3, 6)] OR
                          [(3, 4), (3, 5), (4, 5)]
search(grid1, word1_5) => [(0, 0), (1, 0), (2, 0), (3, 0), (3, 1)]

search(grid2, word2_1) => [(0, 0)]

search(grid3, word3_1) => [(0, 0), (0, 1), (1, 1)]
search(grid3, word3_2) => [(2, 0), (3, 0), (4, 0)]

search(grid4, word4_1) => [(1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)] OR
                          [(0, 1), (1, 1), (1, 2), (1, 3), (1, 4), (2, 4)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
*/
//import javafx.util.Pair;

public class KaratWordSearch {
    public static void main(String[] argv) {
        char[][] grid1 = {
                {'b', 'b', 'b', 'a', 'l', 'l', 'o', 'o'},
                {'b', 'a', 'c', 'c', 'e', 's', 'c', 'n'},
                {'a', 'l', 't', 'e', 'w', 'c', 'e', 'w'},
                {'a', 'l', 'o', 's', 's', 'e', 'c', 'c'},
                {'w', 'o', 'o', 'w', 'a', 'c', 'a', 'w'},
                {'i', 'b', 'w', 'o', 'w', 'w', 'o', 'w'},
        };
        String word1_1 = "access";
        String word1_2 = "balloon";
        String word1_3 = "wow";
        String word1_4 = "sec";
        String word1_5 = "bbaal";

        char[][] grid2 = {
                {'a'},
        };
        String word2_1 = "a";

        char[][] grid3 = {
                {'c', 'a'},
                {'t', 't'},
                {'h', 'a'},
                {'a', 'c'},
                {'t', 'g'},
        };
        String word3_1 = "cat";
        String word3_2 = "hat";

        char[][] grid4 = {
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'a', 't', 'n', 'i', 'i'},
                {'a', 'x', 'n', 'x', 'p', 't'},
                {'t', 'x', 'i', 'x', 't', 't'},
        };
        String word4_1 = "catnip";
        int[][] result = findTheWord(grid1,word1_1);
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.println("index="+ i +" " + j);
            }
        }

    }
    static boolean[][] visited;
    private  static int [][] findTheWordINterview(char [][] grid, String word){

        int[][] wordIndexArray = new int[word.length()][2];
        char [] charsInWord = new char[word.length()];
        for(int charIndex=0; charIndex< charsInWord.length; charIndex++){
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){

                    if(charsInWord[charIndex]==grid[i][j]){
                        wordIndexArray[charIndex] =new int[]{i,j};
                        dfsInterview(grid, i, j, charsInWord, charIndex, wordIndexArray);
                        System.out.println("i="+i +"j="+j +"charIndex="+charIndex);
                    }
                }
            }
        }
        return wordIndexArray;

    }

    private static void dfsInterview(char [][] grid, int i, int j, char [] charsInWord, int charIndex, int[][] wordIndexArray){
        if(i<0 && j<0 && i>=grid.length && j>=grid.length && grid[i][j]!=charsInWord[charIndex] ){
            return;
        }
        if(grid[i][j]==charsInWord[charIndex]){
            wordIndexArray[charIndex] =new int[]{i,j};


            dfsInterview(grid, i,j+1,charsInWord, charIndex+1, wordIndexArray);
            dfsInterview(grid, i+1,j,charsInWord, charIndex+1, wordIndexArray);
        }


    }

    private  static int [][] findTheWord(char [][] grid, String word){
        int rows= grid.length;
        int cols =grid[0].length;
        int[][] result = new int[word.length()][2];
        visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(word.charAt(0)==grid[i][j]){
                    result[0]=new int[]{i,j};
                    dfs(grid,i,j,word,0,result);
                }
            }
        }
        return result;
    }

    private static void dfs(char [][] grid, int i, int j, String word, int charIndex, int[][] wordIndexArray){
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j]!=word.charAt(charIndex) || visited[i][j]){
            return;
        }
        if(charIndex==word.length()-1)
            return;

        if(grid[i][j]==word.charAt(charIndex)){
            wordIndexArray[charIndex] =new int[]{i,j};
            visited[i][j]=true;

            dfs(grid, i,j+1,word, charIndex+1, wordIndexArray);
            dfs(grid, i+1,j,word, charIndex+1, wordIndexArray);
        }
        visited[i][j]=false;

    }
}
