package cmu.cs214.santorini.game;

public class Tile {
    private int towerLevel;
    private boolean isChoosen;

    // the complete level
    private int DOMELEVEL = 4;

    public Tile() {
        this.towerLevel = 0;
    }

    public Tile(int towerLevel) {
        this.towerLevel = towerLevel;
    }

    public void build() {
        towerLevel++;
    }

    public void choose() {
        this.isChoosen = true;
    }

    public void unchoose() {
        this.isChoosen = false;
    }

    public boolean isComplete() {
        return (this.getTowerLevel() == DOMELEVEL);
    }

    public int getTowerLevel() {
        return this.towerLevel;
    }

    public boolean checkIsChoosen() {
        return this.isChoosen;
    }

    public boolean isValidLevel(int level) {
        if (this.isComplete()) {
            return false;
        }
        int currLevel = this.getTowerLevel();
        if (currLevel > level + 1) {
            return false;
        }
        return true;
    }

    public Tile copyTile() {
        return new Tile(this.getTowerLevel());
    }

    @Override
    public String toString() {
        return "Tile{" + "towerLevel=" + towerLevel + "}";
    }

}
