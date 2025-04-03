package ca.mcmaster.se2aa4.mazerunner;

public class TurnRightCommand implements TurnCommand{
    private Compass compass;

    public TurnRightCommand(Compass compass){
        this.compass = compass;
    }

    public void execute(){
        compass.turnRight();
    }
}