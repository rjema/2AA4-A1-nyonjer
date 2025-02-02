package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class PathFinder {
    private Maze maze;
    private Compass compass;
    private int row, col;
    private MazeEntry entry;
    public PathFinder(Maze maze, Compass compass) {
        this.maze = maze;
        this.compass = compass;
        this.entry = new MazeEntry(maze);
        this.row = entry.leftRow();
        this.col = entry.leftCol();
    }

    public String getPath() {
        StringBuffer path = new StringBuffer("");
        moveForward();
        path.append("F ");
        while(!entry.isExit(row, col)){
            if (handOnWall()){
                if (canMoveForward()){
                    moveForward();
                    path.append("F ");
                } else {
                    compass.turnLeft();
                    path.append("L ");
                }
            } else {
                compass.turnRight();
                moveForward();
                path.append("R F ");
            }
        }
        return path.toString();
    }

    public boolean handOnWall(){
        if (compass.getDirection() == Direction.NORTH){
            return maze.getMaze()[row][col+1] == Passage.WALL ? true : false;
        } else if (compass.getDirection() == Direction.EAST){
            return maze.getMaze()[row+1][col] == Passage.WALL ? true : false;
        } else if (compass.getDirection() == Direction.SOUTH){
            return maze.getMaze()[row][col-1] == Passage.WALL ? true : false;
        } else {
            return maze.getMaze()[row-1][col] == Passage.WALL ? true : false;
        }
    }

    public boolean canMoveForward(){
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

    public void moveForward(){
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

    