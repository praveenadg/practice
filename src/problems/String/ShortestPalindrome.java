package problems.String;

public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("adcba"));
    }

    public static String shortestPalindrome(String s) {

        if (s == null || s.length() <= 1)
            return s;

        int left = 0;
        for (int right = s.length() - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }

        // If the whole string is a palindrome, return the original string
        if (left == s.length()) {
            return s;
        }

        // Extract the suffix that is not part of the palindromic prefix
        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(
                nonPalindromeSuffix
        ).reverse();

// Form the shortest palindrome by prepending the reversed suffix
        return reverseSuffix
                .append(shortestPalindrome(s.substring(0, left)))
                .append(nonPalindromeSuffix)
                .toString();


    }

}
