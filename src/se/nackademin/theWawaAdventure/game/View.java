package se.nackademin.theWawaAdventure.game;

import se.nackademin.commandline.CommandLineWriter;
import se.nackademin.theWawaAdventure.TheWawaAdventure;
import se.nackademin.theWawaAdventure.game.levels.LevelDrawer;

import java.util.List;

/**
 * This class writes things to the console via the CommandLineInterface class
 */
public class View {
    private LevelDrawer levelDrawer = new LevelDrawer();
    private CommandLineWriter cli;
    private GameBoard gameBoard;
    private String divider = "------------------------------------------------------------------------------------------------------------";

    public View(TheWawaAdventure wawaAdventure) {
        this.cli = wawaAdventure.getCli();
        this.gameBoard = wawaAdventure.getGameBoard();
    }

    public void describeScene() {
        String view = String.format("%s\n\n%s\n",
                divider,
                levelDrawer.drawLevel(gameBoard.getCurrentLevel())
        );
        cli.write(view);
    }

    public void showUI() {
        cli.write(String.format("%s\n%s\n%s\nItems: %s | Targets: %s\n%s\n%s",
                divider,
                showPossibleDirections(),
                divider,
                gameBoard.getPlayer().showInventory(),
                gameBoard.getCurrentLevel().getEnemy().getType(),
                divider,
                "What would you like to do? type 'help' for options.")
        );
    }

    private String showPossibleDirections() {
        List<String> directions = this.gameBoard.getUtil().possibleDirectionStrings(this.gameBoard);
        if (directions.size() == 1)
            return "You can see a path leading to the " + directions.get(0) + " from here";
        StringBuilder message = new StringBuilder("You can see paths leading to the ");
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
