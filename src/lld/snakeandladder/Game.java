package lld.snakeandladder;

import lld.snakeandladder.exception.GameAlreadyStartedException;
import lld.snakeandladder.model.*;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    Queue<Player> players;
    Board board;
    Dice dice;
    GameStatus status;

    public Game(Board board, Dice dice) {
        this.players = new LinkedList<>();
        this.board = board;
        this.dice = dice;
        this.status = GameStatus.NOT_STARTED;
    }

    public void startGame(){
        this.status=GameStatus.INPROGRESS;
        while(players.size()>1) {
            Player player = players.remove();
            makeMove(player);
            if(player.getPosition() == board.getEndPosition())
                System.out.println(player.getName() + " has completed the game!");
            else
                players.add(player);
        }
        System.out.println("Game over");

    }

    void addPlayer(Player player) throws GameAlreadyStartedException {
        {
            if (this.status == GameStatus.NOT_STARTED) {
                this.players.add(player);
            } else
                throw new GameAlreadyStartedException("Can't add players after game started");
        }
    }

    private void makeMove(Player player){
        int position = dice.roll();
        System.out.println("roll=="+position);
        int newPosition = player.getPosition() + position;
        if (board.getEntities().containsKey(newPosition)) {
            SpecialEntity entity = board.getEntities().get(newPosition);
                newPosition = entity.getTail();
                if(entity instanceof Snake){
                    System.out.println("player "+player.getName() +" bit by snake and moved to "+ newPosition + " from "+ player.getPosition());
                } else {
                    System.out.println("player "+player.getName() +" got a ladder and moved to "+ newPosition + " from "+ player.getPosition());
                }
        }
       if(newPosition>board.getEndPosition()){
            System.out.println("Invalid Move");
        }else {
            player.setPosition(newPosition);
        }
    }
}
