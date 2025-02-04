package ca.mcmaster.se2aa4.mazerunner;

public enum Direction{
    NORTH, EAST, SOUTH, WEST;

    public Direction right(){
        // Changes direction to the one to the right of the current one
        return values()[(ordinal() + 1) % values().length];
    }

    public Direction left(){
        // Changes direction to the one to the left of the current one
        return values()[(ordinal() + values().length - 1) % values().length];
    }
}