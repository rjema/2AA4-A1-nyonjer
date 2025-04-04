package ca.mcmaster.se2aa4.mazerunner;


public class RightHandPathFinder extends PathMovement{

    public RightHandPathFinder(Maze maze, Compass compass) {
        super(maze, compass); 
        this.row = entry.leftRow(); 
        this.col = entry.leftCol(); 
        this.path = calculatePath(); 
    }

    // Returns the path in a factorized format (with counts for repeated steps)
    public String getPath(){
        return factorisePath();
    }

    // Calculates the path using the right-hand rule
    private String calculatePath() {
        StringBuffer pathBuffer = new StringBuffer(""); 
        
        // Initially moves forward and adds 'F' (for Forward) to the path
        super.moveForward(); 
        pathBuffer.append("F");

        // Continues moving until the exit is found
        while(!entry.isExit(row, col)){
            if (handOnWall() && super.canMoveForward()){
                super.moveForward();
                pathBuffer.append("F");
            } else {
                mazeCommandExecutor.executePathfinding(handOnWall(), pathBuffer);
                if (!handOnWall()){
                    super.moveForward();
                }
            }
        }
        return pathBuffer.toString(); // Returns the calculated path as a string
    }

    // Determines whether the hand is on a wall based on the current direction
    private boolean handOnWall(){
        // Check for wall in the direction the compass is facing
        if (compass.getDirection() == Direction.NORTH){
            return maze.getMaze()[row][col+1] == Passage.WALL;
        } else if (compass.getDirection() == Direction.EAST){
            return maze.getMaze()[row+1][col] == Passage.WALL;
        } else if (compass.getDirection() == Direction.SOUTH){
            return maze.getMaze()[row][col-1] == Passage.WALL;
        } else { // Direction is WEST
            return maze.getMaze()[row-1][col] == Passage.WALL;
        }
    }

    // Factorizes the path by combining consecutive moves into a compact format
    private String factorisePath() {
        if (path == null || path.isEmpty()) {return "";}
        
        StringBuffer result = new StringBuffer(); 
        int count = 1; 
        for (int i = 1; i < path.length(); i++) {
            // If the current step is the same as the previous one, increment the count
            if (path.charAt(i) == path.charAt(i - 1)) {
                count++;
            } else { // If a different step is found, append the count and character to the result
                result.append(count > 1 ? count : "").append(path.charAt(i - 1)).append(" ");
                count = 1; 
            }
        }
        // Append the last step (after exiting the loop)
        result.append(count > 1 ? count : "").append(path.charAt(path.length() - 1));
        return result.toString().trim(); // Return the final factorised path as a string
    } 
}
