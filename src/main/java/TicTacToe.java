import ui.UserInterface;
import java.util.Scanner;

public class TicTacToe {

    public Integer[] positions;
    private UserInterface ui;
    private boolean player1_turn;
    private int count;
    public Scanner scanner;

    public TicTacToe() {
        player1_turn = true;
        positions = new Integer[9];
        initializeGameBoard();
        ui = new UserInterface(positions);
        ui.start();
        this.scanner = new Scanner(System.in);

    }

    public void startGame() {
        while(true) {

            ui.printBoard();

            ui.printTurn(player1_turn);

            int position = 0;
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

            if (player1_turn && positions[position] == 0) {
                positions[position] = 1;
                check();
                player1_turn = false;
                count++;
            } else if (!player1_turn && positions[position] == 0){
                positions[position] = 2;
                check();
                player1_turn = true;
                count++;
            } else {
                ui.printNotEmpty();
            }
        }
    }

    public void initializeGameBoard() {
        for (int i = 0; i < 9; i++) {
            positions[i] = 0;
        }
    }

    public void check() {
        if(player1_turn){
            if ((positions[0] == 1) && (positions[1] == 1) && positions[2] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[3] == 1) && (positions[4] == 1) && positions[5] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[6] == 1) && (positions[7] == 1) && positions[8] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[0] == 1) && (positions[3] == 1) && positions[6] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[1] == 1) && (positions[4] == 1) && positions[7] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[2] == 1) && (positions[5] == 1) && positions[8] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[0] == 1) && (positions[4] == 1) && positions[8] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            }  else if ((positions[6] == 1) && (positions[4] == 1) && positions[2] == 1) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            }
        } else {
            if ((positions[0] == 2) && (positions[1] == 2) && positions[2] == 2) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[3] == 2) && (positions[4] == 2) && (positions[5] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[6] == 2) && (positions[7] == 2) && (positions[8] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[0] == 2) && (positions[3] == 2) && (positions[6] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[1] == 2) && (positions[4] == 2) && (positions[7] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[2] == 2) && (positions[5] == 2) && (positions[8] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[0] == 2) && (positions[4] == 2) && (positions[8] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            } else if ((positions[6] == 2) && (positions[4] == 2) && (positions[2] == 2)) {
                ui.printBoard();
                ui.printWinner(player1_turn);
                System.exit(0);
            }

        }

        if (count == 8) {
            ui.printBoard();
            ui.printDraw();
            System.exit(0);
        }
    }

}
