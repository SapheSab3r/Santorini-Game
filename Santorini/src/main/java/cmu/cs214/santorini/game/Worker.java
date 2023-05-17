package cmu.cs214.santorini.game;

public class Worker {
    private Position position;

    public Worker() {
        this.position = null;
    }

    public Worker(Position position) {
        this.position = position;
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public Position gePosition() {
        return this.position;
    }
}
