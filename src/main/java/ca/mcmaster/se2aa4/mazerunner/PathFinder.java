package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class PathFinder {
    private Maze maze;
    private Compass compass;
    private int row, col;
    private MazeEntry entry;
    private String path;

    public PathFinder(Maze maze, Compass compass) {
        this.maze = maze;
        this.compass = compass;
        this.entry = new MazeEntry(maze);
        this.row = entry.leftRow();
        this.col = entry.leftCol();
        this.path = calculatePath();

    }

    public String getPath(){
        return factorisePath();
    }

    private String calculatePath() {
        StringBuffer pathBuffer = new StringBuffer("");
        moveForward();
        pathBuffer.append("F ");
        while(!entry.isExit(row, col)){
            if (handOnWall()){
                if (canMoveForward()){
                    moveForward();
                    pathBuffer.append("F");
                } else {
                    compass.turnLeft();
                    pathBuffer.append("L");
                }
            } else {
                compass.turnRight();
                moveForward();
                pathBuffer.append("RF");
            }
        }
        return pathBuffer.toString();
    }

    private boolean handOnWall(){
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

    private boolean canMoveForward(){
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

    private void moveForward(){
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

    private String factorisePath(){

        if (path == null || path.isEmpty()) return "";

        StringBuffer result = new StringBuffer();
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == path.charAt(i - 1)) {
                count++;
            } else {
                result.append(count > 1 ? count : "").append(path.charAt(i - 1)).append(" ");
                count = 1;
            }
        }

        result.append(count > 1 ? count : "").append(path.charAt(path.length() - 1));

        return result.toString().trim();
    }
}  

    