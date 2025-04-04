package ca.mcmaster.se2aa4.mazerunner;

public class TraversalTurnDecision implements TraversalTurnStrategy{
    private final TurnCommandProvider turnCommandProvider;

    public TraversalTurnDecision(TurnCommandProvider turnCommandProvider){
        this.turnCommandProvider = turnCommandProvider;
    }

    public TurnCommand decideCommand(char moveLetter){
        return (moveLetter == 'R') ? turnCommandProvider.getRightCommand() : turnCommandProvider.getLeftCommand();
    }
}