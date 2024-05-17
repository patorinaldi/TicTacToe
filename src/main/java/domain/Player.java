package domain;

public class Player {

    private char symbol;
    private int wins;

    public Player(char symbol) {
        this.symbol = symbol;
        this.wins = 0;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "" + symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void addWin(){
        this.wins++;
    }

    public int getWins() {
        return this.wins;
    }
}
