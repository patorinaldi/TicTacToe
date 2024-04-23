package ui;

import domain.Board;

public class UserInterface {

    public Board board;

    public UserInterface(Board board) {
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
