package problems.java;

public class JAvaMCQ {
    public static void main(String[] args) {
        //float a = 35 / 0; //arithmaticException
        //System.out.println(a);
        try {
            System.out.println(dub(2, 3));

            System.out.println(new Double("129.4").byteValue());//byte holds upto 2pow8 value
        } catch (Exception e) {
        }
//        } catch (ArithmeticException a) {//always catch granular exception first, compile time error
//
//        }
    }

    static double dub(double a, double b) {
        return a + b;
    }
}
