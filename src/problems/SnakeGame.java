package problems;

import java.util.*;

public class SnakeGame {
    static int foodIndex;
    static Set<int[]> body = new HashSet<>();
    static Deque<int[]> snake = new ArrayDeque<>();
    static int size;

    public static void main(String args[]){

    }

    static int move(String direction, List<int[]> food){
        int[] head = snake.getLast();
        int headRow=head[0];
        int headColumn = head[1];
        switch (direction){
            case "D":
                if(headRow==size-1)
                    headRow=0;
                else
                    headRow++;
            break;
            case "U" :
                if(headRow==0)
                    headRow=size-1;
                else
                    headRow--;
            break;
            case "L":
                if(headColumn==0)
                    headRow=size-1;
                else
                    headColumn--;
            break;
            case "R" :
                if(headColumn==size)
                    headRow=0;
                else
                    headColumn++;
            break;
            default: throw new RuntimeException("invalid move");
        }
        int[] newHead = new int[]{headRow, headColumn};
        snake.addFirst(newHead);
        body.add(newHead);
        if(newHead != food.get(foodIndex)){
            snake.pollFirst();
            body.remove(newHead);
        } else {
            foodIndex++;
        }
        if(body.contains(newHead)){
            return -1;
        }
return snake.size()-1;




    }
}
