package model;

import java.util.Random;

public class GameController{
  private Player[] players;
  private Treasure[] treasures;
  private Level[] levels;
  private Enemy[] enemys;

  public GameController() {
    this.players = new Player[20];
    this.treasures = new Treasure[50];
    this.levels = new Level[10];
    this.enemys = new Enemy[25];

    generateLevels();

  }
	public void generateLevels(){

		Random r = new Random();

		for (int i = 0; i < levels.length; i++){

			int random = r.nextInt(2000);

			int randomE = r.nextInt(25);

			int randomT = r.nextInt(50);

			Level newLevel = new Level(i+1,random, randomE, randomT);

			if(levels[i]==null){
				levels[i]=newLevel;
			}

		}
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

  public boolean registerPlayer(String nickName, String name, int liveNumber, int lvl) {

	Player newPlayer = new Player(nickName, name, liveNumber, lvl);

	for (int i = 0; i < players.length; i++) {

		if (players[i] == null) {

			players[i] = newPlayer;
			return true;
		}

	}

	return false;

}
	public String consonants(){
		String msg = "";
		int count = 0;
		String eName = "";
		String consonantes ="bcdefghjklmnñpqrstvxyz";
		for(int i = 0; i<levels.length; i++){
			if(levels[0]!=null){}
			for(int x = 0; x<levels[0].getEnemysTeam().length; x++){
				if (levels[i]!=null){
					if (levels[i].getEnemysTeam()[x]!=null){
						eName = levels[i].getEnemysTeam()[x].getName();
						for(int t = 0; t<consonantes.length(); t++){
							for(int j= 0; j<eName.length(); j++){
								if(eName.charAt(j)==consonantes.charAt(t)){
									count++;
								}

							}
						}
					}
				}
			}


		}
		return msg ="The total number of consonants that enemies have in their name is: " + count;
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
  public boolean registerEnemy(String name, int scoreSubstraction, int scoreAddition, int positionX, int positionY, int type) {

	Enemy newEnemy = new Enemy(name, scoreSubstraction, scoreAddition, positionX, positionY, type);

	for (int i = 0; i < enemys.length; i++) {

		if (enemys[i] == null) {

			enemys[i] = newEnemy;
			return true;
		}

	}

	return false;

}
	public boolean registerTreasure(String name, String url, int rewarScore, int positionX, int positionY) {

		Treasure newTreasure = new Treasure(name, url, rewarScore, positionX, positionY);

		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] == null) {

				treasures[i] = newTreasure;
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
	public String showTreasure() {

		String treasure1 = "";

		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] != null) {

				treasure1 += treasures[i].toString();
			}

		}
		return treasure1;

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
	public int searchPlayerbyNickName(String nickName) {
		int pose = -1;
		boolean isFound = false;
		for (int i =0; i<players.length && !isFound; i++){
			if(players[i]!=null){
				if(players[i].getNickName().equalsIgnoreCase(nickName)){
					isFound = true;
					pose = i;
				}
			}
		}
		return pose;
	}
	public String changePlayerScore(String nickName, int newScore) {
		String msg = "";
		int pose = searchPlayerbyNickName(nickName);
		if (pose == -1) {
			msg = "Player not found";
		} else {
			newScore += players[pose].getScore();
			players[pose].setScore(newScore);
			msg = "Score updated successfully";
		}
		return msg;

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
	public Treasure searchTreasureByName(String name){
		boolean isFound = false;
		Treasure anyTreasure = null;
		for (int i = 0; i < treasures.length && !isFound; i++) {
			if (treasures[i].getName().equals(name)){
				isFound = true;
				anyTreasure = treasures[i];
			}
		}
		return anyTreasure;

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
	public Treasure[] addTreasure(Treasure[] treasures, Treasure anyTreasure){
		boolean isFound = false;
		for (int i = 0; i < treasures.length && !isFound; i++){
			if (treasures[i] == null){
				isFound = true;
				treasures[i] = anyTreasure;
			}
		}
		return treasures;
	}
	public EnemyType typeOfEnemy(int type){
		EnemyType EType = EnemyType.NULL;
		if(type == 1){
			EType = EnemyType.OGRE;
		}
		if(type == 2){
			EType = EnemyType.ABSTRACT;
		}
		if(type == 3){
			EType = EnemyType.BOSS;
		}
		if(type == 4){
			EType = EnemyType.MAGICAL;
		}
		return EType;
	}
	public String treasuresAndEnemys(int number){
		int pose = searchLevelByNumber(number);
		String msg = "";
		if (pose !=-1){
			for (int i = 0; i<levels[pose].getTreasurelevel().length; i++){
				if(levels[pose].getTreasurelevel()[i]!=null){
					msg += levels[pose].getTreasurelevel()[i].getName();
				}



			}
			for (int i = 0; i<levels[pose].getEnemysTeam().length; i++){
				if(levels[pose].getEnemysTeam()[i]!=null){
					msg += levels[pose].getEnemysTeam()[i].getName();
				}
			}
		}else{
			msg ="Level not found";
		}
		return msg;

	}
	public String treasuresLevels(){
		int tot = 0;
		String msg ="";

		for (int i = 0; i<levels.length; i++){
			tot+=levels[i].countTresures();
		}
		return msg = "In all levels there are "+ tot + "treasures";
	}
	public String enemyTypeLevels(int type){
		EnemyType toSearch = typeOfEnemy(type);
		int tot = 0;
		String msj;
		for (int i = 0; i<levels.length; i++){
			tot +=levels[i].countEnemiesByType(toSearch);

		}
		return msj = "En total de los niveles hay " + tot + " "+ EnemyType.values()[type];
	}
	public String showMaximumEnemy(){
		String msg="";
		int pose = -1;
		int enemyPosition= -1;
		int max = 0;
		int min = 0;
		for(int i = 0; i<levels.length; i++){
			for(int j = 0; j<levels[0].getEnemysTeam().length; j++){

				if (levels[i].getEnemysTeam()[j]!=null){
					min = levels[i].getEnemysTeam()[j].getScoreAddition();
					if(min > max){
						max = min;
						pose = i;
						enemyPosition = j;
					}
				}
			}
		}
		if (enemyPosition != -1 && pose != -1){
			msg = "The enemy that awards the most points is: " + levels[pose].getEnemysTeam()[enemyPosition].getType() + " at the level number: "+(pose+1)+"\n"+
					"Gives a total of: " + levels[pose].getEnemysTeam()[enemyPosition].getScoreAddition() + " points";
		}
		return msg;
	}

}
