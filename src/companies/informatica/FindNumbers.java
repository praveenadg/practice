package companies.informatica;

import java.util.HashMap;
import java.util.Map;

public class    FindNumbers {

    public static void main(String args[]){
        int[] result = findNumbersSumming(new int[]{1,2,5,7,6,8}, 3);
        for(int num : result){
            System.out.println(num);
        }

    }
    private static int[] findNumbersSumming(int [] numbers, int target){
        if(numbers==null || numbers.length==0)
            return null;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int compliment =0;
        for( int i=0; i<numbers.length; i++){
            compliment = target - numbers[i];
            if(indexMap.containsKey(compliment)){
                return new int[]{i, indexMap.get(compliment)};//{(4,1)(3,2)(2,3)()}
            }
            indexMap.put(numbers[i],i);
        }
        return null;

    }
}
