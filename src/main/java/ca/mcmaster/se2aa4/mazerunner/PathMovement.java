package ca.mcmaster.se2aa4.mazerunner;

public abstract class PathMovement{
    protected String path;
    protected Maze maze;
    protected MazeEntry entry;
    protected Compass compass;
    protected CommandProvider commandProvider;
    protected MazeCommandExecutor mazeCommandExecutor;
    protected int row;
    protected int col;

    public PathMovement(Maze maze, Compass compass){
        this.maze = maze;
        this.compass = compass;
        this.entry = new MazeEntry(maze);
        this.commandProvider = new CommandProvider(compass);
        this.mazeCommandExecutor = new MazeCommandExecutor(new TraversalDecision(commandProvider), new PathfinderDecision(commandProvider));
    }

    protected boolean canMoveForward(){
        //Checks if forward tile is a passage depending on compass direction
        if (compass.getDirection() == Direction.NORTH){
            return (row != 0) && (maze.getMaze()[row-1][col] == Passage.PASS);
        
        } else if (compass.getDirection() == Direction.EAST){
            return (col != maze.width()-1) && (maze.getMaze()[row][col+1] == Passage.PASS);
        
        } else if (compass.getDirection() == Direction.SOUTH){
            return (row != maze.height()-1) && (maze.getMaze()[row+1][col] == Passage.PASS);
        
        } else {
            return (col != 0) && (maze.getMaze()[row][col-1] == Passage.PASS);
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