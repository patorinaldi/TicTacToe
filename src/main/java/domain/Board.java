package domain;

public class Board {

    private final int size;
    private final char[] positions;

    public Board(int size) {
        this.size = size;
        this.positions = new char[size];
    }

    public void initialize() {
        for (int i = 0; i < size; i++) {
            positions[i] = ' ';
        }
    }

    public void addMove(boolean player1_turn, int position) {
        if (player1_turn) {
            positions[position] = 'X';
        } else {
            positions[position] = 'O';
        }
    }

    public char getMove(int position) {
        return positions[position];
    }


    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();

        board.append("\n         —————————————\n");

        for (int i = 0; i < this.size; i++) {

            if (i == 0 || i == 3 || i == 6) {
                board.append("         | ");
            }


            if (this.positions[i] == ' ') {
               board.append(i + 1);
            } else {
                board.append(this.positions[i]);
            }

            if (i == 2 || i == 5 || i == 8) {
                board.append(" |\n");
                board.append("         —————————————\n");
            } else {
                board.append(" - ");
            }
        }
        return board.toString();
    }
}

