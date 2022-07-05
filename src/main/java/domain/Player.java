package domain;

public class Player {
  private String name;
  private String piece;

  public Player(String name, String piece) {
    this.name = name;
    this.piece = piece;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPiece() {
    return piece;
  }

  public void setPiece(String piece) {
    this.piece = piece;
  }
}
