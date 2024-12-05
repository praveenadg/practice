package lld.snakeandladder.model;

public class Player {
    int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    public Player(String name){
        this.name=name;
        this.position=0;
    }

}
