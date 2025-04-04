package ca.mcmaster.se2aa4.mazerunner;

public class PathfinderDecision implements PathfindingStrategy{
    private final CommandProvider commandProvider;

    public PathfinderDecision(CommandProvider commandProvider){
        this.commandProvider = commandProvider;
    }

    @Override
    public TurnCommand decideCommand(boolean handOnWall, StringBuffer pathBuffer) {
        if (handOnWall) {
            pathBuffer.append("L");
            return commandProvider.getLeftCommand();
        } else {
            pathBuffer.append("RF");
            return commandProvider.getRightCommand();
        }
    }
}