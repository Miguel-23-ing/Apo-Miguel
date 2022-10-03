package model;

public class Treasure{
  private String name;
  private String url;
  private int rewarScore;
  private int positionX;
  private int positionY;

  public Treasure(String name, String url, int rewarScore, int positionX, int positionY){
    this.name = name;
    this.url = url;
    this.rewarScore = rewarScore;
    this.positionX = positionX;
    this.positionY = positionY;
  }
  public String getName() {
      return this.name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public String getUrl() {
      return this.url;
  }
  public void setUrl(String url) {
      this.url = url;
  }
  public int getRewarScore() {
      return this.rewarScore;
  }
  public void setRewareScore(int rewarScore) {
      this.rewarScore = rewarScore;
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
  public String toString() {
    return "Level info: "
            + "\n     Treasure name: " + this.name
            + "\n     Image URL: " + this.url
            + "\n     Score given to the player: " + this.rewarScore
            + "\n     Position X: " + this.positionX
            + "\n     Position Y: " + this.positionY;
  }
}
