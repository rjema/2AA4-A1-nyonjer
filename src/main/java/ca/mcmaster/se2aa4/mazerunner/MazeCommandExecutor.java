package ca.mcmaster.se2aa4.mazerunner;

public class MazeCommandExecutor {
    private final TraversalStrategy traversalStrategy;
    private final PathfindingStrategy pathfindingStrategy;

    public MazeCommandExecutor(TraversalStrategy traversalStrategy, PathfindingStrategy pathfindingStrategy) {
        this.traversalStrategy = traversalStrategy;
        this.pathfindingStrategy = pathfindingStrategy;
    }

    public void executeTraversal(char moveLetter) {
        TurnCommand command = traversalStrategy.decideCommand(moveLetter);
        command.execute();
    }
    public void executePathfinding(boolean handOnWall, StringBuffer pathBuffer) {
        TurnCommand command = pathfindingStrategy.decideCommand(handOnWall, pathBuffer);
        command.execute();
    }
}