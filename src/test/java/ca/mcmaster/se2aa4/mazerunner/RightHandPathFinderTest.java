package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RightHandPathFinderTest{
    private RightHandPathFinder pathFinder;
    private Maze maze;
    private Compass compass;
    private String expectedPath;

    @BeforeEach
    public void setUp() throws Exception{
        maze = new Maze("./examples/tiny.maz.txt");
        compass = new Compass();
        compass.setDirection(Direction.EAST);
        expectedPath = "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F";
        pathFinder = new RightHandPathFinder(maze, compass);
    }
    @Test
    public void testGetPath() {
        assertEquals(expectedPath, pathFinder.getPath());
    }
}