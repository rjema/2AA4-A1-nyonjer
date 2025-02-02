package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {
    private Border[][] maze;
    private int numRows, numCols;

    public Maze(String mazeFile) {
        try {
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
            maze = new Border[numRows][numCols];

            // Reopen file to read maze content
            reader = new BufferedReader(new FileReader(mazeFile));
            row = 0;

            // Initialize the maze
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < numCols; idx++) {
                    if (idx < line.length() && line.charAt(idx) == '#') {
                        maze[row][idx] = Border.WALL;
                    } else {
                        maze[row][idx] = Border.PASS;
                    }
                }
                row++;
            }
            reader.close();

            // Print the maze for debugging
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("An error has occurred while reading the maze file.");
        }
    }

    public int[] getEntry() {
        for (int i = 0; i < numRows; i++) {
            if (maze[i][0] == Border.PASS) {
                return new int[]{i, 0};
            }
        }
        return null;
    }

    public int[] getExit() {
        for (int i = 0; i < numRows; i++) {
            if (maze[i][numCols - 1] == Border.PASS) {
                return new int[]{i, numCols - 1};
            }
        }
        return null;
    }

    public Border[][] getMaze() {
        return this.maze;
    }

    public String getPath() {
        return "5F";
    }

    enum Border {
        WALL, PASS;
    }
}