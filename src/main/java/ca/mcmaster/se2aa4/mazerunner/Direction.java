package ca.mcmaster.se2aa4.mazerunner;

public enum Direction{
        NORTH, EAST, SOUTH, WEST;

        public Direction right(){
            return values()[(ordinal() + 1) % values().length];
        }

        public Direction left(){
            return values()[(ordinal() + values().length - 1) % values().length];
        }
    }