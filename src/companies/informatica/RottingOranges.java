package companies.informatica;

import java.util.Arrays;

public class RottingOranges {

    public static void main(String[] args) {
        String s ="test";
        s.indexOf("test");
        // Arrays.binarySearch();
        System.out.println("Rotting Oranges= "+ timeTakenToRot(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
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
}
