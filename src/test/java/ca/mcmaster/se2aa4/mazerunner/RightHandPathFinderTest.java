package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RightHandPathFinderTest{
    private RightHandPathFinder pathFinder;
    private String expectedPath;

    @BeforeEach
    public void setUp() throws Exception{
        Maze maze = new Maze("./examples/tiny.maz.txt");
        Compass compass = new Compass();
        compass.setDirection(Direction.EAST);
        expectedPath = "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F";
        pathFinder = new RightHandPathFinder(maze, compass);
    }
    @Test
    public void testGetPath() {
        assertEquals(expectedPath, pathFinder.getPath());
    }
}