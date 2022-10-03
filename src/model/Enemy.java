package model;

public class Enemy{
  private String name;
  private int scoreSubstraction;
  private int scoreAddition;
  private int positionX;
  private int positionY;
  private EnemyType type;

  public Enemy(String name, int scoreSubstraction, int scoreAddition, int positionX, int positionY, EnemyType type){
    this.name = name;
    this.scoreSubstraction = scoreSubstraction;
    this.scoreAddition = scoreAddition;
    this.positionX = positionX;
    this.positionY = positionY;
    this.type = EnemyType.values()[type];
  }
  public String getName() {
      return this.name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public int getScoreSubstraction() {
      return this.scoreSubstraction;
  }
  public void setScoreSubstraction(int scoreSubstraction) {
      this.scoreSubstraction = scoreSubstraction;
  }
  public int getScoreAddition() {
      return this.scoreAddition;
  }
  public void setScoreAddition(int scoreAddition) {
      this.scoreAddition = scoreAddition;
  }
  public int getPositionX() {
      return this.positionX;
  }
  public void setPositionX(int positionX) {
      this.positionX = positionX;
  }
  public int getPositionY() {
      return this.positionY;
  }
  public void setPositionY(int positionY) {
      this.positionY = positionY;
  }
  public EnemyType getType() {
      return this.type;
  }
  public void setType(EnemyType type) {
      this.type = type;
  }
  public String toString() {
    return "Level info: "
            + "\n    -Enemy name: " + this.name
            + "\n     Score that is subtracted from the player if it is a loss: " + this.scoreSubstraction
            + "\n     Score that is added to the player if he defeats him: " + this.scoreAddition
            + "\n     Position X: " + this.positionX
            + "\n     Position Y: " + this.positionY
            + "\n     Enemy type: " + this.type;
  }
}
