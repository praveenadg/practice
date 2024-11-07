package problems;

public class PalindromeInt {
    public static void main(String args[]){
        System.out.println(isPalindrome(1992));
    }

    private static boolean isPalindrome(int num){
        if(num<0)
            return false;
        int temp=num;
        int reverse=0;
        while(temp>0){
            int digits= temp%10;
            reverse=reverse*10+digits;
            temp=temp/10;
        }
        return num==reverse;
    }
}
