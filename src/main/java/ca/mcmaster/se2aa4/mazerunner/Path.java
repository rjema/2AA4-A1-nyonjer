package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Path{
    private Maze maze;
    private String path;

    public Path(Maze maze, String path){
        if (!path.matches("^[0-9FLR]+$")){
            throw new IllegalArgumentException("Invalid path characters. F, L, R and numerical characters only.");
        }
        this.maze = maze;
        this.path = path;
    }

    public String isValid(){

        int r = maze.getEntry()[0];
        int c = maze.getEntry()[1];

        int exitRow = maze.getExit()[0];
        int exitCol = maze.getExit()[1];

        int i = 0;

        String expandedPath = getCanonPath();

        if (expandedPath.length() != exitCol+1){
            return "Incorrect path";
        }

        while (i < expandedPath.length() && r <= exitRow && c <= exitCol){

            if (expandedPath.charAt(i) == 'F'){
                i++;
            } else {
                return "Incorrect path";
            }

            if (r == exitRow && c == exitCol){
                return "Correct path";
            }
            c++; 
        }

        return "Incorrect path";
    }

    private String getCanonPath(){

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

        return cPath.toString();
    }
}