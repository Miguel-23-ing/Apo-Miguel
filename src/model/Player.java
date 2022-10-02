package model;

public class Player{
  private String nickName;
  private String name;
  private int score;
  private int liveNumber;

  public Player(String nickName, String name){
    this.nickName = nickName;
    this.name = name;
    this.score = 10;
    this.liveNumber = 5;
  }
  public String getNickName() {
      return this.nickName;
  }
  public void setNickName(String nickName) {
      this.nickName = nickName;
  }
  public String getName() {
      return this.name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public int getScore() {
      return this.score;
  }
  public void setScore(int score) {
      this.score = score;
  }
  public int getLiveNumber() {
      return this.liveNumber;
  }
  public void setLiveNumber(int liveNumber) {
      this.liveNumber = liveNumber;
  }
  public String toString() {
      return "Player info: "
              + "\n Player's Nickname: " + this.nickName
              + "\n     Player's name: " + this.name
              + "\n     Score: " + this.score
              + "\n     Number of lives: " + this.liveNumber;
  }
}
