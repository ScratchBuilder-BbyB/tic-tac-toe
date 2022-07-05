package factory;

import enums.CommandType;
import service.DisplayManager;
import service.GameManager;
import service.interfaces.Executable;
import service.interfaces.impl.NextMoveExecutable;
import service.interfaces.impl.RegisterPlayerExecutable;

public class CommandExecutorFactory implements SimpleFactory <Executable<GameManager>, CommandType>{

  private final RegisterPlayerExecutable registerPlayerCommand;
  private final NextMoveExecutable nextMoveCommand;
  private final DisplayManager displayManager;

  public CommandExecutorFactory(RegisterPlayerExecutable registerPlayerCommand,
      NextMoveExecutable nextMoveCommand, DisplayManager displayManager) {
    this.registerPlayerCommand = registerPlayerCommand;
    this.nextMoveCommand = nextMoveCommand;
    this.displayManager = displayManager;
  }

  @Override
  public Executable<GameManager> getInstance(CommandType commandType) {
    switch (commandType){
      case EXIT:
        displayManager.displayMessage("Good bye :)");
        System.exit(-1);
        break;
      case REGISTER_PLAYERS:
        return registerPlayerCommand;
      case NEXT_MOVE:
        return nextMoveCommand;
      default:
        displayManager.displayMessage("Invalid command");
    }
    return null;
  }
}
