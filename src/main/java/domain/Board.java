package domain;

public class Board {

    private final int size;
    private final char[][] positions;
    private final Integer[] movesLeft = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int turnCount;
    private Player player1;
    private Player player2;

    public Board(int size) {
        this.size = size;
        this.positions = new char[size][size];
    }

    public void initialize() {
        this.turnCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                positions[i][j] = ' ';
            }
        }
        for (int k = 0; k < this.movesLeft.length; k++) {
            this.movesLeft[k] = k + 1;
        }

    }

    public void addMove(char symbol, int position) {
        positions[(position - 1) / size][(position - 1) % size] = symbol;
        this.turnCount++;
        this.movesLeft[position - 1] = -1;
    }

    public void removeMove(int position) {
        positions[(position - 1) / size][(position - 1) % size] = ' ';
        this.turnCount--;
        this.movesLeft[position - 1] = position;
    }

    public char getMove(int position) {

        return positions[(position - 1) / size][(position - 1) % (size)];
    }

    public char getMove(int x, int y) {
        return positions[x][y];
    }

    public int getSize() {
        return this.size;
    }

    public Integer[] getMovesLeft() {
        return this.movesLeft;
    }

    public int checkGameOver() {

        for (int i = 0; i < getSize(); i++) {
            if (getMove(i, 0) == getMove(i, 1) &&
                    getMove(i, 1) == getMove(i, 2)) {
                if (getMove(i, 0) == player1.getSymbol()) {
                    return 1;
                } else if (getMove(i, 0) == player2.getSymbol()) {
                    return -1;
                }
            }
        }

        for (int j = 0; j < getSize(); j++) {
            if (getMove(0, j) == getMove(1, j) &&
                    getMove(1, j) == getMove(2, j)) {
                if (getMove(0, j) == player1.getSymbol()) {
                    return 1;
                } else if (getMove(0, j) == player2.getSymbol()) {
                    return -1;
                }
            }
        }

        if (getMove(0, 0) == getMove(1, 1) &&
                getMove(1, 1) == getMove(2, 2)) {
            if (getMove(0, 0) == player1.getSymbol()) {
                return 1;
            } else if (getMove(0, 0) == player2.getSymbol()) {
                return -1;
            }
        }

        if (getMove(2, 0) == getMove(1, 1) &&
                getMove(1, 1) == getMove(0, 2)) {
            if (getMove(2, 0) == player1.getSymbol()) {
                return 1;
            } else if (getMove(2, 0) == player2.getSymbol()) {
                return -1;
            }
        }

        if (turnCount == 9) {
            return 0;
        }

        return 2;

    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();

        board.append("\n         —————————————\n");

        for (int i = 0; i < this.size; i++) {

            board.append("         | ");

            for (int j = 0; j < this.size; j++) {

                if (this.positions[i][j] == ' ') {
                    board.append((i * 3) + j + 1);
                } else {
                    board.append(this.positions[i][j]);
                }

                if (j < 2) {
                    board.append(" - ");
                } else if (j == 2) {
                    board.append(" |\n");
                    board.append("         —————————————\n");
                }
            }
        }
        return board.toString();
    }
}

