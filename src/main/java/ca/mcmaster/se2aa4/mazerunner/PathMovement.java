package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public abstract class PathMovement{
    protected String path;
    protected Maze maze;
    protected Compass compass;
    protected MazeEntry entry;
    protected int row, col;

    public PathMovement(Maze maze, Compass compass){
        this.maze = maze;
        this.compass = compass;
        this.entry = new MazeEntry(maze);
    }

    protected boolean canMoveForward(){
        if (compass.getDirection() == Direction.NORTH){
            return maze.getMaze()[row-1][col] == Passage.PASS ? true : false;
        } else if (compass.getDirection() == Direction.EAST){
            return maze.getMaze()[row][col+1] == Passage.PASS ? true : false;
        } else if (compass.getDirection() == Direction.SOUTH){
            return maze.getMaze()[row+1][col] == Passage.PASS ? true : false;
        } else {
            return maze.getMaze()[row][col-1] == Passage.PASS ? true : false;
        }
    }

    protected void moveForward(){
        if (compass.getDirection() == Direction.NORTH){
            row--;
        } else if (compass.getDirection() == Direction.EAST){
            col++;
        } else if (compass.getDirection() == Direction.SOUTH){
            row++;
        } else {
            col--;
        }
    }
}