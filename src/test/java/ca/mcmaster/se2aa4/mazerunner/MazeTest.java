package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.Passage;

public class MazeTest{
    private Passage[][] mazeRep = {
    {Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL},
    {Passage.WALL, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS},
    {Passage.WALL, Passage.WALL, Passage.WALL, Passage.PASS, Passage.WALL, Passage.WALL, Passage.WALL},
    {Passage.WALL, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.WALL},
    {Passage.WALL, Passage.WALL, Passage.WALL, Passage.PASS, Passage.WALL, Passage.WALL, Passage.WALL},
    {Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.PASS, Passage.WALL},
    {Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL, Passage.WALL}};

    private int numRows = 7;
    private int numCols = 7;
    private Maze mazeObj;

    @BeforeEach
    public void setUp() throws Exception {
        String mazeFile = "./examples/tiny.maz.txt";
        mazeObj = new Maze(mazeFile);
    }

    @Test
    public void testGetMaze(){
        assertArrayEquals(mazeRep, mazeObj.getMaze());
    }

    @Test
    public void testWidth(){
        assertEquals(numCols, mazeObj.width());
    }
    @Test
    public void testHeight(){
        assertEquals(numRows, mazeObj.height());
    }

}