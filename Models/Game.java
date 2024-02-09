package LLD_Projects.TikTakToe.Models;

import LLD_Projects.TikTakToe.CustomException.InvalidGameConstructionException;
import LLD_Projects.TikTakToe.Strategy.GameWinningStrategy.GameWinningStrategy;
import LLD_Projects.TikTakToe.Strategy.GameWinningStrategy.GameWinningStrategyOne;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> listPlayers;
    private List<Move> listMoves;
    private GameState gameState;
    private int nextPlayerIndex;

    private Player winner;
    private GameWinningStrategy gameWinningStrategy;

    public void nextMove(){
        Player currentPlayer=listPlayers.get(nextPlayerIndex);
        System.out.println("Current player is "+currentPlayer.getName());
        Move move=currentPlayer.decideMove(board);
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        System.out.println("Move is played at row "+row+" and at col"+col);
        board.getBoard().get(row).get(col).setCellState(CellState.OCCUPIED);
        board.getBoard().get(row).get(col).setPlayer(currentPlayer);
        Move finalMove=new Move(board.getBoard().get(row).get(col),currentPlayer);
        listMoves.add(finalMove);
        //check winner
        if (gameWinningStrategy.checkWinner(this.board,currentPlayer,move)){
            this.setGameState(GameState.COMPLETED);
            winner=currentPlayer;
            System.out.println("Winner is "+currentPlayer.getName());
            System.out.println("GAME ENDED");
        }

        nextPlayerIndex++;
        nextPlayerIndex%=listPlayers.size();

    }

    public void displayBoard(){
        this.board.display();

    }
    public Board getBoard() {
        return board;
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }

    public List<Move> getListMoves() {
        return listMoves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setListPlayers(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public void setListMoves(List<Move> listMoves) {
        this.listMoves = listMoves;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    private Game(){

    }

    public static  Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> playerList;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }
        private boolean valid() throws InvalidGameConstructionException{
            if (this.dimension<3){
                throw new InvalidGameConstructionException("Board size must be greater than or equal to 3");
            }
            if (this.playerList.size() != this.dimension-1){
                throw  new InvalidGameConstructionException("Player size should be equal to 1 less than board dimension ");
            }
            return true;
        }

        public Game build() throws InvalidGameConstructionException {
            try{
                valid();

            }
            catch (Exception e){
                throw  new InvalidGameConstructionException(e.getMessage());
            }
            Game game=new Game();
            game.setGameState(GameState.INPROGRESS);
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new GameWinningStrategyOne(this.dimension));
            game.setBoard(new Board(this.dimension));
            game.setListMoves(new ArrayList<>());
            game.setListPlayers(this.playerList);
            //game.setWinner(new Player());
            return game;
        }
    }





}
