package service;

import domain.Player;
import domain.TicTacToe;

public class DisplayManager {

  public void displayGrid(TicTacToe ticTacToe) {
      for(char[] row : ticTacToe.getBoard()){
        for(char piece : row){
          System.out.print(piece+" ");
        }
        System.out.println();
      }

    System.out.println();
  }

  public void displayWinner(Player player) {
    System.out.println(player.getName() +" won the game");
  }

  public void displayDrawMessage() {
    System.out.println("Next move is not possible, no winners!");
  }

  public void displayMessage(String msg) {
    System.out.println(msg);
  }
}
