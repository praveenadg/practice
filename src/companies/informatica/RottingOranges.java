package companies.informatica;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        String s = "problems";
        s.indexOf("problems");
        // Arrays.binarySearch();
        System.out.println("Rotting Oranges= "+ timeTakenToRot(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println("Rotting Oranges= " + timeTakenToRotBFS(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public static int timeTakenToRot(int[][] grid){
        if(grid==null)
            return -1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    startRottingProcess(grid, i, j , 2);//pass 2 because we want to mark the rotting oranges2+1 each cycle
                }
            }
        }
        int time=2;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    return -1;
                }
                    time = Math.max(time, grid[i][j]);

            }
        }
        return time-2;
    }
    private static void startRottingProcess(int[][] grid, int i, int j, int time){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length ||  grid[i][j] == 0 /* empty cell*/ || (grid[i][j]>1 && grid[i][j]<time)){/*  last condition is this orange is already rotten by another rotten orange */
            return;
        } else{
            grid[i][j] = time;
            startRottingProcess(grid, i+1 , j , time+1);
            startRottingProcess(grid, i-1 , j , time+1);
            startRottingProcess(grid, i , j-1 , time+1);
            startRottingProcess(grid, i , j+1 , time+1);
        }
    }


    public static int timeTakenToRotBFS(int[][] grid) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int oranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }
        System.out.println("freshO=" + oranges);
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {1, 0}};
        int minutesElapsed = -1;

        q.add(new int[]{-1, -1});//to indicate different level
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            if (row == -1) {//we finished one round
                minutesElapsed = minutesElapsed + 1;
                if (!q.isEmpty()) {//to avoid endless loop
                    q.add(new int[]{-1, -1});//We use a delimiter (i.e. (row=-1, col=-1)) in the queue to separate cells on different levels. In this way, we only need one queue for the iteration.
                }
            } else {
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                        q.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                        oranges--;
                    }
                }
            }
            // minutesElapsed++;
        }

        return oranges == 0 ? minutesElapsed : -1;

    }
}
