public class ConnectedComponentGraphMatrix {

    static boolean[] seen;
    public static void main(String [] args){

        System.out.println(connectedComponents(new int[][]{new int[]{1,1,0}, new int[]{1,1,0}, new int[]{0,0,1}}));
       // System.out.println(map);
    }

    private static int connectedComponents(int[][] graph){
        int count =0;
        seen=new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            count++;
            dfs(graph,i);
        }
        return count;
    }
    private static void dfs(int [][] graph, int n){
        for(int i=0; i<graph.length; i++){
            seen[i]=true;
            if(graph[n][i]==1 && !seen[i]){
                dfs(graph, i);
            }
        }
    }

}
