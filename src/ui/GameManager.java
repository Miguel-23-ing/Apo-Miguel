package ui;

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

        System.out.println("Type an option: \n   1.Register player \n   2.Register enemy \n   3.Add enemy to level");

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
    System.out.println("Enter the Player's Score:");
    int score = sc.nextInt();
    System.out.println("Enter the Player's Lives Number:");
    int liveNumber = sc.nextInt();
    System.out.println("Enter the Player's Lvl");
    int lvl = sc.nextInt();

    if(gc.registerPlayer(nickName, name, score , liveNumber, lvl)){
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
      System.out.println("Enter the Enemy's Type: \n Enter the number according to the type you wan");
      System.out.println(gc.showEnemyTypes());
      int type = sc.nextInt();

      if(gc.registerEnemy(name, scoreSubstraction , scoreAddition, positionX, positionY, type)){
        System.out.println("The Enemy " + name + " successfully registered");

      }else{
        System.out.println("Can't register enemy");
      }
    }else{
      System.out.println("The Enemy " + name + " has already been registered previously");
    }

  }

  private static void addEnemyToLevel(){
    sc.nextLine();
    System.out.println(gc.showEnemy());

    System.out.println("Type the name of the enemy you will add to a level");
    String addEnemy = sc.next();
    if (gc.searchEnemyByName(addEnemy) == null){
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
}
