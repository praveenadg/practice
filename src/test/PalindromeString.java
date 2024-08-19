package test;

public class PalindromeString {
    public static void main(String args[]){
        System.out.println(isPalindrome("malayalaM"));
    }

    private static boolean isPalindrome(String s){
       String lowerStringS= s.toLowerCase();
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(lowerStringS.charAt(left)!=lowerStringS.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
