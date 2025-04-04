package ca.mcmaster.se2aa4.mazerunner;

public class TraversalDecision implements TraversalStrategy{
    private final CommandProvider commandProvider;

    public TraversalDecision(CommandProvider commandProvider){
        this.commandProvider = commandProvider;
    }

    public TurnCommand decideCommand(char moveLetter){
        return (moveLetter == 'R') ? commandProvider.getRightCommand() : commandProvider.getLeftCommand();
    }
}