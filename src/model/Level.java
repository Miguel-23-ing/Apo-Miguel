package model;

public class Level{
  private int number;
  private int scoreLimit;
  private int enemyToDefeat;
  private int treasureToObtained;
  private Treasure treasureLevel[];
  private Complexity complexity;
  private Enemy[] enemysTeam;

  public Level(int number, int scoreLimit, int enemyToDefeat, int treasureToObtained){
    this.number = number;
    this.scoreLimit = scoreLimit;
    this.enemyToDefeat = enemyToDefeat;
    this.treasureToObtained = treasureToObtained;
    this.treasureLevel = new Treasure[50];
    this.complexity = Complexity.values()[1];
    this.enemysTeam = new Enemy[25];
  }
  public int countEnemiesByType(EnemyType type) {
    int enemy = 0;
    for (int i = 0; i<enemysTeam.length; i++){
      if (enemysTeam[i] != null){
        if (enemysTeam[i].getType()==type){
          enemy++;

        }
      }
    }
    return enemy;
  }
  public int countTresures() {
    int r = 0;
    for (int i = 0; i<treasureLevel.length; i++){
      if (treasureLevel[i] != null){
        r+=treasureLevel[i].getRewarScore();
      }
    }
    return r;
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
  public int getEnemyToDefeat() {
    return this.enemyToDefeat;
  }
  public void setEnemyToDefeat(int enemyToDefeat) {
    this.enemyToDefeat = enemyToDefeat;
  }
  public Treasure[] getTreasurelevel() {
    return this.treasureLevel;
  }
  public void setTreasureLevel(Treasure[] treasureLevel) {
    this.treasureLevel = treasureLevel;
  }
  public Enemy[] getEnemysTeam() {
		return this.enemysTeam;
	}
    public void setEnemysTeam(Enemy[] enemysTeam) {
		this.enemysTeam = enemysTeam;
	}



  public String toString() {
    return "\n Level info: "
            + "\n     Level number: " + this.number
            + "\n     Points to go to the next level: " + this.scoreLimit
            + "\n     Enemigos que se deben vencer: " + this.enemyToDefeat
            + "\n     Treasures to be obtained: " + this.treasureToObtained
            + "\n     Level complexity: " + this.complexity;
  }

}
