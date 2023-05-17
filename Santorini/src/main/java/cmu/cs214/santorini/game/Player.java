package cmu.cs214.santorini.game;

public class Player {
    private Worker w1;
    private Worker w2;

    public Player(Worker w1, Worker w2) {
        this.w1 = w1;
        this.w2 = w2;
    }

    public Worker getWorkerOne() {
        return this.w1;
    }

    public Worker getWorkerTwo() {
        return this.w2;
    }

    public void setWorker(Position pos, int workerId) {
        Worker worker = (workerId == 1 ? this.w1 : this.w2);
        worker.setPosition(pos);
    }
}
