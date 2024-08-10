public class ArmStrong {
    /**
     * Given an integer n, return true if and only if it is an Armstrong number.
     * <p>
     * The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 153
     * Output: true
     * Explanation: 153 is a 3-digit number, and 153 = 1pow3 + 5pow3 + 3pow3.
     * Example 2:
     * <p>
     * Input: n = 123
     * Output: false
     * Explanation: 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 108
     *
     * @param args
     */
    public static void main(String args[]) {

        System.out.println(isArmstrongInt(153));
        Math.pow(2, 3);
        int n = 9;
        String s = "";
        while (n > 0) {
            s = ((n % 2) == 0 ? "0" : "1") + s;
            n = n / 2;
        }
        System.out.println(s);

    }

    public static boolean isArmstrong(int n) {

        String val = String.valueOf(n);
        int length = val.length();
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = (int) Math.pow(Integer.valueOf(val.charAt(i) - '0'), length) + num;
            System.out.println(num);
        }
        return num == n;
    }

    public static boolean isArmstrongInt(int n) {
        int sum = 0;
        int temp = n;
        int original=n;
        int length = 0;

        while (temp > 0) {
            temp = temp / 10;
            length++;
        }


        while (n > 0) {
            int mod = n % 10;
            sum = (int) Math.pow(mod, length) + sum;
            n = n / 10;
        }
        return original == sum;
    }
}
