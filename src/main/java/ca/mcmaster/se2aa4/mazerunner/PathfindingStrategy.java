package ca.mcmaster.se2aa4.mazerunner;

public interface PathfindingStrategy {
    TurnCommand decideCommand(boolean handOnWall, StringBuffer pathBuffer);
}