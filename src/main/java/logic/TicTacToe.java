package logic;

import domain.Board;
import ui.UserInterface;

import java.util.Scanner;

public class TicTacToe {

    private final UserInterface ui;
    private boolean player1_turn;
    private int count;
    public Scanner scanner;
    private final Board board;

    public TicTacToe() {
        player1_turn = true;
        board = new Board(9);
        board.initialize();
        ui = new UserInterface(board);
        ui.start();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (true) {

            ui.printBoard();

            ui.printTurn(player1_turn);

            int position;
            try {
                position = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
                ui.printError();
                continue;
            }

            if (position < 0 || position > 8) {
                ui.printError();
                continue;
            }

            if (board.getMove(position) == ' ') {
                board.addMove(player1_turn, position);
                check();
                player1_turn = !player1_turn;
                count++;
            } else {
                ui.printNotEmpty();
            }
        }
    }

//    public void initializeGameBoard() {
//        for (int i = 0; i < 9; i++) {
//            positions[i] = 0;
//        }
//    }

    public void check() {
        if (player1_turn && ((board.getMove(0) == 'X') && (board.getMove(1) == 'X') && (board.getMove(2) == 'X')
                || ((board.getMove(3) == 'X') && (board.getMove(4) == 'X') && (board.getMove(5) == 'X'))
                || ((board.getMove(6) == 'X') && (board.getMove(7) == 'X') && (board.getMove(8) == 'X'))
                || ((board.getMove(0) == 'X') && (board.getMove(3) == 'X') && (board.getMove(6) == 'X'))
                || ((board.getMove(1) == 'X') && (board.getMove(4) == 'X') && (board.getMove(7) == 'X'))
                || ((board.getMove(2) == 'X') && (board.getMove(5) == 'X') && (board.getMove(8) == 'X'))
                || ((board.getMove(0) == 'X') && (board.getMove(4) == 'X') && (board.getMove(8) == 'X'))
                || ((board.getMove(6) == 'X') && (board.getMove(4) == 'X') && (board.getMove(2) == 'X'))
        ))
        {
            ui.printBoard();
            ui.printWinner(player1_turn);
            System.exit(0);

        } else if (((board.getMove(0) == 'O') && (board.getMove(1) == 'O') && (board.getMove(2) == 'O')
                || ((board.getMove(3) == 'O') && (board.getMove(4) == 'O') && (board.getMove(5) == 'O'))
                || ((board.getMove(6) == 'O') && (board.getMove(7) == 'O') && (board.getMove(8) == 'O'))
                || ((board.getMove(0) == 'O') && (board.getMove(3) == 'O') && (board.getMove(6) == 'O'))
                || ((board.getMove(1) == 'O') && (board.getMove(4) == 'O') && (board.getMove(7) == 'O'))
                || ((board.getMove(2) == 'O') && (board.getMove(5) == 'O') && (board.getMove(8) == 'O'))
                || ((board.getMove(0) == 'O') && (board.getMove(4) == 'O') && (board.getMove(8) == 'O'))
                || ((board.getMove(6) == 'O') && (board.getMove(4) == 'O') && (board.getMove(2) == 'O'))
        )) {
            ui.printBoard();
            ui.printWinner(player1_turn);
            System.exit(0);
        }


        if (count == 8) {
            ui.printBoard();
            ui.printDraw();
            System.exit(0);
        }
    }
}