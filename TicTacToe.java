package LLD_Projects.TikTakToe;

import LLD_Projects.TikTakToe.Controller.GameController;
import LLD_Projects.TikTakToe.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        Scanner scanner=new Scanner(System.in);
        System.out.println("*****Welcome to Tic Tac Toe****************");
        System.out.println("Enter the size of the board");
        int dimension=scanner.nextInt();
        List<Player> players=new ArrayList<>();

        System.out.println("Is game has bot : y/n");
        String isBot=scanner.next();

        int toIterate=dimension-1;
        if (isBot.equals("y"))
            toIterate=toIterate-1;
        for (int i=0;i<toIterate;i++){
            System.out.println("Enter the name of "+i+" players");
            String playerName=scanner.next();
            System.out.println("Enter the symbol of "+i+" players");
            char symbol=scanner.next().charAt(0);
            players.add(new Player(playerName,symbol, PlayerType.HUMAN));

        }
        if (isBot.equals("y")){
            System.out.println("Enter the name of BOT");
            String lastPlayerName=scanner.next();
            System.out.println("Enter the symbol of BOT");
            char symbol=scanner.next().charAt(0);
            players.add(new Bot(lastPlayerName,symbol, BotDifficultyLevel.EASY));
        }

        Game game=gameController.startGame(dimension,players);
        System.out.println("******GAME STARTED***********************");

        while(gameController.getGameStatus(game).equals(GameState.INPROGRESS)){
            gameController.displayBoard(game);
            gameController.decideNextMove(game);
        }





/*
i) start game
ii) take board dimension from the user
iii) take the player list from the user
iv( display message game is loading up now
v) ask player to set the move
vi) display the board
vii) next player move
viii) if player is bot then auto move by bot
ix) decide winner
x) end game

 */





    }
}
