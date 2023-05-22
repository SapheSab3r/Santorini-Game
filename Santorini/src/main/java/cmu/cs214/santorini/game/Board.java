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

    public boolean hasWorker(Position pos) {
        for (Worker worker : workers) {
            if (worker == null || worker.getPosition() == null) {
                continue; // the worker is not initialized yet
            }
            if (worker.getPosition().equals(pos)) {
                return true; // the space already has a worker
            }
        }
        return false;
    }

    public boolean isInBound(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();

        if (row < 0 || row >= NUMROWS) {
            return false;
        }
        if (col < 0 || col >= NUMCOLS) {
            return false;
        }

        return true;
    }

    public boolean isAdjacent(Position pos1, Position pos2) {
        int r1 = pos1.getRow();
        int c1 = pos1.getCol();

        int r2 = pos2.getRow();
        int c2 = pos2.getCol();

        if (Math.abs(r2 - r1) > 1 || Math.abs(c2 - c1) > 1) {
            return false;
        }
        return true;
    }

    public boolean checkMove(Worker worker, Position pos) {
        // checking cannot move out of bound
        if (!isInBound(pos)) {
            return false;
        }

        // checking position occupied already
        if (hasWorker(pos)) {
            return false;
        }

        Position currPos = worker.getPosition();
        // check it is not adjacent
        if (!isAdjacent(currPos, pos)) {
            return false;
        }

        // check cannot move to the tile that is one level higher
        // check cannot move to the tile that is completed
        int currLevel = getTile(currPos).getTowerLevel();
        Tile tile = getTile(pos);
        if (!tile.isValidLevel(currLevel)) {
            return false;
        }

        return true;
    }

    public boolean checkBuild(Worker worker, Position pos) {
        // cannot build out of bound
        if (!isInBound(pos)) {
            return false;
        }
        // cannot build if the tower is completed
        Tile tile = getTile(pos);
        if (tile.isComplete()) {
            return false;
        }

        // cannot build if it is not adjacent
        Position currPos = worker.getPosition();
        if (!isAdjacent(currPos, pos)) {
            return false;
        }

        // cannot build if it is occupied already
        if (hasWorker(pos)) {
            return false;
        }
        return true;
    }

    public Tile getTile(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();
        return tiles[r][c];
    }

    public Worker getWorker(int playerId, int workerId) {
        int index = (playerId - 1) * 2 + (workerId - 1);
        return workers.get(index);
    }

    public ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    public Board copyBoard() {
        ArrayList<Worker> newWorkers = new ArrayList<>();
        for (Worker worker : this.workers) {
            newWorkers.add(worker);
        }
        Tile[][] newTile = new Tile[NUMROWS][NUMCOLS];
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                newTile[i][j] = (this.tiles[i][j]).copyTile();
            }
        }

        return new Board(newWorkers, newTile);
    }

    public Board setWorker(int playerId, Position pos, int workerId) {
        Board newBoard = this.copyBoard();
        Worker worker = newBoard.getWorker(playerId, workerId);
        worker.setPosition(pos);
        return newBoard;
    }

    public Board build(Position pos) {
        Board newBoard = this.copyBoard();
        Tile t = newBoard.getTile(pos);
        t.build();
        return newBoard;
    }

    @Override
    public String toString() {

    }
}
