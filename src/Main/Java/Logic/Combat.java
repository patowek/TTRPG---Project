/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import Classes.Adventurer;
import Classes.Attributes;
import Enemies.Enemies;
import Map.Room;

import java.util.Random;
/**
 *
 * @author jorel
 */
public class Combat {
    //Variables//
    private int enemyInitiative;//Enemy's initiative vs your own
    private int playerInitiative;//Player initiative
    private boolean playerTurn;
    private static boolean activeCombat;//Whether you are still fighting
    private boolean hasWon = false;//Won in battle
    private Enemies enemy;
    private Adventurer player;
    private GameLogic game;
    private Room room;
    //Variables//
    
    //Constructor
    public Combat(GameLogic game, Enemies Target) {
    	this.enemy = Target;
    	this.game = game;
    	this.player = game.getPlayer();
    	this.room = player.getCurrentRoom();
    	rollInitiative();
    }
    
    //Methods//
	public int rollDice(String name, int number, int nSides)
    { 
		int num = 0;
        int roll = 0;
        Random  r = new Random(); 
        if(nSides >=3) 
        { 
        	for(int i = 0; i < number; i++)
            { 
                roll = r.nextInt(nSides)+1;
                System.out.println(name + roll);
                num = num + roll; 
            } 
        } 
        else
        { 
        	System.out.println("Error num needs to be from 3"); 
        } 
        return num;  
    } 
   
	public void rollInitiative() {
        activeCombat=true;
		
		//Roll initial initiative for player & enemy
		enemyInitiative=rollDice("Enemy initiative roll is ",1,20)+enemy.getSpeed();
		playerInitiative=rollDice("Player initiative roll is ",1,20) + player.getStatValue(Attributes.SPD);
        
		//Designate player as first hitter.
		if(playerInitiative>enemyInitiative) {
			playerTurn=true;
			atkAction();
        } else {
            playerTurn=false;
            turnOrder();
        }
    }
	
	public void turnOrder() {
		
		//Perform turn order action
		if(playerTurn==true) {
			System.out.println("Your turn in combat...");
		} else {
			System.out.println("Enemy rallies an attack!");
			defAction();
		}
	}
	
	public void atkAction() {
		//Roll attempt to attack

		//Player's rolls
        int atkStat=player.getStatValue(Attributes.ATK);
        int playerRoll=rollDice("Player attack roll is ",1,20)+atkStat;
        
        //Enemy's rolls
        int enemyDefense=enemy.getArmor();
        
        //Attack lands
        if(playerRoll > enemyDefense) {
        	int inDam = rollDice("You have landed an attack for ",1,6);//Damage Rolled
        	int curHP = enemy.getHitpoints()-inDam;//Damage removed from HP
        	enemy.setHitpoints(curHP);//Sustained Damage
        	playerTurn = false;
        } else {
        	System.out.println("You missed!");
        	playerTurn = false;
        }
        
        //If the enemy's HP drops to 0
        if(enemy.getHitpoints() <= 0) {
        	hasWon = true;
        } else {
            turnOrder();
        }
     }
	
     public void defAction() {
    	 //Roll attempt to defend from enemy
    	 int playerDefense = player.getArmor();
    	 int enemyRoll = rollDice("Enemy attack roll is ",1,20)+enemy.getChallengeRating();//Enemy attempt
    	 int playerRoll = rollDice("Player defense roll is ",1,20)+ playerDefense;
    	 
    	 //Attack lands
    	 if(playerRoll < enemyRoll) {
    		 int inDam=rollDice("Enemy hits you for ",1,6);//Damage Rolled
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
	public void fleeAction() {
		int playerFlee=rollDice("You attempt to flee...: ",1,20)+player.getStatValue(Attributes.SPD);
		int enemyCatch=rollDice("The enemy attempts to catch you...: ",1,20)+enemy.getSpeed();
		
		//Player succeeds
		if(playerFlee > enemyCatch) {
			System.out.println("Player fled from Combat!");
			activeCombat = false;
		} else {
			System.out.println("Enemy caught up to you!");
			playerTurn = false;
		}
		
		game.update();
	}
	
	//Getter Methods
	public boolean isCombatActive() {
		return activeCombat;
	}

	public boolean hasWon() {
		return hasWon;
                
	}

	public Enemies getEnemy() {
		return enemy;
	}

	public Room getRoom() {
		return room;
	}
}
