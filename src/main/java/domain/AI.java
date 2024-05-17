package domain;

import java.util.Random;

public class AI extends Player {

    private Board board;
    private boolean difficultyEasy;

    public AI(Board board, boolean difficultyEasy, char symbol) {
        super(symbol);
        this.board = board;
        this.difficultyEasy = difficultyEasy;
    }

    public int move() {
        int bestMove = 0;
        int bestScore = 2;

        int random = new Random().nextInt(2);
        if (difficultyEasy && random == 1) {

            do {

                bestMove = board.getMovesLeft()[new Random().nextInt(board.getMovesLeft().length)];

            } while (bestMove <= 0);

        } else {

            for (int i = 0; i < board.getMovesLeft().length; i++) {
                if (board.getMovesLeft()[i] != -1) {

                    int position = board.getMovesLeft()[i];

                    board.addMove(board.getPlayer2().getSymbol(), position);
                    int score = minimax(board, true);
                    if (score < bestScore) {
                        bestScore = score;
                        bestMove = position;
                    }
                    board.removeMove(position);
                }
            }
        }
        return bestMove;
    }

    public int minimax(Board board, boolean isMaximizer) {

        if (board.checkGameOver() != 2) {
            return board.checkGameOver();
        }

        if (isMaximizer) {
            int bestScore = -2;

            for (int i = 0; i < board.getMovesLeft().length; i++) {
                if (board.getMovesLeft()[i] != -1) {

                    int position = board.getMovesLeft()[i];
                    board.addMove(board.getPlayer1().getSymbol(), position);
                    int score = minimax(board, false);
                    if (score > bestScore) {
                        bestScore = score;
                    }
                    board.removeMove(position);
                }
            }
            return bestScore;
        } else {
            int bestScore = 2;

            for (int i = 0; i < board.getMovesLeft().length; i++) {
                if (board.getMovesLeft()[i] != -1) {

                    int position = board.getMovesLeft()[i];
                    board.addMove(board.getPlayer2().getSymbol(), position);
                    int score = minimax(board, true);
                    if (score < bestScore) {
                        bestScore = score;
                    }
                    board.removeMove(position);
                }
            }
            return bestScore;
        }
    }
}
