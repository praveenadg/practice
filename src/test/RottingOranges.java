package test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RottingOranges {
    static boolean[][] visited;
    public static void main(String[] args) {
        System.out.println( 3+(0x1F));
        int[][] result = new int[][]{new int[]{2,1,1}, new int[]{1,1,0}, new int[]{0,1,1}};
        System.out.println(orangesRotting(result));
        Arrays.sort(result, (a, b)->  Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> allocator = new PriorityQueue(result.length, (a, b)->  Integer.compare((Integer) a, (Integer)b));
    }
        public static int orangesRotting(int[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            if(grid==null || grid.length == 0) return -1;
            int count=0;
            for(int i=0; i<grid.length; i++){
                for(int j=0;  j<grid[0].length; j++){
                    if(grid[i][j]==2){
                        count++;

                        dfs(i, j, grid);
                    }
                }
            }
            return count;

        }

        private static void dfs(int i, int j, int[][] grid){
            if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j]==0 || visited[i][j]==true )
                return;
            visited[i][j]=true;
            grid[i][j]=2;
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);


        }

}
