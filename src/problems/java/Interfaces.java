package problems.java;

public class Interfaces {

    public static void main(String[] args) {
        Interfaces i = new Interfaces();
       A a = i.new AB(); // won't compile.

        a.hello();
        a.hi();
        B b = i.new AB();
        b.hi();
        b.hello();
    }
    interface A {
        default void hi() { System.out.println("A"); }
        void hello();
    }

    interface B  extends A {
        default void hi() { System.out.println("B"); }
        void hello();
    }

    interface C extends A,B{

    }

    class AB implements A,B {
//        @Override
//        public void hi() {
//            A.super.hi();
//        }

        @Override
        public void hello() {
            System.out.println("hello");
        } // won't compile if it implements two interfaces with same default method
    }



}
