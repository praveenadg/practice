package companies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FortiNet {
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
     */

    public static void main(String[] args) {
        /**
         * 1. There can be one and only 1 root node - with indegree of 0
         * 2. every node should have 1 indegree except root node
         * 3. Every node from input should be present in the tree
         */

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        /**
         *
         1
         ↙ ↘
         2   3
         ↙
         4
         */
        // Input: [n4, n2, n3, n1]
        //Output: true
        List<TreeNode> nodes = List.of(n4, n2, n3, n1);
        System.out.println(isValidTree(nodes));
    }

    static boolean isValidTree(List<TreeNode> nodes) {
        Map<TreeNode, Integer> indegree = new HashMap<>();
        for (TreeNode treeNode : nodes) {
            if (treeNode.left != null) {
                indegree.put(treeNode.left, indegree.getOrDefault(treeNode.left, 0) + 1);
            }
            if (treeNode.right != null) {
                indegree.put(treeNode.right, indegree.getOrDefault(treeNode.right, 0) + 1);
            }
        }
        TreeNode root = null;
        for (TreeNode node : nodes) {
            if (!indegree.containsKey(node)) {
                if (root == null)
                    root = node;//root has indegree of 0 so the map will not have it
                else
                    return false;//multiple roots
            } else if (indegree.get(node) != 1)
                return false;//if a node has indegree of more than 1
        }
        return root != null && indegree.keySet().size() + 1 == nodes.size();

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;


        TreeNode(int val) {
            this.val = val;
        }
    }
}
