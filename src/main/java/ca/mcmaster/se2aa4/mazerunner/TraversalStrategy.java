package ca.mcmaster.se2aa4.mazerunner;

public interface TraversalStrategy {
    TurnCommand decideCommand(char moveLetter);
    }