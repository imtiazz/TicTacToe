package LLD_Projects.TikTakToe.Strategy.GameWinningStrategy;

import LLD_Projects.TikTakToe.Models.Board;
import LLD_Projects.TikTakToe.Models.Move;
import LLD_Projects.TikTakToe.Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameWinningStrategyOne implements  GameWinningStrategy{
    private List<HashMap<Character,Integer>> rowCount=new ArrayList<>();
    private List<HashMap<Character,Integer>> colCount=new ArrayList<>();
    private HashMap<Character,Integer> leftDiagonal=new HashMap<>();
    private  HashMap<Character,Integer> rightDiagonal=new HashMap<>();
    public GameWinningStrategyOne(int dimension){
        for (int i=0;i<dimension;i++){
            rowCount.add(new HashMap<>());
            colCount.add(new HashMap<>());

        }


    }
    public boolean isRightDiagonal(int row,int col,int dimension){
        return row+col==dimension;
    }

    public boolean isLeftDiagonal(int row,int col,int dimension){
        return row==col;
    }
    @Override
    public boolean checkWinner(Board board, Player lastPlayer, Move lastMove) {
        int size=board.getBoard().size();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();
        char playerSymbol=lastPlayer.getSymbol();

        if (!rowCount.get(row).containsKey(playerSymbol))
            rowCount.get(row).put(playerSymbol,1);
        else
            rowCount.get(row).put(playerSymbol,rowCount.get(row).get(playerSymbol)+1);

        if (!colCount.get(col).containsKey(playerSymbol))
            colCount.get(col).put(playerSymbol,1);
        else
            colCount.get(col).put(playerSymbol,colCount.get(col).get(playerSymbol)+1);

        if(isLeftDiagonal(row,col,size)){
            if (!leftDiagonal.containsKey(playerSymbol) )
                leftDiagonal.put(playerSymbol,1);
            else
                leftDiagonal.put(playerSymbol,leftDiagonal.get(playerSymbol)+1);
        }

        if (isRightDiagonal(row,col,size)){
            if (!rightDiagonal.containsKey(playerSymbol) )
                rightDiagonal.put(playerSymbol,1);
            else
                rightDiagonal.put(playerSymbol,rightDiagonal.get(playerSymbol)+1);
        }

        if (rowCount.get(row).get(playerSymbol).equals(size) ||
                colCount.get(col).get(playerSymbol).equals(size))
            return true;

        if (isRightDiagonal(row,col,size) && rightDiagonal.get(playerSymbol)==size) return  true;
        if (isLeftDiagonal(row,col,size) && leftDiagonal.get(playerSymbol)==size) return true;

        return false;
    }
}
