/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import Classes.Adventurer;
import Classes.Attributes;
import Enemies.Enemies;
import java.util.Random;
/**
 *
 * @author jorel
 */
public class Combat {
    //Variables//
    int enemyInitiative=0;//Enemy's initiative vs your own
    int playerInitiative=0;//Player initiative
    boolean playerFirst=false;
    boolean playerTurn=false;
  
    boolean activeCombat=false;//Whether you are still fighting
    boolean hasWon=false;//Won in battle
    Enemies enemy;
    //Variables//
    
    //Constructor
    public Combat(Adventurer player, Enemies Target) {
    	enemy = Target;
    	rollInitiative(player);
    	turnOrder();
    }
    
    //Methods//
	public int rollDice(int number, int nSides)
    { 
		int num = 0;
        int roll = 0;
        Random  r = new Random(); 
        if(nSides >=3) 
        { 
        	for(int i = 0; i < number; i++)
            { 
                roll = r.nextInt(nSides)+1;
                System.out.println("Roll is:  "+roll);
                num = num + roll; 
            } 
        } 
        else
        { 
        	System.out.println("Error num needs to be from 3"); 
        } 
        return num;  
    } 
    public int convStat(String inputtedStat)
    {//Convert stats from string to int.
    	int stat=Integer.parseInt(inputtedStat);
        return stat;
    }
   
	public void rollInitiative(Adventurer player) {
		
		//Roll initial initiative for player & enemy
		enemyInitiative=rollDice(1,20)+enemy.getSpeed();
		playerInitiative=rollDice(1,20) + player.getStatValue(Attributes.SPD);
        
		//Designate player as first hitter.
		if(playerInitiative>enemyInitiative) {
			playerFirst=true;
			playerTurn=true;
        }
		
		//Designate player as first hitter.
		if(playerInitiative<enemyInitiative) {
            playerFirst=false;
            playerTurn=false;
        }
		
        activeCombat=true;
    }
	
	public void turnOrder() {
		
		//Perform turn order action
		if(playerFirst==true) {
			System.out.println("Choose your move");
			playerTurn=true;
		}
		if(playerFirst==false) {
			System.out.println("Enemy rallies an attack!");
		}       
	}
	
	public void atkAction(Adventurer player, Enemies enemy) {
		//Roll attempt to attack

		//Player's rolls
        int atkStat=player.getStatValue(Attributes.ATK);
        int playerRoll=rollDice(1,20)+atkStat;
        
        //Enemy's rolls
        int enemyDefense=enemy.getArmor();
        
        //Attack lands
        if(playerRoll > enemyDefense) {
        	int inDam = rollDice(1,6);//Damage Rolled
        	int curHP = enemy.getHitpoints()-inDam;//Damage removed from HP
        	enemy.setHitpoints(curHP);//Sustained Damage
        	playerTurn = false;
        } else {
        	System.out.println("You missed!");
        	playerTurn = false;
        }
        
        //If the enemy's HP drops to 0
        if(enemy.getHitpoints()<=0) {
        	hasWon = true;
        }
     }
	
     public void defAction(Adventurer player, Enemies enemy) {
    	 //Roll attempt to defend from enemy
    	 int playerDefense = player.getArmor();
    	 int enemyRoll = rollDice(1,20)+enemy.getChallengeRating();//Enemy attempt
    	 int playerRoll = rollDice(1,20)+ playerDefense;
    	 
    	 //Attack lands
    	 if(playerRoll < enemyRoll) {
    		 int inDam=rollDice(1,6);//Damage Rolled
    		 player.modifyStat(Attributes.HP,-inDam);//Sustained Damage
    		 playerTurn=true;
    	 } else {
    		 System.out.println("Enemy misses!");
    		 playerTurn=true;
         }
         
    	 //If the player's HP drops to 0
    	 if(player.getStatValue(Attributes.HP) <= 0) {
    		 System.out.println("You have lost against "+enemy.getName()+".");
    		 player.setDead(true);
    	 }
	}
    
   //Action to flee from battle
	public void fleeAction(Adventurer player,Enemies enemy) {
		int playerFlee=rollDice(1,20)+player.getStatValue(Attributes.SPD);
		int enemyCatch=rollDice(1,20)+enemy.getSpeed();
		
		//Player succeeds
		if(playerFlee > enemyCatch) {
			System.out.println("Player fled from Combat!");
			activeCombat = false;
		} else {
			System.out.println("Enemy caught up to you!");
			playerTurn = false;
		} 
	}
	
	//Getter Methods for boolean values
	public boolean isCombatActive() {
		return activeCombat;
	}

	public boolean hasWon() {
		return hasWon;
                
	}
}
