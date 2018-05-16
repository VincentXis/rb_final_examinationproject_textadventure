package se.nackademin;

import se.nackademin.theWawaAdventure.gameboard.GameBoard;

public class Application {

    public static void main(String[] args) {
//        CommandLineInterface cli = new CommandLineInterface();
//        new TheWawaAdventure(cli).run();
//        Inventory inventory = new Inventory();
//        inventory.addItem(new Bazooka());
//        inventory.addItem(new Lotion());
        GameBoard gameBoard = new GameBoard();
        gameBoard.printMap();
        int[][] array = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = j;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
}
