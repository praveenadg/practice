package companies.Metaa;

public class Metaa {

  // 1.   https://leetcode.com/problems/max-consecutive-ones-iii/description/
    //2. https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/?envType=daily-question&envId=2024-10-09

// Welcome to Meta!

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you would like to use for your interview,
// simply choose it from the dropdown in the left bar.

// Enjoy your interview!

/*
Given a string s, with ‘(’ and ‘)’ return the minimum number of parentheses that need to be added to make it valid
A valid string '(' appears before ')'

Input: "())"
Output: 1

Input: "((("
Output: 3

Input: "()"
Output: 0

Input: "()))(("
Output: 4

))((
 */

    //time o(n) space o(1)
    private int minimumPar(String s){
        if (s == null || s.isEmpty())
            return 0;
        int openCount=0;
        int invalidCount=0;
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i)==')'){ // if(s.charAt(')')){
                if(openCount==0){
                    invalidCount++;
                } else {
                    openCount--;
                }
            } else if(s.charAt(i)=='('){ //(s.charAt('(')){
                openCount++;
            }
        }

        return openCount+invalidCount;
    }


  //  https://leetcode.com/problems/swim-in-rising-water/description/
/*

You are given a terrain, represented by am N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t.
If you start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example Input
0 2
1 3

Output 3

Constraints

grid[i][j] is a permutation of [0, ..., N*N - 1]
You can traverse the grid only orthogonally
You can swim in infinite distance in 0 time

0  1  2  3  4
24 23 22 21 5
12 13 14 15 16
11 17 18 19 20
10 9  8  7  6

  */
// this is what I wrote in interview Not working, we need to used Dikstra's algo for this
    int gridTraverse(int[][] grid, int time){
        boolean [][] visited = new boolean[grid.length][grid[0].length];
    //int time=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j]){
                    dfs(i, j, grid, time);
                }
            }
        }
        return 0;
    }

    void dfs(int i, int j, int[][] grid, int time){
        if(i<0 || j<0 || i>grid[0].length-1 || j>grid[0].length-1){
            return;
        }
        if(grid[i][j]>time ){
            grid[i][j]=time-grid[i][j];
        }
        dfs(i+1,j,grid, time++);

    }
}
