package lld.snakeandladder.exception;

public class GameAlreadyStartedException extends Exception {
    public GameAlreadyStartedException(String message){
        super(message);
    }
}
