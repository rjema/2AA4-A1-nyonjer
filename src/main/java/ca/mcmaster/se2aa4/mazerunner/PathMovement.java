package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public abstract class PathMovement{
    protected String path;
    protected Maze maze;
    protected MazeEntry entry;
    protected CommandFactory commandFactory;
    protected Compass compass;
    protected int row, col;

    public PathMovement(Maze maze, Compass compass){
        this.maze = maze;
        this.compass = compass;
        this.entry = new MazeEntry(maze);
        this.commandFactory = new CommandFactory(compass);
    }

    protected boolean canMoveForward(){
        //Checks if forward tile is a passage depending on compass direction
        if (compass.getDirection() == Direction.NORTH){
            if (row == 0) return false;
            return maze.getMaze()[row-1][col] == Passage.PASS ? true : false;
        
        } else if (compass.getDirection() == Direction.EAST){
            if (col == maze.width()-1) return false;
            return maze.getMaze()[row][col+1] == Passage.PASS ? true : false;
        
        } else if (compass.getDirection() == Direction.SOUTH){
            if (row == maze.height()-1) return false;
            return maze.getMaze()[row+1][col] == Passage.PASS ? true : false;
        
        } else {
            if (col == 0) return false;
            return maze.getMaze()[row][col-1] == Passage.PASS ? true : false;
        }
    }

    protected void moveForward(){
        // Moves one tile forward based on compass direction
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