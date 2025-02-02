package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class Compass{
    private Direction direction;

    public Compass(){
        this.direction = Direction.EAST;
    }

    public void turnLeft(){
        this.direction = direction.left();
    }

    public void turnRight(){
        this.direction = direction.right();
    }

    public Direction getDirection(){
        return this.direction;
    }

}