package service.interfaces.impl;

import domain.Move;
import java.util.Objects;
import service.DisplayManager;
import service.GameManager;
import service.interfaces.Executable;

public class NextMoveExecutable implements Executable<GameManager> {

  private final DisplayManager displayManager;

  public NextMoveExecutable(DisplayManager displayManager) {
    this.displayManager = displayManager;
  }

  @Override
  public void execute(GameManager gameManager, String nextCommand) {
    Move move = validateCommandAndGetMove(nextCommand, gameManager);
    if(Objects.isNull(move)){
      displayManager.displayMessage("Invalid Move");
    }else{
      gameManager.makeMove(move);
    }

  }

  public Move validateCommandAndGetMove(String command, GameManager gameManager) {
    String[] args = splitArgs(command);
    if(Objects.nonNull(args) && args.length == 2){
      try{
        int i = Integer.parseInt(args[0]) - 1;
        int j = Integer.parseInt(args[1]) - 1;
        Move move = new Move(i, j);
        if(isValidMove(move, gameManager)){
          return move;
        }
      }catch (NumberFormatException e){

      }
    }
    return null;
  }

  private boolean isValidMove(Move move, GameManager gameManager) {
    return move.getI() < gameManager.getTicTacToe().getSize() && move.getJ() < gameManager.getTicTacToe().getSize() && gameManager.getCellValue(move) == '_';
  }
}
