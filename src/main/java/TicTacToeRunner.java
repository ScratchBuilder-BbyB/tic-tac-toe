import domain.TicTacToe;
import factory.CommandExecutorFactory;
import service.CommandExecutor;
import service.DisplayManager;
import service.GameLogicService;
import service.GameManager;
import service.PlayerRegistrationService;
import service.interfaces.impl.NextMoveExecutable;
import service.interfaces.impl.RegisterPlayerExecutable;

public class TicTacToeRunner {

  public static void main(String[] args) {
    PlayerRegistrationService playerRegistrationService = new PlayerRegistrationService();
    DisplayManager displayManager = new DisplayManager();
    RegisterPlayerExecutable registerPlayerCommand = new RegisterPlayerExecutable(displayManager);
    NextMoveExecutable nextMoveCommand = new NextMoveExecutable(displayManager);
    CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(
        registerPlayerCommand, nextMoveCommand, displayManager);
    TicTacToe ticTacToe = new TicTacToe(2);
    GameLogicService gameLogicService = new GameLogicService();
    GameManager gameManager = new GameManager(playerRegistrationService, ticTacToe,
        displayManager, gameLogicService);
    CommandExecutor commandExecutor = new CommandExecutor(commandExecutorFactory, gameManager);


    gameManager.setNoOfPlayers(2);
    displayManager.displayMessage("Enter 'register' to register players....");
    commandExecutor.executeCommand();
    do{
      gameManager.showGrid();
      commandExecutor.executeCommand();
    }while(!gameManager.isGameOver());

  }
}
