package companies.visa;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {

        System.out.println("Hello, World");

        List<Integer> result = rotateArray(new int[]{1, 2, 3, 4, 5, 6}, 5);


        System.out.println(result);


    }


    private static List<Integer> rotateArray(int[] array, int k) {

        List<Integer> list = new ArrayList<>();

        if (array == null || array.length <= 1 || k == 0)

            return list;

        k = k % array.length;


        //   List<Integer> list = new ArrayList();

        int index = 0;

        int rotate = k;

        while (k > 0) {

            list.add(index++, array[array.length - k]);

            k--;

        }


        for (int i = 0; i < array.length - rotate; i++) {

            list.add(array[i]);

        }

        // list.toArray(new int[list.size()]);

        return list;


    }

}
