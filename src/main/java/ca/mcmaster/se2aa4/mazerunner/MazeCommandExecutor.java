package ca.mcmaster.se2aa4.mazerunner;

public class MazeCommandExecutor {
    private final TraversalTurnStrategy traversalTurnStrategy;
    private final PathfinderTurnStrategy pathfinderTurnStrategy;

    public MazeCommandExecutor(TraversalTurnStrategy traversalTurnStrategy, PathfinderTurnStrategy pathfinderTurnStrategy) {
        this.traversalTurnStrategy = traversalTurnStrategy;
        this.pathfinderTurnStrategy = pathfinderTurnStrategy;
    }

    public void executeTraversal(char moveLetter) {
        TurnCommand command = traversalTurnStrategy.decideCommand(moveLetter);
        command.execute();
    }
    public void executePathfinding(boolean handOnWall, StringBuffer pathBuffer) {
        TurnCommand command = pathfinderTurnStrategy.decideCommand(handOnWall, pathBuffer);
        command.execute();
    }
}