package ca.mcmaster.se2aa4.mazerunner;

public class TraversalTurnDecision implements TraversalTurnStrategy{
    private final TurnCommandSource turnCommandSource;

    public TraversalTurnDecision(TurnCommandSource turnCommandSource){
        this.turnCommandSource = turnCommandSource;
    }

    public TurnCommand decideCommand(char moveLetter){
        return (moveLetter == 'R') ? turnCommandSource.getRightCommand() : turnCommandSource.getLeftCommand();
    }
}