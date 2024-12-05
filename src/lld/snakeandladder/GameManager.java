package lld.snakeandladder;

import lld.snakeandladder.exception.GameAlreadyStartedException;
import lld.snakeandladder.model.*;

public class GameManager {

    public static void main(String args[]) throws GameAlreadyStartedException {

        SpecialEntity snake1 = new Snake(28, 12);
        SpecialEntity snake2 = new Snake(78, 34);
        SpecialEntity snake3 = new Snake(69, 6);
        SpecialEntity snake4 = new Snake(84, 65);

        SpecialEntity ladder1 = new Ladder(24, 56);
        SpecialEntity ladder2 = new Ladder(43, 83);
        SpecialEntity ladder3 = new Ladder(3, 31);
        SpecialEntity ladder4 = new Ladder(72, 91);

        Board board = new Board(10);
        board.addSpecialEntity(snake1);
        board.addSpecialEntity(snake2);
        board.addSpecialEntity(snake3);
        board.addSpecialEntity(snake4);

        board.addSpecialEntity(ladder1);
        board.addSpecialEntity(ladder2);
        board.addSpecialEntity(ladder3);
        board.addSpecialEntity(ladder4);

        board.printBoard();
        Game game = new Game(board, new Dice());
        game.addPlayer(new Player("One"));
        game.addPlayer(new Player("two"));
        game.addPlayer(new Player("three"));
        game.startGame();
    }
}
