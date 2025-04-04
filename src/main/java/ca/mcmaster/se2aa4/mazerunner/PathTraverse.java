package ca.mcmaster.se2aa4.mazerunner;

public class PathTraverse extends PathMovement{
    private int leftRow;
    private int rightRow;
    private int leftCol;
    private int rightCol;

    public PathTraverse(String path, Maze maze, Compass compass){
        super(maze, compass);
        // Checks if path sequence contains illegal characters
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
        //Returns canonical path representation

        path = path.replaceAll("\\s+", "");
        int count = 0;

        // Checks if path is already canonically represented
        if (path.matches("^[FRL]+$")){
            return path;
        } 

        StringBuilder result = new StringBuilder();
        StringBuilder numBuffer = new StringBuilder();

        for (char c: path.toCharArray()){
            //Finding digits that make up integer representing sequence character count
            if (Character.isDigit(c)){
                numBuffer.append(c);
            } else if (Character.isSpaceChar(c)){
                continue;
            } else {
                if (numBuffer.length() == 0){
                    count = 1;
                } else {
                    count = Integer.valueOf(numBuffer.toString());
                }
                numBuffer.setLength(0);
                result.append(String.valueOf(c).repeat(count)); // Adds character based on the number written in front of it
            }
        }
        return result.toString();

    }

    private boolean leftTraversal(){
        // Traverses maze from left to right
        row = leftRow;
        col = leftCol;

        for(int i = 0; i<path.length(); i++){
            if (path.charAt(i) == 'F'){
                if (super.canMoveForward()){
                    super.moveForward();
                } else {
                    return false;
                }
            } else {
                mazeCommandExecutor.executeTraversal(path.charAt(i));
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
        // Traverses maze from right to left

        //Set direction and position to west end
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
            } else {
                mazeCommandExecutor.executeTraversal(path.charAt(i));
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
        //Checks if users input traverses maze from left to right or right to left correctly
        if (leftTraversal()){
            return "Correct path";
        } else if (rightTraversal()){
            return "Correct path";
        } else {
            return "Incorrect path";
        }
    }
}