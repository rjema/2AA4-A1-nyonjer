package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class RightHandPathFinder extends PathMovement{

    public RightHandPathFinder(Maze maze, Compass compass) {
        super(maze, compass);
        this.row = entry.leftRow();
        this.col = entry.leftCol();
        this.path = calculatePath();

    }

    public String getPath(){
        return factorisePath();
    }

    private String calculatePath() {
        StringBuffer pathBuffer = new StringBuffer("");
        super.moveForward();
        pathBuffer.append("F");
        while(!entry.isExit(row, col)){
            if (handOnWall()){
                if (super.canMoveForward()){
                    super.moveForward();
                    pathBuffer.append("F");
                } else {
                    compass.turnLeft();
                    pathBuffer.append("L");
                }
            } else {
                compass.turnRight();
                super.moveForward();
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

    private String factorisePath() {
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

    