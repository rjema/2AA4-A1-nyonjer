package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class Compass{
    private Direction direction;

    public Compass(){
        this.direction = Direction.EAST;
    }

    public void turnLeft(){
        //Changes compass direction to the one to its left
        this.direction = direction.left();
    }

    public void turnRight(){
        //Changes compass direction to the one to its right
        this.direction = direction.right();
    }

    public Direction getDirection(){
        //Returns current direction
        return this.direction;
    }

    public void setDirection(Direction direction){
        //Sets compass direction
        this.direction = direction;
    }

}