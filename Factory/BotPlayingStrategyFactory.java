package LLD_Projects.TikTakToe.Factory;

import LLD_Projects.TikTakToe.Models.BotDifficultyLevel;
import LLD_Projects.TikTakToe.Strategy.BotPlayingStrategy.BotEasyPlayingStrategy;
import LLD_Projects.TikTakToe.Strategy.BotPlayingStrategy.BotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy botPlayingDifficultyLevel(BotDifficultyLevel difficultyLevel){
        return new BotEasyPlayingStrategy();
    }
}
