package se.nackademin.theWawaAdventure.game;

import se.nackademin.commandline.CommandLineInterface;
import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.actions.Action;
import se.nackademin.theWawaAdventure.game.levels.Level;
import se.nackademin.theWawaAdventure.game.levels.LevelDrawer;

import java.util.List;

public class View {
    private LevelDrawer levelDrawer = new LevelDrawer();
    private CommandLineInterface cli;
    private GameBoard gameBoard;
    private String whatToDo = "What would you like to do?";

    public View(TheWawaAdventure wawaAdventure) {
        this.cli = wawaAdventure.getCli();
        this.gameBoard = wawaAdventure.getGameBoard();
    }

    public void describeScene(Level currentLevel) {
        String divider = "\n******************************************************";
        String view = String.format("%s\n%s\n%s\n%s\n%s\n%s",
                divider,
                currentLevel,
                divider,
                showPossibleDirections(),
                divider,
                whatToDo
        );
    }

    private String showPossibleDirections() {
        StringBuilder message;
        List<String> directions = this.gameBoard.possibleDirections();
        if (directions.size() == 1)
            return "You can see a path leading to the" + directions.get(0) + " from here";
        message = new StringBuilder("You can see paths leading to the ");
        while (directions.size() > 0) {
            if (directions.size() == 1)
                message.append(" and ").append(directions.remove(0)).append(" from here");
            else
                message.append(directions.remove(0));
        }
        return message.toString();
    }

    public void writeMessage(String message) {
        cli.write(message);
    }
}
