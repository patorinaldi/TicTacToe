package logic;

import domain.AI;
import domain.Board;
import domain.Player;
import ui.UserInterface;

import java.util.Scanner;

public class TicTacToe {

    private UserInterface ui;
    private boolean player1_turn;
    public Scanner scanner;
    private final Board board;
    private Player player1;
    private AI ai;
    private final int difficulty;

    public TicTacToe() {
        this.ui = new UserInterface();
        this.scanner = new Scanner(System.in);
        board = new Board(3);
        board.initialize();
        ui.setBoard(board);
        ui.start();
        player1_turn = true;
        ui.askDifficulty();
        difficulty = Integer.parseInt(scanner.nextLine());
        getSymbols();

        board.setPlayer1(player1);
        board.setPlayer2(ai);
    }

    public void getSymbols() {
        for (int i = 0; i < 2; i++) {
            ui.askSymbols(player1_turn);
            String input = scanner.nextLine();
            if (player1_turn){
                player1 = new Player(input.charAt(0));
                player1_turn = false;
            } else {
                if (difficulty == 1) {
                    ai = new AI(board, true, input.charAt(0));
                } else {
                    ai = new AI(board, false, input.charAt(0));
                }
                player1_turn = true;
            }
        }
    }

    public void startGame() {

        while (true) {


            ui.printBoard();

            if (player1_turn) {

                while (true) {
                    ui.printTurn(player1_turn);

                    int position;
                    try {
                        position = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        ui.printError();
                        continue;
                    }
                    if (position < 1 || position > 9) {
                        ui.printError();
                        continue;
                    }

                    if (board.getMove(position) == ' ') {

                        board.addMove(player1.getSymbol(), position);
                        break;
                    } else {
                        ui.printNotEmpty();
                    }
                }
            } else {
                ui.printTurn(player1_turn);
                int position = ai.move();
                board.addMove(ai.getSymbol(), position);
            }

            if (board.checkGameOver() == 0) {
                ui.printBoard();
                ui.printDraw();
                ui.printScore(player1, ai);
                playAgain();
            } else if (board.checkGameOver() == 1 || board.checkGameOver() == -1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                roundWinner();
                ui.printScore(player1, ai);
                playAgain();
            }
            player1_turn = !player1_turn;

        }
    }

    public void playAgain() {
        ui.printPlayAgain();
        String input = scanner.nextLine();
        if (input.length() > 1) {
            ui.printPlayAgain();
        } else if (input.equalsIgnoreCase("y")) {
            board.initialize();
            player1_turn = !player1_turn;
            startGame();
        } else if (input.equalsIgnoreCase("n")) {
            ui.printGoodbye(player1, ai);
            System.exit(0);
        }

    }

    public void roundWinner() {
        if (player1_turn) {
            player1.addWin();
        } else {
            ai.addWin();
        }
    }

}