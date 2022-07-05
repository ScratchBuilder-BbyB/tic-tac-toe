package utils;

import java.util.Scanner;

public class TicTacToeUtils {
  private static final Scanner kb = new Scanner(System.in);

  public static String getNextCommand(){
    return kb.nextLine();
  }
}
