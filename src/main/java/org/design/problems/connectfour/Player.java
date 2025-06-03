package org.design.problems.connectfour;

public class Player {

    private String name;
    private GridPosition color;

    public Player(String name, GridPosition color){
        this.name = name;
        this.color = color;
    }

    public GridPosition getColor() {
        return color;
    }

    public void setColor(GridPosition color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
