package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.Passage;

public class PathTraverseTest{
    private PathTraverse pathTraverse;
    private Maze maze;
    private Compass compass;
    private String rightPath = "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F";
    private String rightPathReversed = "3F L 4F R 3F";
    private String wrongPath = "F";

    @BeforeEach
    public void setUp() throws Exception {
        maze = new Maze("./examples/tiny.maz.txt");
        compass = new Compass();
        compass.setDirection(Direction.EAST);
        pathTraverse = new PathTraverse(rightPath, maze, compass);
    }
    @Test
    public void testTraverse() {
        assertEquals("Correct path", pathTraverse.traverse());
        pathTraverse = new PathTraverse(rightPathReversed, maze, compass);
        assertEquals("Correct path", pathTraverse.traverse());
        pathTraverse = new PathTraverse(wrongPath, maze, compass);
        assertEquals("Incorrect path", pathTraverse.traverse());
    }
}