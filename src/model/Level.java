package model;

public class Level{
  private int number;
  private int scoreLimit;
  private Enemy enemy[];
  private Treasure treasure[50];
  private Complexity complexity;

  public Level(int number, int scoreLimit){
    this.number = number;
    this.scoreLimit = scoreLimit;
    this.enemy = new Enemy[25];
    this.treasure = new Treasure[50];
    this.complexity = Complexity.values()[1];
  }
  public int getNumber() {
      return this.number;
  }
  public void setNumber(int number) {
      this.number = number;
  }
  public int getScoreLimit() {
      return this.scoreLimit;
  }
  public void setScoreLimit(int scoreLimit) {
      this.scoreLimit = scoreLimit;
  }
  public String toString() {
    return "Level info: "
            + "\n     Level number: " + this.number
            + "\n     Points to go to the next level: " + this.scoreLimit
            + "\n     Enemigos que se deben vencer: " + this.enemy
            + "\n     Treasures to be obtained: " + this.treasure
            + "\n     Level complexity: " + this.complexity;
  }
}
