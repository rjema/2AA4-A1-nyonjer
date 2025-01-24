package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Maze{
    private int[][] maze;
    private int numRows, numCols;

    public Maze(String mazeFile){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));
            String line;
            int row = 0;
            int cols = 0;

            
            while ((line = reader.readLine()) != null) {
                row++;
                cols = line.length();
            }
            reader.close();
            maze = new int[row][cols];

            this.numRows = row;
            this.numCols = cols;

            row = 0;

            reader = new BufferedReader(new FileReader(mazeFile));

            //Adding to 2D array that represents the maze. 1 is a wall, 0 is a path
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        maze[row][idx] = 1;
                    } else if (line.charAt(idx) == ' ') {
                        maze[row][idx] = 0;
                    }
                }
                row++;
            } 
        } catch(Exception e) {
            System.out.println("An error has occurred");
        }
    }

    public int[] getEntry(){
        for(int i = 0; i < maze.length; i++){
            if(maze[i][0] == 0){
                int entry[] = {i, 0};
                return entry;
            }
        }
        return null;
    }

    public int[] getExit(){
        for(int i = 0; i < maze.length; i++){
            if(maze[i][maze[0].length - 1] == 0){
                int exit[] = {i, maze[0].length - 1};
                return exit;
            }
        }
        return null;

    }

    public int[][] getMaze(){
        return this.maze;
    }

    public String getPath(){
        return "5F";
    }
}