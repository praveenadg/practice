package companies;


import java.util.ArrayList;
import java.util.List;

public class Apple {
    /*
     * Click `Run` to execute the snippet below!


    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!


    // 1. Convert Binary Tree to Max Heap

    // class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        String[] parts = "/a/b/c".split("/");
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }

        Node root = new Node(5);
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(2);
        Node node4 = new Node(7);
/*
     5
   4   6
  2      7
 */
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        //int [] result = new int[5];
        List<Integer> list = new ArrayList<>();
        covertToMaxHeap(root, list, 0);

        for (int i : list) {
            System.out.println(i);
        }


    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void covertToMaxHeap(Node root, List<Integer> list, int index) {
        if (root == null)
            return;
        covertToMaxHeap(root.right, list, index);
        list.add(root.val);
        //System.out.println(root.val);
        covertToMaxHeap(root.left, list, index);
        //return result;
    }


    // }


}
