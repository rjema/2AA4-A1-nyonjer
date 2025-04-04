package ca.mcmaster.se2aa4.mazerunner;
// unused
public class CommandFactory{
    private final TurnCommand leftTurnCommand;
    private final TurnCommand rightTurnCommand;

    public CommandFactory(Compass compass){
        this.leftTurnCommand = new TurnLeftCommand(compass);
        this.rightTurnCommand = new TurnRightCommand(compass);
    }
    public TurnCommand createTraverseCommand(char moveLetter, Compass compass){
        return moveLetter == 'R'? new TurnRightCommand(compass) : new TurnLeftCommand(compass);
    }

    public TurnCommand createPathfinderCommand(boolean handOnWall, StringBuffer pathBuffer, Compass compass){
        if (handOnWall){
            pathBuffer.append("L");
            return new TurnLeftCommand(compass);
        } else {
            pathBuffer.append("RF");
            return new TurnRightCommand(compass);
        }
    }
}