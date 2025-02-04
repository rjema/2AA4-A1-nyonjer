package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Passage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Maze {
    private Passage[][] maze;
    private int numRows, numCols;

    public Maze(String mazeFile) throws Exception{
        loadMaze(mazeFile);
    }

    private void loadMaze(String mazeFile) throws Exception{
        File file = new File(mazeFile);
        if (!file.exists()){
            throw new Exception("Invalid maze file provided.");
        }
        
        BufferedReader reader = new BufferedReader(new FileReader(mazeFile));
        String line;
        int row = 0, cols = 0;

        // Determine the dimensions of the maze
        while ((line = reader.readLine()) != null) {
            row++;
            cols = Math.max(cols, line.length());
        }
        reader.close();

        this.numRows = row;
        this.numCols = cols;
        maze = new Passage[numRows][numCols];

        // Reopen file to read maze content
        reader = new BufferedReader(new FileReader(mazeFile));
        row = 0;

        // Initialize the maze
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < numCols; idx++) {
                if (idx < line.length() && line.charAt(idx) == '#') {
                    maze[row][idx] = Passage.WALL;
                } else {
                    maze[row][idx] = Passage.PASS;
                }
            }
            row++;
        }
        reader.close();
    }
    
    public Passage[][] getMaze() {
        return this.maze;
    }

    public int width() {
        return numCols;
    }
    public int height() {
        return numRows;
    }

}