package ca.mcmaster.se2aa4.mazerunner;

public class PathfinderTurnDecision implements PathfinderTurnStrategy{
    private final TurnCommandSource turnCommandSource;

    public PathfinderTurnDecision(TurnCommandSource turnCommandSource){
        this.turnCommandSource = turnCommandSource;
    }

    @Override
    public TurnCommand decideCommand(boolean handOnWall, StringBuffer pathBuffer) {
        if (handOnWall) {
            pathBuffer.append("L");
            return turnCommandSource.getLeftCommand();
        } else {
            pathBuffer.append("RF");
            return turnCommandSource.getRightCommand();
        }
    }
}