package problems;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Maxx="+maxVowels("abciiidef", 3));

        reverseWords("a good   example");
        canPlaceFlowers(new int[]{1,0,0,0,1}, 1);
        System.out.println("Hello world!");
        System.out.println(gcd(100,75));
        System.out.println(gcd(18,21));
        System.out.println(gcd(1,2));

        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.pop();

        PriorityQueue<Integer> p = new PriorityQueue();
        p.add(5);
        p.add(2);
        p.add(4);
        p.add(1);

        while(p.size()>0){
            System.out.println(p.remove());
        }
    }



    public static int maxVowels(String s, int k) {
        List<String> vowels = List.of("a","e","i","o","u");

        int vowelCount=0;
        int max=0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.values();


//        for(int i=0; i<k;i++){
//            if(vowels.contains(String.valueOf(s.charAt(i)))){
//                vowelCount++;
//            }
//        }
        max=vowelCount;
        int left=0;
        int right=k;

        while(right<s.length()){

            if(vowels.contains(String.valueOf(s.charAt(left)))){
                vowelCount--;
            }
            if(vowels.contains(String.valueOf(s.charAt(right)))){
                vowelCount++;
            }
            right++; left++;
            max = Math.max(max,vowelCount);
        }
        return max;
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");

        int left=0; int right = arr.length-1;
        while(left<right){
            if(arr[left].isBlank()){
                left++;}
            if(arr[right].isBlank()){
                right--;}
            String temp = arr[left].trim();
            arr[left]=arr[right].trim();
            arr[right]=temp;
            left++;right--;
        }
        return String.join(" ",arr).trim();
    }

    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

        public static boolean canPlaceFlowers(int[] flowerbed, int n) {

            for (int i = 1; i < flowerbed.length - 1; i++) {
                if (flowerbed[n] == 0 && flowerbed[n - 1] == 0 && flowerbed[n + 1] == 0) {
                    n--;
                }

            }
            return n <= 0;
        }
}