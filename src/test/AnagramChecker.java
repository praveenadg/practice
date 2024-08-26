package test;
import java.util.Arrays;

public class AnagramChecker {
    public static boolean areAnagrams(String s1, String s2)
    {
        // Sort both strings
        char[] charArray1 = s1.toLowerCase().toCharArray();
        char[] charArray2 = s2.toLowerCase().toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted strings
        return charArray1.equals(charArray2);
       // return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args)
    {
        String str1 = "Altitude";
        String str2 = "Latitude";

        if (areAnagrams(str1, str2)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

        str1 = "gram";
        str2 = "arm";

        if (areAnagrams(str1, str2)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}