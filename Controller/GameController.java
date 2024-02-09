package LLD_Projects.TikTakToe.Controller;

import LLD_Projects.TikTakToe.Models.Game;
import LLD_Projects.TikTakToe.Models.GameState;
import LLD_Projects.TikTakToe.Models.Move;
import LLD_Projects.TikTakToe.Models.Player;

import java.awt.*;
import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players) {
        try{
            return Game.builder()
                    .setDimension(dimension)
                    .setPlayerList(players).build();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }

    public void setMove(Move move,Game game){
        game.getListMoves().add(move);

    }

    public void nextMove(Game game){
        game.nextMove();
    }

    public GameState getGameStatus(Game game){
        return game.getGameState();
    }

    public void decideNextMove(Game game){
        game.nextMove();

    }




}
