package ca.mcmaster.se2aa4.mazerunner;

public interface PathfinderTurnStrategy {
    TurnCommand decideCommand(boolean handOnWall, StringBuffer pathBuffer);
}