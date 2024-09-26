/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import Classes.Adventurer;
import static Classes.Attributes.*;
import Enemies.Enemies;
import java.util.Random;
import Items.Item;
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
    int playerDefense=0;
  
    boolean activeCombat=false;//Whether you are still fighting
    boolean hasWon=false;//Won in battle
    Enemies enemy;
    //Variables//
    
    //Constructor
    public Combat(Adventurer player, Enemies Target) {
    	enemy=Target;
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
   
	public void rollInitiative(Adventurer player)
	{//Roll initial initiative for player & enemy
        

		enemyInitiative=rollDice(1,20)+enemy.getSpeed();//Enemy rolls their speed
		playerInitiative=rollDice(1,20)+player.getStat(HP);//Player rolls theirs
        
		if(playerInitiative>enemyInitiative)
		{//Designate player as first hitter.
			playerFirst=true;
                         playerTurn=true;
        }
         if(playerInitiative<enemyInitiative)
        {//Designate player as first hitter.
            playerFirst=false;
             playerTurn=false;
           
        }
        activeCombat=true; 
    }
	public void turnOrder()
		{//Perform turn order action
		if(playerFirst==true)
		{
			System.out.println("Choose your move");
                        playerTurn=true;
		}
		if(playerFirst==false)
		{
			System.out.println("Enemy rallies an attack!");
		}
                
	}
	public void atkAction(Adventurer player, Enemies enemy)
	{//Roll attempt to attack

		//Player's rolls//
        Item equippedWeapon = player.getGear(2);
        int atkStat=player.getStat(ATK);
        int wpnStat= convStat(equippedWeapon.getStat()[2]);
        int atkRoll=rollDice(1,20)+atkStat+wpnStat;
        //Player's rolls//
        int enemyDefense=enemy.getArmor();//Parse their armor in.
         
        if(atkRoll > enemyDefense)
        {//Attack lands
        	int inDam=rollDice(1,6);//Damage Rolled
        	int curHP=enemy.getHitpoints()-inDam;//Damage removed from HP
        	enemy.setHitpoints(curHP);//Sustained Damage
                playerTurn=false;
        }
        else
         {
             System.out.println("You missed!");
            playerTurn=false; 
         }
         if(enemy.getHitpoints()<=0)
         {//If the enemy's HP drops to 0
             hasWon=true;
             System.out.println("You have won against "+enemy.getName()+".");
         }
     }
     public void defAction(Adventurer player, Enemies enemy)
     {//Roll attempt to defend from enemy
    	 Item equippedShield = player.getGear(3);
    	 int equippedShieldValue = convStat(equippedShield.getStat()[2]);
    	 Item equippedHelm = player.getGear(0);
    	 int equippedHelmValue = convStat(equippedHelm.getStat()[2]);
    	 Item equippedArmor = player.getGear(1);
    	 int equippedArmorValue = convStat(equippedArmor.getStat()[2]);
    	 int totalDefense= equippedShieldValue + equippedHelmValue + equippedArmorValue;
    	 int enemyRoll=rollDice(1,20)+enemy.getChallengeRating();//Enemy attempt
    	 int defRoll=rollDice(1,20)+totalDefense;
    	 if(defRoll < enemyRoll)
    	 {//Attack lands
    		 int inDam=rollDice(1,6);//Damage Rolled
    		 int curHP=player.getStat(HP)-inDam;//Damage removed from HP
    		 player.setStat(HP,curHP);//Sustained Damage
                 playerTurn=true; 
    	 }
         else
         {
             System.out.println("Enemy misses!");
            playerTurn=true; 
         }
         if(player.getStat(HP)<=0)
         {//If the player's HP drops to 0
             hasWon=false;
              System.out.println("You have lost against "+enemy.getName()+".");
         }
	}
     
	public void fleeAction(Adventurer player,Enemies enemy)
	{//Action to flee from battle
		int playerFlee=rollDice(1,20)+player.getStat(HP);
		int enemyCatch=rollDice(1,20)+enemy.getSpeed();
		if(playerFlee > enemyCatch)
		{//Player succeeds
			System.out.println("Player fled from Combat!");
			activeCombat=false;
		}
		else
		{
			System.out.println("Enemy caught up to you!");
			activeCombat=true;
		}
          
	}
	public void useItem(Adventurer player)
	{//Use an item from your inventory
       
          
	}
	public boolean isCombatActive()
	{//Returns whether the battle is still ongoing or not
		return activeCombat;
	}
	//Methods//
        //Getter Methods//
	public boolean hasWon() {
            
		return hasWon;
                
	}
        public boolean getPlayerTurn() {
            
		return playerTurn;
                
	}
        //Getter Methods// 
}
