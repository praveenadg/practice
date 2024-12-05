package lld.snakeandladder.model;

import java.util.Random;

public class Dice {
    public int roll(){
        Random ran = new Random();
        return ran.nextInt(6)+1;
    }
}
