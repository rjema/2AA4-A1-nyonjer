package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Passage;

public class MazeEntry{
    private int leftRow, leftCol, rightRow, rightCol;
    private Maze maze;

    public MazeEntry(Maze maze){
        this.maze = maze;
        leftCol = 0;
        rightCol = maze.width()-1;
        findLeft();
        findRight();
    }

    public int leftRow(){
        // Returns East entry row index
        return leftRow;
    }
    public int leftCol(){
        // Returns East entry column index
        return leftCol;
    }

    public int rightRow(){
        // Returns West entry row index
        return rightRow;
    }

    public int rightCol(){
        // Returns West entry column index
        return rightCol;
    }

    private void findLeft(){
        // Finds East entry point
        for (int i = 0; i < maze.height(); i++) {
            if (maze.getMaze()[i][0] == Passage.PASS) {
                leftRow = i;
            }
        }
    }

    private void findRight(){
        // Finds West entry point
        for (int i = 0; i < maze.height(); i++) {
            if (maze.getMaze()[i][maze.width()-1] == Passage.PASS) {
                rightRow = i;
            }
        }
    }

    //Check if position is at West or East entry point
    public boolean isExit(int row, int col){
        return (row == rightRow && col == rightCol) || (row == leftRow && col == leftCol);
    }

}