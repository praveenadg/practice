package test;

public class ReverseNumber {
    public static void main(String[] args) {

        System.out.println( reverse(-120));
        // System.out.println( firstMissingPositive1(new int []{-1,-2,-60,40,43}));
    }

    private static int reverse (int i){
        int result=0;
        while(i!=0){
            result=result*10+(i%10);//-12%10 =-2
            i=i/10;
        }
        return result;
    }
}
