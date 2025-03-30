package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.Direction;

public class DirectionTest{
    private Direction direction;

    @BeforeEach
    public void setUp(){
        direction = Direction.NORTH;
    }

    @Test
    public void testLeft(){
        direction = direction.left();
        assertEquals(Direction.WEST, direction);
    }

    @Test
    public void testRight(){
        direction = direction.right();
        assertEquals(Direction.EAST, direction);
    }

}