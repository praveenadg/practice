package companies;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayToListTest {


    interface MyList{
        void convert(String[] a);
        void replace(int idx);
        ArrayList<String> compact();
    }

/*
Write the implementation of the InvalidStringException and the ArrayToList classes
Model strings for cut and paste:
I have added the string: {string} at the index: {index}
I have replaced the string: {string} with a null string
*/

  //  public class Solution{

        public  static class InvalidStringException extends Exception {
            public InvalidStringException(){
                super();
            }
            public InvalidStringException(String message){
                super(message);
            }
        }

        public static class ArrayToList implements MyList{

            private ArrayList<String> arrayToList;
            int size;

            public ArrayToList(){
                size=0;
                arrayToList = new ArrayList<>();
            }

            public void convert(String [] a){
                for(String st : a){
                    System.out.println("I have added the string: "+st+ " at the index: "+size);
                    arrayToList.add(size++, st);
                }
            }

            public void replace(int idx){
                if(idx<0 || idx>=size)
                    throw new ArrayIndexOutOfBoundsException("index="+idx+"size="+size);
                System.out.println("I have replaced the string: "+arrayToList.get(idx)+" with a null string");
                arrayToList.set(idx, "");

            }

            public ArrayList<String> compact(){
                for(int i=0; i<arrayToList.size(); i++){
                    if(arrayToList.get(i).isEmpty()){
                        arrayToList.remove(i);
                        size--;
                        i--;
                    }
                }
                return arrayToList;
            }

        }



        public static void main(String[] args){

            Scanner sc = new Scanner(System.in);
            Random rand = new Random(0);

            int n = Integer.parseInt(sc.nextLine());
            String[] a = new String[n];

            for(int i = 0; i < n; i++)
                a[i] = sc.nextLine();

            MyList obj = new ArrayToList();

            obj.convert(a);
            int x = rand.nextInt(n);
            for(int i = 0; i < x; i++)
                obj.replace(rand.nextInt(n));


            ArrayList<String> s = obj.compact();



            for (int i = 0; i < s.size(); i++){
                if(s.get(i).charAt(0) >= 97 && s.get(i).charAt(0) <= 122){
                    try{
                        throw new InvalidStringException("This is an invalid string");
                    }
                    catch(InvalidStringException e){System.out.println(e.getMessage());}
                }
            }


        }
  //  }
}
