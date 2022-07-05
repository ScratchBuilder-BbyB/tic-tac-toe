package domain;

import exceptions.TicTacToeException;
import java.util.Arrays;

public class TicTacToe {
  private final char[][] board;
  private final int size;

  public TicTacToe(int size) {
    this.size = size;
    board = new char[size][size];
    initBoard();
  }

  public void markCell(String piece, Move move) throws TicTacToeException {
    if(board[move.getI()][move.getJ()] == '_'){
      board[move.getI()][move.getJ()] = piece.charAt(0);
    }else{
      throw new TicTacToeException("Cell already marked");
    }
  }

  public char getCell(Move move) {
    return board[move.getI()][move.getJ()];
  }

  private void initBoard(){
    for(char[] row : board){
      Arrays.fill(row, '_');
    }
  }

  public char[][] getBoard() {
    return board;
  }

  public int getSize() {
    return size;
  }
}
