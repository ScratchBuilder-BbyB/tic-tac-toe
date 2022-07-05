package service.interfaces.impl;

import domain.Player;
import java.util.Objects;
import service.DisplayManager;
import service.GameManager;
import service.interfaces.Executable;
import utils.TicTacToeUtils;

public class RegisterPlayerExecutable implements Executable<GameManager> {
  private final DisplayManager displayManager;

  public RegisterPlayerExecutable(DisplayManager displayManager) {
    this.displayManager = displayManager;
  }

  @Override
  public void execute(GameManager gameManager, String command) {
    int noOfPlayers = gameManager.getNoOfPlayers();
    int playerId = 1;
    Player[] players = new Player[noOfPlayers];
    while(noOfPlayers > 0){
      displayManager.displayMessage("Enter piece and name of player-"+playerId);
      String nextCommand = TicTacToeUtils.getNextCommand();
      String[] args = splitArgs(nextCommand);
      if(isValidCommand(args)){
        players[playerId++ - 1] = new Player(args[1], args[0]);
        noOfPlayers--;
      }else{
        displayManager.displayMessage("Invalid command");
      }
    }

    gameManager.setPlayers(players);
  }

  private boolean isValidCommand(String[] args) {
    return Objects.nonNull(args) && args.length == 2 && args[0].length() == 1;
  }
}
