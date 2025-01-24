package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", "input", true, "Maze file to read");
        options.addOption("p", "path", true, "Potential maze path");

        CommandLineParser parser = new DefaultParser();    

        try {

            CommandLine cmd = parser.parse(options, args);

            String inputFile = cmd.getOptionValue("i");
            String mazePath = cmd.getOptionValue("p");

            logger.info("**** Reading the maze from file " + inputFile);
            // BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            // String line;
            // logger.info(mazePath);
            // while ((line = reader.readLine()) != null) {
            //     for (int idx = 0; idx < line.length(); idx++) {
            //         if (line.charAt(idx) == '#') {
            //             System.out.print("WALL ");
            //         } else if (line.charAt(idx) == ' ') {
            //             System.out.print("PASS ");
            //         }
            //     }
            //     System.out.println(System.lineSeparator());
            // }
            Maze maze = new Maze(inputFile);

            if (mazePath == null) {
                logger.info("**** Computing path");
                logger.info("Path: " + maze.getPath());
            } else {
                logger.info("**** Verifying path");
                Path path = new Path(maze, mazePath);
                logger.info("Unknown.");
            }

        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
            logger.error(e.getMessage());
        }
        logger.info("** End of MazeRunner");

    }
}
