package ca.mcmaster.se2aa4.mazerunner;

public class CommandFactory{
    private TurnLeftCommand turnLeft;
    private TurnRightCommand turnRight;

    public CommandFactory(Compass compass){
        this.turnLeft = new TurnLeftCommand(compass);
        this.turnRight = new TurnRightCommand(compass);
    }

    public TurnCommand getTraverseCommand(char moveLetter){
        if (moveLetter == 'R'){
            return turnRight;
        } else {
            return turnLeft;
        }
    }

    public TurnCommand getPathfinderCommand(boolean handOnWall, StringBuffer pathBuffer){
        if (handOnWall){
            pathBuffer.append("L");
            return turnLeft;
        } else {
            pathBuffer.append("RF");
            return turnRight;
        }
    }
}