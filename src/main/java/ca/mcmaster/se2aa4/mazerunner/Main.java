package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();

        // Adding maze input and path input options
        options.addOption("i", "input", true, "Maze file to read");
        options.addOption(Option.builder("p")
                .longOpt("path")
                .hasArgs()
                .desc("Potential maze path")
                .build());

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            // Ensure -i is provided with a valid argument
            if (!cmd.hasOption("i")) {
                logger.error("Missing required argument: -i (input file).\nUsage: -i [file path] -p [maze path] (optional)");
                System.err.println("Error: You must specify a maze file using -i [file path].");
                System.exit(1);
            }
            
            String inputFile = cmd.getOptionValue("i");
            if (inputFile == null || inputFile.trim().isEmpty()) {
                logger.error("No file specified after '-i'.");
                System.err.println("Error: Missing file path after '-i'.");
                System.exit(1);
            }
            
            // Ensure no unexpected trailing arguments
            if (!cmd.hasOption("p") && !cmd.getArgList().isEmpty()) {
                logger.error("Unexpected arguments detected! Did you forget to use '-p' before specifying the path?");
                System.err.println("Error: Extra arguments found. Use format: -i [file path] -p [maze path]");
                System.exit(1);
            }
            
            // Ensure -p is not provided without arguments
            if (cmd.hasOption("p") && (cmd.getOptionValues("p") == null || cmd.getOptionValues("p").length == 0)) {
                logger.error("Missing path argument after '-p'.");
                System.err.println("Error: No path provided after '-p'. Use format: -i [file path] -p [maze path]");
                System.exit(1);
            }
            
            // Ensure -i is not provided alone without -p but with extra arguments
            if (cmd.hasOption("i") && cmd.getArgList().size() > 0) {
                logger.error("Unexpected arguments detected after '-i' without '-p'.");
                System.err.println("Error: Extra arguments found after '-i'. Use format: -i [file path] -p [maze path]");
                System.exit(1);
            }

            // Retrieve maze path if provided
            String mazePath = null;
            if (cmd.hasOption("p")) {
                mazePath = String.join(" ", cmd.getOptionValues("p"));
            }

            // Checking for correct maze file
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

        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!/\\");
            logger.error(e.getMessage(), e);
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        logger.info("** End of MazeRunner");
    }
}
