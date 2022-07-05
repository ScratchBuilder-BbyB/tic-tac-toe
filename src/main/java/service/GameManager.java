package service;

import domain.Move;
import domain.Player;
import domain.TicTacToe;
import java.util.Optional;

public class GameManager {
    private final PlayerRegistrationService playerRegistrationService;
    private final TicTacToe ticTacToe;
    private final DisplayManager displayManager;
    private final GameLogicService gameLogicService;
    private Player[] players;
    private int turnCounter = 0;
    private boolean gameOver;
    private int noOfPlayers = 2;

  public GameManager(PlayerRegistrationService playerRegistrationService,
      TicTacToe ticTacToe, DisplayManager displayManager,
      GameLogicService gameLogicService) {
    this.playerRegistrationService = playerRegistrationService;
    this.ticTacToe = ticTacToe;
    this.displayManager = displayManager;
    this.gameLogicService = gameLogicService;
  }

  public void registerPlayers(int noOfPlayers){
    players = playerRegistrationService.registerPlayers(noOfPlayers);
  }

  public void showGrid(){
    displayManager.displayGrid(ticTacToe);
  }

  public void checkForWinner(Move move, Player player){
    boolean isWinner = gameLogicService.isWinner(ticTacToe, move, player.getPiece().charAt(0));
    if(isWinner){
      displayManager.displayWinner(player);
      endGame();
    }else if(!gameLogicService.isNextMovePossible(ticTacToe)){
      displayManager.displayDrawMessage();
      endGame();
    }
  }

  private void endGame() {
    gameOver = true;
  }

  public boolean isGameOver(){
    return gameOver;
  }

  public Player[] getPlayers() {
    return players;
  }

  public void setPlayers(Player[] players) {
    this.players = players;
  }

  public TicTacToe getTicTacToe() {
    return ticTacToe;
  }

  public void makeMove(Move move){
    ticTacToe.markCell(players[getTurnCounter()].getPiece(), move);
    gameLogicService.incrementSuccessMoveCounter();
    checkForWinner(move, players[getTurnCounter()]);
    incrementTurn();
  }

  private void incrementTurn(){
    turnCounter++;
    turnCounter = turnCounter % players.length;
  }

  public int getTurnCounter() {
    return turnCounter;
  }

  public char getCellValue(Move move){
    return ticTacToe.getCell(move);
  }

  public int getNoOfPlayers() {
    return noOfPlayers;
  }

  public void setNoOfPlayers(int noOfPlayers) {
    this.noOfPlayers = noOfPlayers;
  }
}
