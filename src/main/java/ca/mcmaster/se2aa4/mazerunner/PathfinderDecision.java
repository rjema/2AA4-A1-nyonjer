package ca.mcmaster.se2aa4.mazerunner;

public class PathfinderDecision implements PathfindingStrategy{
    private final TurnCommandProvider turnCommandProvider;

    public PathfinderDecision(TurnCommandProvider turnCommandProvider){
        this.turnCommandProvider = turnCommandProvider;
    }

    @Override
    public TurnCommand decideCommand(boolean handOnWall, StringBuffer pathBuffer) {
        if (handOnWall) {
            pathBuffer.append("L");
            return turnCommandProvider.getLeftCommand();
        } else {
            pathBuffer.append("RF");
            return turnCommandProvider.getRightCommand();
        }
    }
}