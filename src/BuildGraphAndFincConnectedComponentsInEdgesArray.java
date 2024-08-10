import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BuildGraphAndFincConnectedComponentsInEdgesArray {

   static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();

    // graph input formats are
    // array of edges [][] [[0, 1], [1, 2], [2, 0], [2, 3]].
    // adjacency list graph = [[1], [2], [0, 3], []]. (index is connected to all the array elements in that index
    //adjacency matrix  = isConnected[j][i] = 1 id ith and jth city are connected[][]={[0,1,0,0][0,0,1,0][1,0,0,1],[0,0,0,0]}
    //matrix =

    //build adjacency map
   static Map<Integer , List<Integer>> map = new HashMap();//{0=[1, 2], 1=[0, 2], 2=[1, 0, 3], 3=[2]}
   static boolean[] seen;
    public static void main(String [] args){
       // System.out.println(buildGraph(new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{2, 3}}));//First input format: array of edges
        System.out.println(buildGraphAndReturnConnectedComponents(new int[][]{new int[]{2, 3}, new int[]{1, 2}, new int[]{1, 3}}));
        System.out.println(map);
        concurrentHashMap.put("","");
    }
    private static int buildGraphAndReturnConnectedComponents(int [] [] array){

        for(int i=0; i< array.length; i++) {
            int x = array[i][0];
            int y = array[i][1];

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(y);

            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }

        seen = new boolean[array.length+1];
        int count =0;
            for(int i=0; i< array.length; i++){
                if(!seen[i]){
                    count ++;
                    seen[i]=true;
                    dfs(i);
            }

        }
            return count;


    }
    private static void dfs(int i){
        if(map.get(i)!=null) {
            for (int neighbor : map.get(i)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    dfs(neighbor);
                }
            }
        }
    }
}
