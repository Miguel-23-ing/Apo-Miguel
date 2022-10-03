package model;

public class GameController {
  private Player[] players;
  private Treasure[] treasures;
  private Level[] levels;
  private EnemyType types;
  private Enemy[] enemys;

  public GameController() {
    this.players = new Player[20];
    this.treasures = new Treasure[50];
    this.levels = new Level[10];
    this.types = EnemyType.values()[type];
    this.enemys = new Enemy[25];
  }
  public Player[] getPlayers() {
		return this.players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public Treasure[] getTreasures() {
		return this.treasures;
	}
	public void setTreasures(Treasure[] treasures) {
		this.treasures = treasures;
	}
  public Level[] getLevels() {
		return this.levels;
	}
	public void setLevels(Level[] levels) {
		this.levels = levels;
	}
  public Enemy[] getEnemys() {
		return this.enemys;
	}
	public void setEnemys(Enemy[] enemys) {
		this.enemys = enemys;
	}
  public boolean registerPlayer(String nickName, String name, int score, int liveNumber, int lvl) {

	Player newPlayer = new Player(nickName, name, score, liveNumber, lvl);

	for (int i = 0; i < players.length; i++) {

		if (players[i] == null) {

			players[i] = newPlayer;
			return true;
		}

	}

	return false;

}
	public boolean searchPlayer(String nickName){
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null){
				if (players[i].getNickName().equals(nickName)){
					return true;
				}
			}
	} return false;

 }
 public String showPlayers() {

		String players1 = "";

		for (int i = 0; i < players.length; i++) {

			if (players[i] != null) {

				players1 += players[i].toString();
			}

		}
		return players1;

	}
  public boolean registerEnemy(String name, int scoreSubstraction, int scoreAddition, int positionX, int positionY, EnemyType type) {

	Enemy newEnemy = new Enemy(name, scoreSubstraction, scoreAddition, positionX, positionY, type);

	for (int i = 0; i < enemys.length; i++) {

		if (enemys[i] == null) {

			enemys[i] = newEnemy;
			return true;
		}

	}

	return false;

}
	public boolean searchEnemy(String name){
		for (int i = 0; i < enemys.length; i++) {
			if (enemys[i] != null){
				if (enemys[i].getName().equals(name)){
					return true;
				}
			}
	} return false;

 }
 public String showEnemy() {

		String enemys1 = "";

		for (int i = 0; i < enemys.length; i++) {

			if (enemys[i] != null) {

				enemys1 += enemys[i].toString();
			}

		}
		return enemys1;

	}
  public String showEnemyTypes() {
    String typeList = "";
    EnemyType[] types = EnemyType.values();
    for (int i = 0; i < types.length; i++) {
      typeList += (i+1) + ". " + types[i] + ", ";
    }
    return typeList;
  }
  public String showLevels() {

 		String levels1 = "";

 		for (int i = 0; i < levels.length; i++) {

 			if (levels[i] != null) {

 				levels1 += levels[i].toString();
 			}

 		}
 		return levels1;

 	}
  public int searchLevelByNumber(int number){
		boolean isFound = false;
		int pose = -1;
		for (int i = 0; i < levels.length && !isFound; i++) {
			if (levels[i].getNumber() == number){
				isFound = true;
				pose = i;
			}
	}
		return pose;

 }
 public Enemy searchEnemyByName(String name){
	 boolean isFound = false;
	 Enemy anyEnemy = null;
	 for (int i = 0; i < enemys.length && !isFound; i++) {
			if (enemys[i].getName().equals(name)){
			 isFound = true;
			 anyEnemy = enemys[i];
			}
 }
	 return anyEnemy;

}
	public Enemy[] addEnemy(Enemy[] enemys, Enemy anyEnemy){
		boolean isFound = false;
		for (int i = 0; i < enemys.length && !isFound; i++){
			if (enemys[i] == null){
				isFound = true;
				enemys[i] = anyEnemy;
			}
		}
		return enemys;
	}
}
