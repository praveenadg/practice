package lld.snakeandladder.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int dimension;

    public Map<Integer, SpecialEntity> getEntities() {
        return entities;
    }

    public void setEntities(Map<Integer, SpecialEntity> entities) {
        this.entities = entities;
    }

    Map<Integer, SpecialEntity> entities;
    //int endPosition;

    public Board(int dimension) {
        this.dimension = dimension;
        entities = new HashMap<>();
    }

    public void addSpecialEntity(SpecialEntity entity) {
        entities.put(entity.head, entity);
    }

    public int getEndPosition() {
        return dimension * dimension;
    }

    public void printBoard() {
        int totalCells = dimension * dimension;
        for (int i = totalCells; i > 0; i--) {
            System.out.print(" | " + i + " ");

            if (entities.containsKey(i))
                System.out.print(entities.get(i).getTail());

            System.out.print(" |");
            if (totalCells % 10 == 0)
                System.out.println();
        }
    }
}
