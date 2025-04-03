package ca.mcmaster.se2aa4.mazerunner;

public class TurnLeftCommand implements TurnCommand{
    private Compass compass;

    public TurnLeftCommand(Compass compass){
        this.compass = compass;
    }

    public void execute(){
        compass.turnLeft();
    }
}