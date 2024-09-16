package companies;

public class FortNet {
    /***
     *
     * Please help us design a system. Think of this as I'm roleplaying a junior colleague, you can ask questions.
     *
     * We work for a startup and are building a new service were customers upload image files from important events, for example, they upload 100 photos from their wedding.
     * We transform those images into a collage video set to music with transitions between the images.
     *
     * We are getting image files as input, and send them through 10 stages to generate the video as output. Each stage takes as input the output of the previous stage.
     * Those stages are already written, we have a binary for each. The sequence is fixed, and there are no parameters. Each stage takes roughly 30min to complete,
     * and we ask the customers to come back to our website the next day to download their video.
     *
     * It’s important that the customer gets their video in the promised 24 hours.
     *
     * I have the stage programs, but how should I design the whole system around it?
     *
     *
     * Functional Requirements
     * 1. Users should be able to update the images- only images supported.
     * 2. Users should be able to download the video after 24hours.
     * 3. 100 images per request 1MB each image
     * 4. Can be mobile and web.
     * 5. User profile management - out of scope
     * 6. Notification - email or text
     * 7. Output 100MB
     * 8. payment -out of scope.
     * 9. upload from local.
     *
     *
     *
     * Non - Functional requirements
     * 1. DAU  100 request/hour
     * 2. 100*100MB - 240GB/day ~ 300TB/year
     * 3. 1 year active storage and then move the data to cold storage.
     * 4. Highly available.
     * 5. Consistency not a high priority
     * 6. Scalable
     *
     *
     * stage 1 topic -> partition -> consumer
     * stage 1 servers publishes
     * stage 2 servers
     */

    /***
     *
     *
     *
     * // Given a list of TreeNodes, determine if they form a single binary tree. If they do,
     * // return the root node value, otherwise return null.
     *
     * // Each TreeNode has a value and two child nodes. The child nodes can point to either
     * // another node in the inputed list OR to no node (represented through null).
     *
     * // class TreeNode:
     * //   value: int
     * //   left: TreeNode
     * //   right: TreeNode
     *
     * // Input format:
     * // N - number of nodes.
     * // On each of the following N lines, a 3-tuple consisting of: <Value, Left Child Index, Right Child Index>.
     * // "Left Child Index" means the index in the input array of the Left Child.
     * // This will be set to -1 in case there's no child.
     *
     * // Sample input:
     * // ---------------------------
     * // 1. A Single Binary Tree:
     * // ---------------------------
     * // 4
     * //0:  5 3 -1
     * //1:  4 -1 -1
     * //2:  8 1 0
     * //3:  6 -1 -1
     *
     * //    8
     * //   / \
     * //  4   5
     * //     /
     * //    6
     *
     * //[5, 3, -1]
     * //[4, -1, -1]
     * //[8, 1, 0]
     * //[6, -1, -1]
     * // Output: 8
     *
     * // ---------------------------
     * // 2. Two Binary Trees:
     * // ---------------------------
     * // 6
     * //0: 15 -1 -1
     * //1: 25 -1 -1
     * //2:  12 -1 0
     * //3: 67 -1 -1
     * //4:  98 2 -1
     * //5: 20 1 3
     * //[15, -1, -1]
     * //[25, -1, -1]
     * // [12, -1, 0]
     * // [67, -1, -1]
     * //  [98, 2, -1]
     * // [20, 1, 3]
     *
     * //    20        98
     * //   /  \      /
     * // 25    67  12
     * //             \
     * //              15
     *
     * // Output: -1 (due to having two distinct binary trees)
     *
     *
     *
     * // --------------------------
     * // 4. Cycle example:
     * // ---------------------------
     * //   9
     * //  4 <-> 5
     * //  0: 4 : 1 -1
     * //. 1: 5 : 0 -1
     * //  2: 9: -1, -1
     *
     * // 3
     * // 9 -1 -1
     * // 4 2 -1
     * // 5 -1 1
     *
     * // 0->1->2
     * //3->4->5->3
     *
     *
     * import java.io.*;
     * import java.util.*;
     * import java.text.*;
     * import java.math.*;
     * import java.util.regex.*;
     *
     * public class Solution {
     *
     *     class Node{
     *         int val;
     *         int left;
     *         int right;
     *
     *     }
     *
     *     static Integer isValidBinaryTree(List<Node> list){
     *
     *         Set<Integer> set = new HashSet<>();
     *         for(Node node : list){
     *             set.add(node.left);
     *              set.add(node.right);
     *         }
     *
     *         List<Integer> roots= new ArrayList();
     *         for(int i=0; i< list.size(); i++){
     *             if(!set.contains(i)){
     *                 roots.add(i);
     *             }
     *         }
     *
     *         if(roots.size()!=1){
     *             return null;
     *         }
     *
     *         Integer rootNodeIndex = roots.get(0);
     *         Node root= list.get(rootNodeIndex);
     *
     *         boolean[] visited = new boolean[list.size()];
     *
     *         //  0: 4 : 1 -1
     *         //. 1: 5 : 0 -1
     *         //3->4->5->3
     *         for(Node node : list){
     *             int left=node.left;
     *             int right=node.right;
     *             if(left!=)
     *             if(left>0 && right>0 && (visited[left] || visited[right])){
     *                 return null;
     *             }
     *             visited[left]=true;
     *             visited[right]=true;
     *
     *         }
     *
     *
     *
     *
     *     }
     *
     *     // static int addNumbers(int a, int b) {
     *     //   	return a+b;
     *     // }
     *
     *     // public static void main(String[] args) {
     *     //     Scanner in = new Scanner(System.in);
     *     //     int a;
     *     //     a = in.nextInt();
     *     //     int b;
     *     //     b = in.nextInt();
     *     //     int sum;
     *
     *     //     sum = addNumbers(a, b);
     *     //     System.out.println(sum);
     *     // }
     * }
     *
     *
     *
     */

//    import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//
//
//    class Result {
//
//        /*
//         * Complete the 'lostFragments' function below.
//         *
//         * The function is expected to return a STRING_ARRAY.
//         * The function accepts following parameters:
//         *  1. STRING sent
//         *  2. STRING received
//         */
//
//        public static List<String> lostFragments(String sent, String received) {
//            // Write your code here
//            // if(sent==null)
//            //     return Arrays.asList(received.split("\\s+"));
//            List<String> result = new ArrayList<>();
//            String [] receivedChunks = received.split("\\s+");
//            String [] sentChunks = sent.split("\\s+");
//
//            int j=0;
//            for(int i=0; i<sentChunks.length; i++){
//                if(j<receivedChunks.length && sentChunks[i].equals(receivedChunks[j])){
//                    j++;
//                } else {
//                    result.add(sentChunks[i]);
//                }
//            }
//            return result;
//
//
//        }
//
//    }
//
//    public class Solution {
//        public static void main(String[] args) throws IOException {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            String sent = bufferedReader.readLine();
//
//            String received = bufferedReader.readLine();
//
//            List<String> result = Result.lostFragments(sent, received);
//
//            bufferedWriter.write(
//                    result.stream()
//                            .collect(joining("\n"))
//                            + "\n"
//            );
//
//            bufferedReader.close();
//            bufferedWriter.close();
//        }
//    }
//
}
