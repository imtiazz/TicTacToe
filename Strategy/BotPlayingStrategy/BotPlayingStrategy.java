package LLD_Projects.TikTakToe.Strategy.BotPlayingStrategy;

import LLD_Projects.TikTakToe.Models.Board;
import LLD_Projects.TikTakToe.Models.Move;
import LLD_Projects.TikTakToe.Models.Player;

public interface BotPlayingStrategy {
    public Move decideMove(Board board, Player player);
}
