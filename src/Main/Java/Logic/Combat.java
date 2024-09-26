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
    int playerDefense=0;
    int enemyHP=0;//Enemy hitpoints
	int enemyDefense=0;//Enemy defense rating
    int enemyATK=0;//Based on their challenge rating
    int enemySpeed=0;//Their ability to catch you
    boolean activeCombat=false;
    boolean hasWon=false;
    //Variables//
    
    //Constructor
    public Combat(Adventurer player, Enemies Target) {
    	buildEnemy(Target);
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
    public void buildEnemy(Enemies enemy)
    {//Assemble Enemy stats
	enemyHP=enemy.getHitpoints();//Enemy hitpoints
	enemyDefense=enemy.getArmor();//Enemy defense rating
    enemyATK=enemy.getChallengeRating();//Based on their challenge rating
    enemySpeed=enemy.getSpeed();//Their ability to catch you
        
    }
	public void rollInitiative(Adventurer player)
	{//Roll initial initiative for player & enemy
        

		enemyInitiative=rollDice(1,20);
		playerInitiative=rollDice(1,20)+enemySpeed;
        
		if(playerInitiative>enemyInitiative)
		{//Designate player as first hitter.
			playerFirst=true;
        }
         if(playerInitiative<enemyInitiative)
        {//Designate player as first hitter.
            playerFirst=false;
        }
        activeCombat=true; 
    }
	public void turnOrder()
		{//Perform turn order action
		if(playerFirst=true)
		{
			System.out.println("Choose your move");
		}
		else
		{
			System.out.println("Enemy rallies an attack!");  
		}
	}
	public void atkAction(Adventurer player, Enemies enemy)
	{//Roll attempt to attack

		//Player's rolls//
        Item equippedWeapon = player.getGear(2);
        int atkStat=player.getStat(ATK);
        int wpnStat= Integer.parseInt(equippedWeapon.getStat()[2]);
        int atkRoll=rollDice(1,20)+atkStat+wpnStat;
        //Player's rolls//
        enemyDefense=enemy.getArmor();//Parse their armor in.
         
        if(atkRoll > enemyDefense)
        {//Attack lands
        	int inDam=rollDice(1,6);//Damage Rolled
        	int curHP=enemyHP-inDam;//Damage removed from HP
        	enemyHP=curHP;//Sustained Damage
        }
     }
     public void defAction(Adventurer player)
     {//Roll attempt to defend from enemy
    	 Item equippedShield = player.getGear(3);
    	 int equippedShieldValue = Integer.parseInt(equippedShield.getStat()[2]);
    	 Item equippedHelm = player.getGear(0);
    	 int equippedHelmValue = Integer.parseInt(equippedHelm.getStat()[2]);
    	 Item equippedArmor = player.getGear(1);
    	 int equippedArmorValue = Integer.parseInt(equippedArmor.getStat()[2]);
    	 int totalDefense= equippedShieldValue + equippedHelmValue + equippedArmorValue;
    	 int enemyRoll=rollDice(1,20)+enemyATK;//Enemy attempt
    	 int defRoll=rollDice(1,20)+totalDefense;
    	 if(defRoll < enemyRoll)
    	 {//Attack lands
    		 int inDam=rollDice(1,6);//Damage Rolled
    		 int curHP=player.getStat(HP)-inDam;//Damage removed from HP
    		 player.setStat(HP,curHP);//Sustained Damage
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

	public boolean hasWon() {
		return hasWon;
	}
    
}
