package ca.mcmaster.se2aa4.mazerunner;

public class CommandProvider{
    private final TurnCommand leftCommand;
    private final TurnCommand rightCommand;

    public CommandProvider(Compass compass){
        this.leftCommand = new TurnLeftCommand(compass);
        this.rightCommand = new TurnRightCommand(compass);
    }

    public TurnCommand getLeftCommand(){
        return leftCommand;
    }
    public TurnCommand getRightCommand(){
        return rightCommand;
    }
}