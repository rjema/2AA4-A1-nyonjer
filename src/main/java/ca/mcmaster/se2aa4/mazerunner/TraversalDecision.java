package ca.mcmaster.se2aa4.mazerunner;

public class TraversalDecision implements TraversalStrategy{
    private final TurnCommandProvider turnCommandProvider;

    public TraversalDecision(TurnCommandProvider turnCommandProvider){
        this.turnCommandProvider = turnCommandProvider;
    }

    public TurnCommand decideCommand(char moveLetter){
        return (moveLetter == 'R') ? turnCommandProvider.getRightCommand() : turnCommandProvider.getLeftCommand();
    }
}