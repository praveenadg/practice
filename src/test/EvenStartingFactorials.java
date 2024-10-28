package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class EvenStartingFactorials {
    // Method to check if the factorial of n starts with an even digit
    public static boolean startsWithEvenDigit(int n) {
        BigInteger factorial = BigInteger.ONE;

        // Calculate factorial
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Convert factorial to string and check the first digit
        String factorialStr = factorial.toString();
        int firstDigit = Character.getNumericValue(factorialStr.charAt(0));
        return firstDigit % 2 == 0;
    }

    // Method to find numbers with even starting factorials in a given range
    public static List<Integer> findNumbersWithEvenFactorials(int start, int end) {
        List<Integer> evenStartingNumbers = new ArrayList<>();

        for (int number = start; number <= end; number++) {
            if (startsWithEvenDigit(number)) {
                evenStartingNumbers.add(number);
            }
        }
        if(evenStartingNumbers.size()==0){
            evenStartingNumbers.add(0);
        }
        return evenStartingNumbers;
    }

    public static void main(String[] args) {

        System.out.print("Enter the start number: ");

        System.out.print("Enter the end number: ");
        Stack<Integer> st = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(1);
        pq.add(6);
        st.add(4);
        st.add(1);
        st.add(6);
        pq.remove(4);st.remove(Integer.valueOf(4));
        System.out.println(pq);
        System.out.println(st);



        List<Integer> result = findNumbersWithEvenFactorials(1, 10);
        List<Integer> result1 = findNumbersWithEvenFactorials(5, 7);
        System.out.println("Numbers whose factorials start with an even digit between " + 1 + " and " + 10 + ": " + result);
        System.out.println("Numbers whose factorials start with an even digit between " + 1 + " and " + 10 + ": " + result1);

      //  scanner.close();
    }
}

