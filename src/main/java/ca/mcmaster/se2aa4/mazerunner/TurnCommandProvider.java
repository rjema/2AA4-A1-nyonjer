package ca.mcmaster.se2aa4.mazerunner;

public class TurnCommandProvider implements TurnCommandSource{
    private final TurnCommand leftCommand;
    private final TurnCommand rightCommand;

    public TurnCommandProvider(TurnCommand leftCommand, TurnCommand rightCommand){
        this.leftCommand = leftCommand;
        this.rightCommand = rightCommand;
    }

    public TurnCommand getLeftCommand(){
        return leftCommand;
    }
    public TurnCommand getRightCommand(){
        return rightCommand;
    }
}