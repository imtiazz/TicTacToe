package LLD_Projects.TikTakToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board(int dimension){
        this.board=new ArrayList<>();
        for (int i=0;i<dimension;i++){
            board.add(new ArrayList<>());
            for (int j=0;j<dimension;j++){
                board.get(i).add(new Cell(i,j));
            }
        }

    }
    public void display(){

        for(int i=0;i<board.size();i++){
            for (int j=0;j<board.size();j++){

                if (board.get(i).get(j).getCellState().equals(CellState.EMPTY))
                    System.out.printf("| |");
                else
                    System.out.printf("| "+this.board.get(i).get(j).getPlayer().getSymbol()+" |");
            }
            System.out.println("\n");
        }

    }

    public List<List<Cell>> getBoard() {
        return board;
    }


}
