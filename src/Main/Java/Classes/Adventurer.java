/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Jorel Singer
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Map.Room;
import Items.Item;
/***************************************************
 *** Name:Adventurer.java***************************
 * Author:Jorel Singer***************************** 
 *Date:9-24-2024********************************** 
 *Purpose: To create an object that holds stats*** 
 *That will be utilized by the main***************
 * Program for a text adventure******************* 
 *************************************************
 */

//**************************************************
//*******Version: 1.5*******************************
//*******Recent Changes: Removed old methods********
//*******Simplified stats & getter/setter***********
//**********************Added race & class vars*****
public class Adventurer {
	// Variables//
	private String name;
	private Attributes attack = Attributes.ATK;
	private Attributes speed = Attributes.SPD;
	private Attributes defense = Attributes.DEF;
	private Attributes gold = Attributes.GP;
	private Attributes health = Attributes.HP;
	private String job;
	private String race;
	private Item[] inventory = new Item[7];//8 inv slots
	// Slot 0 - Head
	// Slot 1 - Armor
	// Slot 2 - Weapon
	// Slot 3 - Shield
	// Slot 4 - Accessory
	private Item[] gear= new Item[4];//five gear slots
	private Room currentRoom;
	
	private boolean hasWon;
	private boolean isDead;
	private int maxHP;


	//Constructors///
    public Adventurer() {
    	name="Janice";
    	job="fighter";
    	race="human";
	}
    
    
	public Adventurer(String inName, String inJob,String inRace, int inAtk, int inSpd, int inDef,int inGold,int inHealth, int inCount) {
		name=inName;
		job=inJob.toLowerCase();
		race=inRace.toLowerCase();
		attack.setValue(inAtk);
		speed.setValue(inSpd);
		defense.setValue(inDef);
		gold.setValue(inGold);
		health.setValue(inHealth);
		
		switch (race) {
			case "human":
				//Racial Bonuses +1 to all physical stats
				speed.modifyValue(1);
				defense.modifyValue(1);
				gold.modifyValue(1);
				health.modifyValue(1);
				break;
			case "dwarf":
				//Racial Bonuses +2 to all physical stats except magic power & AC
				attack.modifyValue(2);
				defense.modifyValue(2);
				health.modifyValue(2);
				break;
			case "elf":
				//Racial Bonuses +2 to magic power, and +1 to armor count from added dex
				speed.modifyValue(2);
				defense.modifyValue(1);
				break;
			default:
				throw new IllegalArgumentException("Invalid race: " + race);
		}
		
		switch (job) {
			case "mage":
				attack.modifyValue(2);
				speed.modifyValue(2);
				break;
			case "rogue":
				attack.modifyValue(1);
				speed.modifyValue(2);
				defense.modifyValue(1);
				health.modifyValue(1);
				break;
			case "fighter":
				//Starts with more defense and health.
			 	defense.modifyValue(2);
			 	health.modifyValue(2);
			 	break;
			default:
				throw new IllegalArgumentException("Invalid job: " + job);
		}
	
		maxHP = health.getValue();
	}
	//End of constructor


	
	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^
	public int findValue(Item[] values, Item query) {// Return where the value is found if the query is found.
		for (int i = 0; i < values.length; i++) {
			if (values[i] == query) {
				System.out.println("Array contains" + query + "  at index " + i);
				return i;
			}
		}
		System.out.println("Value not Found.");
		return -1;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/// &&&&&START OF GET RACE&&&&&//
	public String getRace(){
		return race;
	}
	/// &&&&&START OF GET RACE&&&&&//
	/// &&&&&START OF GET JOBCLASS&&&&&//
	public String getJob(){
		return job;
	}
	/**
	 * @return the armorCount
	 */
	public int getArmor() {
		return defense.getValue() + (speed.getValue()/2);
	}

	/// &&&&&START OF GET JOBCLASS&&&&&//
	/// &&&&&START OF GET STAT&&&&&//
	public int getStatValue(Attributes name) {
	    switch (name) {
        case ATK:
            return attack.getValue();
        case SPD:
            return speed.getValue();
        case DEF:
            return defense.getValue();
        case HP:
            return health.getValue();
        case GP:
            return gold.getValue();
        default:
            throw new IllegalArgumentException("Invalid attribute: " + name);
	    }
	}
	
	public Attributes getStat(Attributes name) {
	    switch (name) {
        case ATK:
            return attack;
        case SPD:
            return speed;
        case DEF:
            return defense;
        case HP:
            return health;
        case GP:
            return gold;
        default:
            throw new IllegalArgumentException("Invalid attribute: " + name);
	    }
	}

	/// &&&&&END OF GET STAT&&&&&//
	/// &&&&&Start OF SET STAT&&&&&//
	public void setStat(Attributes name, int value) {// Set the following
														// -Stats
														// -Mana
														// -Health
														// -Gold
		switch (name) {
			case ATK:
				attack.setValue(value);
				break;
			case SPD:
				speed.setValue(value);
				break;
			case DEF:
				defense.setValue(value);
				break;
			case HP:
				health.setValue(value);
				break;
			case GP:
				gold.setValue(value);
				break;
			default:
				throw new IllegalArgumentException("Invalid attribute: " + name);
		}
	}
	
	public void modifyStat(Attributes name, int value) {
		
		switch (name) {
			case ATK:
				attack.modifyValue(value);
				break;
			case SPD:
				speed.modifyValue(value);
				break;
			case DEF:
				defense.modifyValue(value);
				break;
			case HP:
				int proposed = health.getValue() + value;
				if (proposed > maxHP) {
					health.setValue(maxHP);
				} else {
					health.modifyValue(value);
				}
				break;
			case GP:
				gold.modifyValue(value);
				break;
			default:
				throw new IllegalArgumentException("Invalid attribute: " + name);
		}
	}

	/// &&&&&END OF SET STAT&&&&&//
	/// &&&&&END OF GET STAT&&&&&//
	public Item getGear(int slot) {// Get the following
												// -Helmet
												// -Armor
												// -Weapon
												// -Shield
												// -Accessory
		return gear[slot];
	
	}

	/// &&&&&END OF GET GEAR&&&&&//
	public Item[] getGear() {
		return gear;

	}

	/// &&&&&END OF SET GEAR&&&&&//
	public void setGear(int slot, Item newGear) {
			
		if (newGear != null) {
			gear[slot] = newGear;
			String[] stat = newGear.getStat();
			int value = Integer.parseInt(stat[2]);
			value = stat[1].equals("-") ? -value : value;
			modifyStat(Attributes.valueOf(stat[0]), value);
		} else {
			String[] stat = gear[slot].getStat();
			int value = -Integer.parseInt(stat[2]);
			value = stat[1].equals("-") ? -value : value;
			modifyStat(Attributes.valueOf(stat[0]), value);
			gear[slot] = newGear;
		}
	}
	/// &&&&&END OF SET GEAR&&&&&//

	/// &&&&&END OF SET ITEMS&&&&&//
	public Item getItems(Item name) {// Get the following
												// -Slot 0-7

		int index = findValue(inventory, name);
		// Search for a value that says 'none' if not return -1
		// If you find a value it will set it at the first instance 'none' slot
              
                
		return inventory[index];//Return name of item.

	}

	/// &&&&&END OF SET Items&&&&&//
	public Item[] getItems() {// Get the following
										// -Slot 0-7
		
		return inventory;//Return list of items.

	}

	/// &&&&&END OF SET Items&&&&&//
	/// &&&&&END OF SET ITEMS&&&&&//
	public void setItems(int slot, Item newItem) {// Get the following
														// Slots 0-7
			inventory[slot] = newItem;
		

	}

	/// &&&&&END OF SET Items&&&&&//
	/// Start of getCurrentRoom()///
	public Room getCurrentRoom() {
		return currentRoom;
	}
	/// End of getCurrentRoom()///

	/// Start of getCurrentRoom()///
	public void setCurrentRoom(Room newRoom) {
		currentRoom = newRoom;
	}
	/// End of getCurrentRoom()///
	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^
	public boolean hasWon() {
		return hasWon;
	}
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean value) {
		isDead = value;
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	public void getMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
}
