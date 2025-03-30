package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeEntryTest{
    private MazeEntry mazeEntry;
    private int leftRow = 5;
    private int leftCol = 0;
    private int rightRow = 1;
    private int rightCol = 6;
    

    @BeforeEach
    public void setUp() throws Exception {
        Maze maze = new Maze("./examples/tiny.maz.txt");
        mazeEntry = new MazeEntry(maze);
    }

    @Test
    public void testLeftRow() {
        assertEquals(leftRow, mazeEntry.leftRow());
    }
    @Test
    public void testLeftCol() {
        assertEquals(leftCol, mazeEntry.leftCol());
    }
    @Test
    public void testRightRow() {
        assertEquals(rightRow, mazeEntry.rightRow());
    }
    @Test
    public void testRightCol() {
        assertEquals(rightCol, mazeEntry.rightCol());
    }
    @Test
    public void testIsExit() {
        assertTrue(mazeEntry.isExit(leftRow, leftCol));
        assertTrue(mazeEntry.isExit(rightRow, rightCol));
    }
}
