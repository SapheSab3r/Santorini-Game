package cmu.cs214.santorini.game;

import java.util.ArrayList;

public class Board {
    private Tile[][] tiles;
    private ArrayList<Worker> workers;

    // total number of rows and cols
    private int NUMROWS = 5;
    private int NUMCOLS = 5;

    private int setupTiles() {
        Tile[][] tiles = new Tile[NUMROWS][NUMCOLS];
        for (int i = 0; i < NUMROWS; i++) {
            for (int j = o; j < NUMCOLS; j++) {
                tiles[i][j] = new Tile();
            }
        }
        this.tiles = tiles;
    }

    public Board(Worker w11, Worker w12, Worker w21, Worker w22) {
        Worker worker11 = w11;
        Worker worker12 = w12;
        Worker worker21 = w21;
        Worker worker22 = w22;

        // Initialize the ArrayList with the workers
        workers = new ArrayList<>();
        workers.add(worker11);
        workers.add(worker12);
        workers.add(worker21);
        workers.add(worker22);

        setupTiles();
    }

    public Board(ArrayList<Worker> workers, Tile[][] tiles) {
        this.tiles = tiles;
        this.workers = workers;
    }

    public void checkMove() {

    }

    public void checkBuild() {

    }

    public Tile getGrid(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();
        return tiles[r][c];
    }

    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }
}
