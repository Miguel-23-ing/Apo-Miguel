package ui;

import model.EnemyType;
import model.GameController;

import java.util.Scanner;

public class GameManager {
  public static Scanner sc = new Scanner(System.in);
  public static GameController gc = new GameController();

  public static void main(String[] args) {

    menu();
 }
 public static void menu(){

   System.out.println("Welcome");

   boolean exit = false;
   while (!exit){

        System.out.println("Type an option: \n   1.Register player \n   2.Register enemy \n   3.Add enemy to level \n   4.Register treasure \n   5.Add treasure to level \n   6.Modify a player's score \n   7.Show enemies and treasures of a level \n   8.Show treasures of all levels \n   9.Show the amount of a specific type of enemy in all levels \n   10.Show the enemy that gives the highest score and the level where it is located \n   11.Show the total number of consonants that enemies have in their name");

        int option = sc.nextInt();

    switch (option) {

        case 1:
            registerPlayer();
            break;
        case 2:
          registerEnemy();
          break;
        case 3:
            addEnemyToLevel();
            break;
        case 4:
            registerTreasure();
            break;
        case 5:
            addTreasureToLevel();
            break;
        case 6:
            changePlayerScore();
            break;
        case 7:
            treasuresAndEnemys();
            break;
        case 8:
            treasureLevels();
            break;
        case 9:
            enemyTypeLevels();
            break;
        case 10:
            System.out.println(gc.showMaximumEnemy());
            break;
        case 11:
            System.out.println(gc.consonants());
            break;
   			default:
   				exit = true;
   				break;

     			}

   }

 }
 private static void registerPlayer(){
  sc.nextLine();
  System.out.println("Enter the player's nickname");
  String nickName = sc.nextLine();

  if (!gc.searchPlayer(nickName)){

    System.out.println("Enter the Player's Name:");
    String name = sc.nextLine();
    System.out.println("Enter the Player's Lives Number:");
    int liveNumber = sc.nextInt();
    System.out.println("Enter the Player's Lvl");
    int lvl = sc.nextInt();

    if(gc.registerPlayer(nickName, name, liveNumber, lvl)){
      System.out.println("The Player " + nickName + " successfully registered");

    }else{
      System.out.println("Can't register player");
    }
  }else{
    System.out.println("The Player " + nickName + " has already been registered previously");
  }
  System.out.println(gc.showPlayers());
  }
  public static void registerEnemy(){
    sc.nextLine();
    System.out.println("Enter the enemy's name");
    String name = sc.nextLine();

    if (!gc.searchEnemy(name)){

      System.out.println("Enter the Enemy's score that is subtracted from the player if it is a loss:");
      int scoreSubstraction = sc.nextInt();
      System.out.println("Enter the Enemy's score that is added to the player if he defeats him:");
      int scoreAddition = sc.nextInt();
      System.out.println("Enter the Enemy's Position X:");
      int positionX = sc.nextInt();
      System.out.println("Enter the Enemy's Position Y:");
      int positionY = sc.nextInt();
      System.out.println("Enter the Enemy's Type: \n Enter the number according to the type you want");
      System.out.println(gc.showEnemyTypes());
      int type = sc.nextInt()-1;

      if(gc.registerEnemy(name, scoreSubstraction , scoreAddition, positionX, positionY, type)){
        System.out.println("The Enemy " + name + " successfully registered");



      }else{
        System.out.println("Can't register enemy");
      }
    }else{
      System.out.println("The Enemy " + name + " has already been registered previously");
    }

  }
    public static void registerTreasure(){
        sc.nextLine();
        System.out.println("Enter the treasure's name");
        String name = sc.nextLine();

        System.out.println("Type the url of the image:");
        String url = sc.nextLine();
        System.out.println("Enter the score given to the player:");
        int rewarScore = sc.nextInt();
        System.out.println("Enter the Enemy's Position X:");
        int positionX = sc.nextInt();
        System.out.println("Enter the Enemy's Position Y:");
        int positionY = sc.nextInt();

        if(gc.registerTreasure(name, url , rewarScore, positionX, positionY)){
            System.out.println("The Treasure " + name + " successfully registered");
        }else{
            System.out.println("Can't register treasure");
        }


    }

  private static void addEnemyToLevel(){
    sc.nextLine();
    System.out.println(gc.showEnemy());

    System.out.println("Type the name of the enemy you will add to a level");
    String addEnemy = sc.next();
    if (gc.searchEnemyByName(addEnemy).equals(null)){
      System.out.println("Enemy not found");
    } else {
      System.out.println(gc.showLevels());
      System.out.println("Enter the number of the level to which it will be added");
      int addLevel = sc.nextInt();
      int levelPose = gc.searchLevelByNumber(addLevel);
      if (levelPose == -1){
        System.out.println("Level not found");
      } else {
        gc.getLevels()[levelPose].setEnemysTeam(gc.addEnemy(gc.getLevels()[levelPose].getEnemysTeam(), gc.searchEnemyByName(addEnemy)));
        System.out.println("The enemies of the level are:");
        for (int i = 0; i < gc.getLevels()[levelPose].getEnemysTeam().length; i++){
          if (gc.getLevels()[levelPose].getEnemysTeam()[i] != null){
            System.out.println(gc.getLevels()[levelPose].getEnemysTeam()[i].toString());
          }
        }
      }
    }
  }
    private static void addTreasureToLevel(){
        sc.nextLine();
        System.out.println(gc.showTreasure());

        System.out.println("Type the name of the treasure you will add to a level");
        String addTreasure = sc.next();
        if (gc.searchTreasureByName(addTreasure).equals(null)){
            System.out.println("Treasure not found");
        } else {
            System.out.println(gc.showLevels());
            System.out.println("Enter the number of the level to which it will be added");
            int addLevel = sc.nextInt();
            int levelPose = gc.searchLevelByNumber(addLevel);
            if (levelPose == -1){
                System.out.println("Level not found");
            } else {
                gc.getLevels()[levelPose].setTreasureLevel(gc.addTreasure(gc.getLevels()[levelPose].getTreasurelevel(), gc.searchTreasureByName(addTreasure)));
                System.out.println("The treasures of the level are:");
                for (int i = 0; i < gc.getLevels()[levelPose].getTreasurelevel().length; i++){
                    if (gc.getLevels()[levelPose].getTreasurelevel()[i] != null){
                        System.out.println(gc.getLevels()[levelPose].getTreasurelevel()[i].toString());
                    }
                }
            }
        }
    }
    private static void changePlayerScore() {
      sc.nextLine();
      System.out.println(gc.showPlayers());

      System.out.println("Enter the Nick name of the player you want to modify your score");
      String nickName = sc.nextLine();
      System.out.println("Enter the points you want to add to the player's score");
      int newScore = sc.nextInt();

      System.out.println(gc.changePlayerScore(nickName, newScore));
      System.out.println(gc.showPlayers());

    }
    private static void treasuresAndEnemys() {
      System.out.println("Type the number of the level");
      int number = sc.nextInt();

      System.out.println(gc.treasuresAndEnemys(number));

    }
    private static void treasureLevels() {
      System.out.println(gc.treasuresLevels());
    }
    private static void enemyTypeLevels() {

      System.out.println(gc.showEnemyTypes());
      System.out.println("Enter the Enemy's Type: \n Enter the number according to the type you want");
      int type = sc.nextInt()-1;

      if(type<1 || type> EnemyType.values().length){
          System.out.println(gc.enemyTypeLevels(type));
      }else{
          System.out.println("You entered an invalid option");
      }
    }

}
