package ui;

import domain.Board;
import domain.Player;

public class UserInterface {

    public Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    public void start() {

        System.out.println();
        System.out.println("       TIC TAC TOE GAME!");
        System.out.println();
        System.out.println("Developed by Patricio T. Rinaldi");

    }

    public void printBoard() {
        System.out.println(board.toString());
    }

    public void printTurn(boolean player1_turn) {
        if (player1_turn) {
            System.out.println("\n          Player turn");
            System.out.print("        Enter next move: ");
        } else {
            System.out.println("\n         Computer turn:\n");
        }
    }

    public void printWinner(boolean player1_turn) {
        if(player1_turn) {
            System.out.println("\n       ¡¡PLAYER 1 WINS!!");
        } else {
            System.out.println("\n       ¡¡COMPUTER WINS!!");
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

    public void printPlayAgain() {
        System.out.print("\nPlay Again? (Y-y) (N-n): ");
    }

    public void printGoodbye(Player player1, Player player2) {
        if (player1.getWins() == player2.getWins()) {
            System.out.println("\n      ¡¡IT'S A DRAW!!");
        } else if (player1.getWins() > player2.getWins()) {
            System.out.println("\n ¡¡PLAYER 1 WINS THE GAME!!");
        } else {
            System.out.println("\n ¡¡COMPUTER WINS THE GAME!!");
        }
        System.out.println("\n Thank you for playing! Bye!");
    }

    public void askSymbols(boolean player1_turn) {
        if (player1_turn) {
            System.out.print("\n Enter symbol for player 1: ");
        } else {
            System.out.print("\n Enter symbol for player 2: ");
        }
    }

    public void printScore(Player player1, Player player2) {
        System.out.println("\n Score:");
        System.out.println("\n Player 1: " + player1.getWins() + " wins");
        System.out.println("\n Computer: " + player2.getWins() + " wins");
    }

    public void askDifficulty() {
        System.out.println("\n Choose difficulty: \n1 - Easy \n2 - Hard");
        System.out.print("> ");
    }
}
