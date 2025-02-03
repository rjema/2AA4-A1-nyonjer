package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class PathTraverse extends PathMovement{
    private int leftRow, rightRow, leftCol, rightCol;

    public PathTraverse(String path, Maze maze, Compass compass){
        super(maze, compass);
        if (!path.matches("^[0-9FLR\\s]+$")){
            throw new IllegalArgumentException("Invalid path characters. F, L, R and numerical characters only.");
        }
        this.path = path;
        this.path = canonPath();
        this.leftRow = entry.leftRow();
        this.leftCol = entry.leftCol();
        this.rightRow = entry.rightRow();   
        this.rightCol = entry.rightCol();
    }

    private String canonPath(){
        StringBuilder result = new StringBuilder();
        StringBuilder numBuffer = new StringBuilder();

        for (char c: path.toCharArray()){
            if (Character.isDigit(c)){
                numBuffer.append(c);
            } else if (Character.isSpaceChar(c)){
                continue;
            } else {
                int count = Integer.valueOf(numBuffer.toString());
                numBuffer.setLength(0);
                result.append(String.valueOf(c).repeat(count));
            }
        }
        return result.toString();

    }

    private boolean leftTraversal(){
        row = leftRow;
        col = leftCol;

        for(int i = 0; i<path.length(); i++){
            if (path.charAt(i) == 'F'){
                if (super.canMoveForward()){
                    super.moveForward();
                } else {
                    return false;
                }
            } else if (path.charAt(i) == 'R'){
                compass.turnRight();
            } else {
                compass.turnLeft();
            }
        }

        if (row == leftRow && col == leftCol){
            return false;
        } else if (entry.isExit(row, col)){
            return true;
        }
        return false;
    }

    private boolean rightTraversal(){

        row = rightRow;
        col = rightCol;
        compass.setDirection(Direction.WEST);

        for(int i = 0; i<path.length(); i++){
            if (path.charAt(i) == 'F'){
                if (super.canMoveForward()){
                    super.moveForward();
                } else {
                    return false;
                }
            } else if (path.charAt(i) == 'R'){
                compass.turnRight();
            } else {
                compass.turnLeft();
            }
        }
        if (row == rightRow && col == rightCol){
            return false;
        }else if (entry.isExit(row, col)){
            return true;
        }
        return false;
    }

    public String traverse(){
        if (leftTraversal()){
            return "Correct path";
        } else if (rightTraversal()){
            return "Correct path";
        } else {
            return "Incorrect path";
        }
    }
}