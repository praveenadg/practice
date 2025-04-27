package companies.walmart;

import java.util.ArrayList;

/***
 *
 * A = {1,3,4,6,8,11,19,20}
 * B = {22,18,14,8,4}
 * C = {10,2,3,11}
 * D = {2,2,2,4,5}
 * E = {10,8,3,3,3,3,1}
 *
 */
public class WalmartCoding {

    public record Employee(String name, int id) {
    }
    public static void main(String args[]){
        System.out.println(null == "text");
        int x = 0;
        callMethod(x);
        System.out.println(x);

        Employee e = new Employee("test", 1);
        callMethod(e);
        System.out.println(e);
        var list = new ArrayList<>();
        System.out.println(isArrayOrdered1(new int[]{1,3,4,6,8,11,19,20}));
        System.out.println(isArrayOrdered1(new int[]{22,18,14,8,4}));
        System.out.println(isArrayOrdered1(new int[]{10,2,3,11}));
        System.out.println(isArrayOrdered(new int[]{2,2,2,4,5}));
        System.out.println(isArrayOrdered1(new int[]{10,8,3,3,3,3,1}));
        System.out.println(isArrayOrdered1(new int[]{1,1}));
        System.out.println(isArrayOrdered1(new int[]{1}));
    }

    private static void callMethod(int x) {
        x = 10;
    }

    private static void callMethod(Employee e) {
        e = new Employee("abc", 2);
    }
    private static boolean isArrayOrdered(int [] arr){
        boolean isIncreasing=false;
        boolean isDecreasing=false;

        if(arr==null || arr.length==0)
            return false;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>arr[i-1]){
                isIncreasing=true;
            } else {
                if(isIncreasing)
                return false;
            }
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i]<arr[i-1]){
                isDecreasing=true;
            } else if(isIncreasing){
                if(isDecreasing)
                    return false;
            }
        }
        return isIncreasing || isDecreasing;

    }

    private static boolean isArrayOrdered1(int [] arr){
        boolean isIncreasing=true;
        boolean isDecreasing=true;

        for(int i=0; i< arr.length-1; i++){
            if(arr[i]>arr[i+1])
                isDecreasing=false;
            if(arr[i]<arr[i+1])
                isIncreasing=false;
        }
        return isIncreasing||isDecreasing;
    }



}
