package LLD_Projects.TikTakToe.Models;

import java.util.Scanner;

public class Player {
//    int id;
    private String name;
    private char symbol;

    private PlayerType playerType;

    public Player(String name,char symbol, PlayerType playerType){
        this.name=name;
        this.symbol=symbol;
        this.playerType=playerType;
    }

    public Move decideMove(Board board){
       //TODO::  Add the implementation here
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the row position for next move");
        int row=scanner.nextInt();
        System.out.println("Enter the column position for next move");
        int col=scanner.nextInt();
        return  new Move(new Cell(row,col),this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
