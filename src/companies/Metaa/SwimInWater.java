package companies.Metaa;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 *
 *You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
 *
 * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 *
 * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * Example 2:
 *
 *
 * Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation: The final route is shown.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 *
 *
 *
 *
 Intuition
 This code finds the minimum cost required to swim from the top-left corner to the bottom-right corner of a grid. Each cell in the grid represents the elevation required to swim in that cell. The swimmer can only move up, down, left, or right.

 Approach
 Priority Queue (Min-Heap): Use a priority queue to store cells to explore, sorted by the elevation required (minimum elevation first).
 Directional Array: Define an array to represent possible movements (up, down, left, right).
 Visited Array: Create a boolean array to keep track of visited cells.
 Exploration: Start from the top-left corner and explore cells in the priority queue until reaching the bottom-right corner.
 Update Priority Queue: For each adjacent cell, if it's within the grid and not visited, calculate the elevation required to swim and add it to the priority queue.

 Complexity
 Time complexity:O(N^2 * log(N))
 Space complexity:O(N^2)
 */
public class SwimInWater {
    public static void main(String [] args){
        System.out.println(swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
    }
    public static int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->(a[2]-b[2]));//row,col,weight
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];

        for(boolean[] i:visited)
            Arrays.fill(i,false);

        pq.add(new int[]{0,0,grid[0][0]});

        while(!pq.isEmpty()){
            int[] poll=pq.poll();
            if(visited[poll[0]][poll[1]])
                continue;
            if(poll[0]==n-1&&poll[1]==n-1)
                return poll[2];
            visited[poll[0]][poll[1]]=true;
            for(int[] i:directions){
                int X=poll[0]+i[0],Y=poll[1]+i[1];
                if(X>=0&&Y>=0&&X<n&&Y<n&&!visited[X][Y])
                    pq.offer(new int[]{X,Y,Math.max(poll[2],grid[X][Y])});//populate neighbors with
            }

        }
        return 0;
    }
}
