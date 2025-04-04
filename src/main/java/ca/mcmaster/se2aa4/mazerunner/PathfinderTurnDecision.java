package ca.mcmaster.se2aa4.mazerunner;

public class PathfinderTurnDecision implements PathfinderTurnStrategy{
    private final TurnCommandProvider turnCommandProvider;

    public PathfinderTurnDecision(TurnCommandProvider turnCommandProvider){
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