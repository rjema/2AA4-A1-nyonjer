package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

// Uses straight maze for the MVP

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();

        //Adding maze input and path input options
        options.addOption("i", "input", true, "Maze file to read");
        options.addOption("p", "path", true, "Potential maze path");

        CommandLineParser parser = new DefaultParser();    

        try {

            CommandLine cmd = parser.parse(options, args);

            String inputFile = cmd.getOptionValue("i");
            String mazePath = cmd.getOptionValue("p");

            //Checking for correct maze file
            if (inputFile.equals("examples/straight.maz.txt")) {
                logger.info("**** Reading the maze from file " + inputFile);

                Maze maze = new Maze(inputFile);

                if (mazePath == null) {
                    logger.info("**** Computing path");
                    logger.info(maze.getPath());
                } else {
                    logger.info("**** Verifying path");
                    Path path = new Path(maze, mazePath);
                    logger.info(path.isValid());
                }
            } else {
                logger.error("**** Invalid maze file. Use straight maze and ensure the file path is correct.");
            }


        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
            logger.error(e.getMessage());
        }
        logger.info("** End of MazeRunner");

    }
}
