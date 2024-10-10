package test.String;

public class CountSubStrings {

    public static void main(String[] args) {
        System.out.println("count="+countSubstrings("abc"));
    }
    public static int countSubstrings(String s) {

       // List<String> allStrings = new ArrayList();
        // backtrack(allStrings, s, new StringBuilder(), 0,0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                System.out.println("sub=" + s.substring(i, j));
                if (isPalindrom(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean  isPalindrom(String s){
            int left=0;
            int right=s.length()-1;

            while(left<right){
                if(s.charAt(left)!=s.charAt(right)){
                    return false;
                }
                left++;right--;
            }
            System.out.println("pal="+s);
            return true;
        }
}
