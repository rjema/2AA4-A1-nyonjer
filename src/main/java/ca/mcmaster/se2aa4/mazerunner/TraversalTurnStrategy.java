package ca.mcmaster.se2aa4.mazerunner;

public interface TraversalTurnStrategy {
    TurnCommand decideCommand(char moveLetter);
    }