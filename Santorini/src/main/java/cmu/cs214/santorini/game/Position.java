package cmu.cs214.santorini.game;

public class Position {
    private int row;
    private int col;

    // total number of rows and cols
    private int ROW = 5;
    private int COL = 5;

    public Position(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public int hashCode() {
        return this.row * COL + this.col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Position)) {
            return false;
        }

        Position pos = (Position) obj;
        return (pos.getCol() == this.getCol() && pos.getRow() == this.getRow());
    }

    @Override
    public String toString() {
        return "Position{" + this.row + "," + this.col + "}";
    }
}
