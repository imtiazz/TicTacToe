package LLD_Projects.TikTakToe.Strategy.BotPlayingStrategy;

import LLD_Projects.TikTakToe.Models.*;

public class BotEasyPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move decideMove(Board board, Player player) {
        for (int i=0;i<board.getBoard().size();i++){
            for (int j=0;j<board.getBoard().size();j++){
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY))
                    return new Move(new Cell(i,j),player);
            }
        }
        return null;
    }
}
