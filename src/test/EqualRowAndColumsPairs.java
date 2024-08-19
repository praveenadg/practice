package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualRowAndColumsPairs {
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{new int[]{3,1,2,2},new int[]{1,4,4,4},new int[]{2,4,2,2},new int[]{2,5,2,2}}));
    }
    public static int equalPairs(int[][] grid) {
        List<List<Integer>> rowList = new ArrayList<>();
        List<List<Integer>> columnList = new ArrayList();

        for(int i=0; i<grid.length; i++){
            List<Integer> rows = new ArrayList();
            List<Integer> columns = new ArrayList();
            for(int j=0; j<grid.length; j++){
                rows.add(grid[i][j]);
                columns.add(grid[j][i]);
            }
            rowList.add(rows);
            columnList.add(columns);

        }
        int count =0;
        for(int i=0; i<rowList.size(); i++){
            count= count+ (Collections.frequency(columnList, rowList.get(i)));
        }
        return count;
    }
}
