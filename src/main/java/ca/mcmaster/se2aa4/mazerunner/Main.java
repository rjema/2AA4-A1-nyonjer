package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import ca.mcmaster.se2aa4.mazerunner.Direction;

// Uses straight maze for the MVP

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();

        //Adding maze input and path input options
        options.addOption("i", "input", true, "Maze file to read");
        
        // Change: Using hasArgs() to capture multiple arguments for the path
        options.addOption(Option.builder("p")
                .longOpt("path")
                .hasArgs()  // Capture multiple arguments after -p
                .desc("Potential maze path")
                .build());

        CommandLineParser parser = new DefaultParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            String inputFile = cmd.getOptionValue("i");

            // Change: Collect all arguments after -p as an array
            String[] mazePathArgs = cmd.getOptionValues("p");

            // Combine them into a single string, if necessary
            String mazePath = (mazePathArgs != null) ? String.join(" ", mazePathArgs) : null;

            //Checking for correct maze file
            logger.info("**** Reading the maze from file " + inputFile);

            Maze maze = new Maze(inputFile);
            Compass compass = new Compass();
            RightHandPathFinder pathFinder = new RightHandPathFinder(maze, compass);

            if (mazePath == null) {
                logger.info("**** Computing path");
                System.out.println(pathFinder.getPath());
            } else {

                PathTraverse pathTraverse = new PathTraverse(mazePath, maze, compass);
                logger.info("**** Verifying path");
                System.out.println(pathTraverse.traverse());
            }

        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");

            // Logging more details
            logger.error(e.getMessage(), e);
        }
        logger.info("** End of MazeRunner");

    }
}
