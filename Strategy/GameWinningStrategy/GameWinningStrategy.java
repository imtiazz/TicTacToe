package LLD_Projects.TikTakToe.Strategy.GameWinningStrategy;

import LLD_Projects.TikTakToe.Models.Board;
import LLD_Projects.TikTakToe.Models.Move;
import LLD_Projects.TikTakToe.Models.Player;

public interface GameWinningStrategy {
    public boolean checkWinner(Board board, Player lastPlayer, Move lastMove);



}
