package companies;

public class Kinessoo {
    //Given a binary tree, find its minimum depth.
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

//Note: A leaf is a node with no children.

//       3 = 1
//     /  \
//    9    20 = 2
//        /  \
//       15   7 = 3


        public static void main(String[] args) {

            Node root = new Node(3);
            Node n1 = new Node(9);
            Node n2 = new Node(20);
            Node n3 = new Node(15);
            Node n4 = new Node(7);
          //  Node n5 = new Node(7);

            root.left=n1;
            root.right=n2;
            n2.left=n3;
            n2.right=n4;
           // n4.right=n5;


            System.out.println("minDepth= "+minDepth(root));
            System.out.println("maxDepth= "+maxDepth(root));
            diameter(root);
            System.out.println("diameter= "+diameter);
        }

        static class Node {
            int val;
            Node left;
            Node right;
            public Node(int val){
                this.val=val;
            }
        }

        private static int minDepth(Node root){
            if(root==null)
                return 0;
            if(root.left==null){
                return 1+minDepth(root.right);
            } else if(root.right==null){
                return 1+minDepth(root.left);
            } else {
                return Math.min(minDepth(root.left), minDepth(root.right))+1;
            }
        }
    private static int maxDepth(Node root){
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) +1;
    }


    static int diameter=0;
    private static int diameter(Node root){
            if(root==null)
                return 0;
            int left=diameter(root.left);
            int right=diameter(root.right);
            diameter= Math.max(diameter, left+right+1);
            return Math.max(left, right)+1;
    }
}
