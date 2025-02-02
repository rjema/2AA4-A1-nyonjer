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
        return leftRow;
    }
    public int leftCol(){
        return leftCol;
    }

    public int rightRow(){
        return rightRow;
    }

    public int rightCol(){
        return rightCol;
    }

    private void findLeft(){
        for (int i = 0; i < maze.height(); i++) {
            if (maze.getMaze()[i][0] == Passage.PASS) {
                leftRow = i;
            }
        }
    }

    private void findRight(){
        for (int i = 0; i < maze.height(); i++) {
            if (maze.getMaze()[i][maze.width()-1] == Passage.PASS) {
                rightRow = i;
            }
        }
    }

    public boolean isExit(int row, int col){
        return (row == rightRow && col == rightCol);
    }

}