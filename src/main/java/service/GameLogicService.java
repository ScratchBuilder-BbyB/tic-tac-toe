package service;

import domain.Move;
import domain.Player;
import domain.TicTacToe;
import java.util.Optional;

public class GameLogicService {

  private int successfulMoveCounter;

  public boolean isWinner(TicTacToe ticTacToe, Move move, char piece) {
    int size = ticTacToe.getSize();
    boolean rowWinner = true, colWinner = true, leftDiaginalWinner = true, rightDiagonalWinner = true;
    char[][] board = ticTacToe.getBoard();

    for(int i = 0; i < size; i++){
      if(rowWinner && board[move.getI()][i] != piece){
        rowWinner = false;
      }

      if(colWinner && board[i][move.getJ()] != piece){
        colWinner = false;
      }

      if(leftDiaginalWinner && board[i][i] != piece){
        leftDiaginalWinner = false;
      }

      if(rightDiagonalWinner && board[size - 1 - i][size - 1 - i] != piece){
        rightDiagonalWinner = false;
      }
    }

    return rowWinner || colWinner || leftDiaginalWinner || rightDiagonalWinner;
  }

  public boolean isNextMovePossible(TicTacToe ticTacToe) {
    return successfulMoveCounter != Math.pow(ticTacToe.getSize(), 2);
  }

  public void incrementSuccessMoveCounter(){
    successfulMoveCounter++;
  }
}
