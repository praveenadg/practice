package problems;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args){
        System.out.println(canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites){


        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> numList = new HashMap<>();
        //stores the number of edges entering node i.
        for(int i=0;i<numCourses;i++) {
            numList.put(i,new ArrayList<>());
        }
        // create an adjacency list
        for(int[] pre : prerequisites) {
            int from = pre[1];
            int to =pre[0];
            numList.get(from).add(to);
            indegree[to]++;
        }
        //Begin the BFS traversal by pushing all of the leaf nodes (indegree equal to 0) in the queue.
        Queue<Integer> numQueue = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                numQueue.add(i);
            }
        }
        int ans=0;
        while(!numQueue.isEmpty()) {
            int node = numQueue.poll();
            ans=ans+1;
            //iterate over neighbors and remove the edges if it has no cycle then indegree[cVal] == 0
            for(int neighbor : numList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    numQueue.add(neighbor);
                }
            }
        }
        //If the number of nodes visited is less than the total number of nodes, i.e., nodesVisited < n we return false as there must be a cycle. Otherwise, if nodesVisited == numCourses, we return true
        return ans == numCourses ;
    }

}
