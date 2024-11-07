package problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        generate(5);
        System.out.println(2070%2069);
    }

        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList();
            List<Integer> first = new ArrayList<>();
            first.add(1);
            result.add(first);

            for(int i=1; i<numRows; i++){
                List<Integer> row = new ArrayList<>();
                row.add(1);
                List<Integer> prevRow = result.get(i-1);

                for(int j=1; j<i; j++){
                    row.add(prevRow.get(j-1)+prevRow.get(j));
                }
                row.add(1);
                result.add(row);


            }
            return result;
        }

}
