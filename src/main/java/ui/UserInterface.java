package ui;

public class UserInterface {

    public Integer[] positions;

    public UserInterface(Integer[] positions) {
        this.positions = positions;
    }

    public void start() {

        System.out.println();
        System.out.println("       TIC TAC TOE GAME!");
        System.out.println();
        System.out.println("Developed by Patricio T. Rinaldi");

    }

    public void printBoard() {
        System.out.println();
        System.out.println("         —————————————");
        for (int i = 0; i < 9; i++) {

            if (i == 0 || i == 3 || i == 6){
                System.out.print("         | ");
            }


            if (positions[i] == 0) {
                System.out.print(i+1);
            } else if (positions[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }

            if (i == 2 || i == 5 || i == 8) {
                System.out.print(" |\n");
                System.out.println("         —————————————");
            } else {
                System.out.print(" - ");
            }
        }
    }

    public void printTurn(boolean player1_turn) {
        if (player1_turn) {
            System.out.println("\n         Player 1 turn.");
            System.out.print("        Enter next move: ");
        } else {
            System.out.println("\n         Player 2 turn.");
            System.out.print("        Enter next move: ");
        }
    }

    public void printWinner(boolean player1_turn) {
        if(player1_turn) {
            System.out.println("\n       ¡¡PLAYER 1 WIN!!");
        } else {
            System.out.println("\n       ¡¡PLAYER 2 WIN!!");
        }
    }

    public void printDraw() {
        System.out.println("\n        ¡¡IT'S A DRAW!!");
    }

    public void printError() {
        System.out.println("\nPlease enter a valid position: (1-9)");
    }

    public void printNotEmpty() {
        System.out.println("\n  Please enter an empty position.");
    }
}
