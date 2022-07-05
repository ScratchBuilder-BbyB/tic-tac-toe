package service;

import enums.CommandType;
import factory.CommandExecutorFactory;
import service.interfaces.Executable;
import utils.TicTacToeUtils;

public class CommandExecutor implements Executable<GameManager> {

  private final CommandExecutorFactory commandExecutorFactory;
  private final GameManager gameManager;

  public CommandExecutor(CommandExecutorFactory commandExecutorFactory,
      GameManager gameManager) {
    this.commandExecutorFactory = commandExecutorFactory;
    this.gameManager = gameManager;
  }

  public void executeCommand() {
    String nextCommand = TicTacToeUtils.getNextCommand();
    CommandType commandType = getCommandType(nextCommand);
    commandExecutorFactory.getInstance(commandType).execute(gameManager, nextCommand);
  }

  private CommandType getCommandType(String nextCommand) {
    if(nextCommand.contains("exit")){
      return CommandType.EXIT;
    }

    if(nextCommand.contains("register")){
      return CommandType.REGISTER_PLAYERS;
    }

    return CommandType.NEXT_MOVE;
  }

  @Override
  public void execute(GameManager gameManager) {
    String nextCommand = TicTacToeUtils.getNextCommand();
    CommandType commandType = getCommandType(nextCommand);
    commandExecutorFactory.getInstance(commandType).execute(gameManager, nextCommand);
  }
}
