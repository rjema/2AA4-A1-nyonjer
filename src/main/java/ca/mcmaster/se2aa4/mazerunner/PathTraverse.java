package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Direction;

public class PathTraverse extends PathMovement{
    private int leftRow, rightRow, leftCol, rightCol;

    public PathTraverse(String path, Maze maze, Compass compass){
        super(maze, compass);
        if (!path.matches("^[0-9FLR]+$")){
            throw new IllegalArgumentException("Invalid path characters. F, L, R and numerical characters only.");
        }
        this.path = path;
        this.leftRow = entry.leftRow();
        this.leftCol = entry.leftCol();
        this.rightRow = entry.rightRow();   
        this.rightCol = entry.rightCol();
    }

    private String canonPath(){
        String factorPath[] = path.split(" ");
        StringBuffer cPath = new StringBuffer("");

        for (int i=0; i < factorPath.length; i++){

            if (factorPath[i].charAt(0) >= '2' && factorPath[i].charAt(0) <= '9'){

                int count = Character.getNumericValue(factorPath[i].charAt(0)); 

                //Add to canonical path string based on the number of times the character is to be repeated
                for (int j=0; j < count; j++){
                    cPath.append(factorPath[i].charAt(1));
                }
            } else {
                cPath.append(factorPath[i]);
            }
        }
        System.out.println(cPath.toString());

        return cPath.toString();
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

        if (entry.isExit(row, col)){
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

        if (entry.isExit(row, col)){
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