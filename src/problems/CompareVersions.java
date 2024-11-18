package problems;

/**
 * Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
 *
 * To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 *
 * Example 1:
 *
 * Input: version1 = "1.2", version2 = "1.10"
 *
 * Output: -1
 *
 * Explanation:
 *
 * version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.
 *
 * Example 2:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 *
 * Output: 0
 *
 * Explanation:
 *
 * Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 *
 * Example 3:
 *
 * Input: version1 = "1.0", version2 = "1.0.0.0"
 *
 * Output: 0
 *
 * Explanation:
 *
 * version1 has less revisions, which means every missing revision are treated as "0".
 *
 *
 *
 * Constraints:
 *
 * 1 <= version1.length, version2.length <= 500
 * version1 and version2 only contain digits and '.'.
 * version1 and version2 are valid version numbers.
 * All the given revisions in version1 and version2 can be stored in a 32-bit integer.
 *
 *
 *
 *
 */
public class CompareVersions {
    public static void main(String args[]){
        //  String res = (rankTeams(new String []{"ABC","ACB","ABC","ACB","ACB"}));
        int res = (compareVersion1("1.2", "1.10"));
        System.out.println(res);
        System.out.println(divide(2147483647, 3));

    }
        public static int compareVersion(String version1, String version2) {
            if(version1.equals(version2))
                 return 0;
            String [] v1Array = version1.split("\\.");
            String [] v2Array = version2.split("\\.");
            int n1 = v1Array.length, n2 = v2Array.length;
            int i1, i2;
            for(int i=0; i<Math.max(n1,n2); i++){
                i1 = i < n1 ? Integer.parseInt(v1Array[i]) : 0;
                i2 = i < n2 ? Integer.parseInt(v2Array[i]) : 0;
                if (i1 != i2) {
                    return i1 > i2 ? 1 : -1;
                }
            }

            return 0;
        }

    public static int compareVersion1(String version1, String version2) {
        int i = 0, j = 0;
        int currentVersion1, currentVersion2;
        while(i < version1.length() || j < version2.length()) {
            currentVersion1 = 0;
            while(i < version1.length() && version1.charAt(i) != '.'){
                currentVersion1 = currentVersion1 * 10 + (version1.charAt(i) - '0');
                ++i;
            }

            currentVersion2 = 0;
            while(j < version2.length() && version2.charAt(j) != '.'){
                currentVersion2 = currentVersion2 * 10 + (version2.charAt(j) - '0');
                ++j;
            }

            if(currentVersion1 > currentVersion2)
                return 1;
            if(currentVersion2 > currentVersion1)
                return -1;
            ++i;
            ++j;
        }

        return 0;
    }


    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int res=0;
        boolean sign=true;
        if(dividend<0){
            dividend=-1*dividend;
            sign=false;
        }
        if(divisor<0){
            divisor=-1*divisor;
            sign=!sign;
        }
        // System.out.println("divisor="+divisor+" dividend= "+dividend);
        while(dividend-divisor>=0){
            dividend =dividend-divisor;
            if(sign)
                res++;
            else
                res--;
        }
        return res;
    }

}
