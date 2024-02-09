package LLD_Projects.TikTakToe.Models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player){
        this.cell=cell;
        this.player=player;
    }

    public Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}