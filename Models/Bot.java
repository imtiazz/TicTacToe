package LLD_Projects.TikTakToe.Models;

import LLD_Projects.TikTakToe.Factory.BotPlayingStrategyFactory;
import LLD_Projects.TikTakToe.Strategy.BotPlayingStrategy.BotEasyPlayingStrategy;
import LLD_Projects.TikTakToe.Strategy.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends  Player{
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name,char symbol,BotDifficultyLevel botDifficultyLevel ){
        super(name,symbol,PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
        botPlayingStrategy= BotPlayingStrategyFactory.botPlayingDifficultyLevel(BotDifficultyLevel.EASY);

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        botPlayingStrategy=new BotEasyPlayingStrategy();
        return botPlayingStrategy.decideMove(board,this);

    }
}
