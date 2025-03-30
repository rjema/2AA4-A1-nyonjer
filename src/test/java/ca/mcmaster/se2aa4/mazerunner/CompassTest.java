package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.Direction;

public class CompassTest{
    private Compass compass;

    @BeforeEach
    public void setUp(){
        compass = new Compass();
        compass.setDirection(Direction.EAST);
    }
    
    @Test
    public void testTurnLeft(){
        compass.turnLeft();
        assertEquals(Direction.NORTH, compass.getDirection());
    }

    @Test
    public void testTurnRight(){
        compass.turnRight();
        assertEquals(Direction.SOUTH, compass.getDirection());
    }
    @Test
    public void testSetDirection(){
        compass.setDirection(Direction.WEST);
        assertEquals(Direction.WEST, compass.getDirection());
    }
    @Test
    public void testGetDirection(){
        assertEquals(Direction.EAST, compass.getDirection());
    }

}