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


    private String getCanonPath(){

        String factorPath[] = path.split(" ");
        StringBuffer cPath = new StringBuffer("");

        for (int i=0; i < factorPath.length; i++){
            if (factorPath[i].charAt(0) >= '2' && factorPath[i].charAt(0) <= '9'){
                int count = Character.getNumericValue(factorPath[i].charAt(0)); 

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