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
	public String name;
	public   int atkPower;
	public   int magPower;
	public   int defense;
	public   int gold;
	public   int health;
	public  String jobClass;
	public String race;
	public   int armorCount;// The character's difficulty to deal damage to them.
	// public   String[]
	// inventory={"None","None","None","None","None","None","None"};
	public Item[] inventory;//8 inv slots
	// Slot 0 - Head
	// Slot 1 - Armor
	// Slot 2 - Weapon
	// Slot 3 - Shield
	// Slot 4 - Accessory
	public Item[] gear;//five gear slots
	public Room currentRoom;
	// **Variables//


	//Constructors///
        public Adventurer()
	{
	 name="Janice";
	 jobClass="Fighter";
         race="Human";
	 atkPower=5;
	 magPower=0;
	 defense=3;
	 gold=10;
	 health=10;
	 armorCount=10;// The character's difficulty to deal damage to them.
	 if(race.toLowerCase()=="human")
	 {
		 //Racial Bonuses +1 to all physical stats
                 atkPower=atkPower+1;
		 magPower=magPower+1;
		 defense=defense+1;
		 health=health+1;
		 armorCount=armorCount+1;
	 }
	 if(race.toLowerCase()=="dwarf")
	 {
		 //Racial Bonuses +2 to all physical stats except magic power & AC
                 atkPower=atkPower+2;
		 magPower=magPower+0;
		 defense=defense+2;
		 health=health+2;
		 armorCount=armorCount+0;
	 }
		 if(race.toLowerCase()=="elf")
	 {
		 //Racial Bonuses +2 to magic power, and +1 to armor count from added dex
                 atkPower=atkPower+0;
		 magPower=magPower+2;
		 defense=defense+0;
		 health=health+0;
		 armorCount=armorCount+1;
	 }
	}//end of constructor
	 public Adventurer(String inName, String inJob,String inRace, int inAtk, int inMag, int inDef,int inGold,int inHealth, int inCount)
	{
	 name=inName;
	 jobClass=inJob;
         race=inRace;
	 atkPower=inAtk;
	 magPower=inMag;
	 defense=inDef;
	 gold=inGold;
	 health=inHealth;
	 armorCount=inCount;// The character's difficulty to deal damage to them.
		 if(race.toLowerCase()=="human")
	 {
		 //Racial Bonuses +1 to all physical stats
                 atkPower=atkPower+1;
		 magPower=magPower+1;
		 defense=defense+1;
		 health=health+1;
		 armorCount=armorCount+1;
	 }
	 if(race.toLowerCase()=="dwarf")
	 {
		 //Racial Bonuses +2 to all physical stats except magic power & AC
                 atkPower=atkPower+2;
		 magPower=magPower+0;
		 defense=defense+2;
		 health=health+2;
		 armorCount=armorCount+0;
	 }
		 if(race.toLowerCase()=="elf")
	 {
		 //Racial Bonuses +2 to magic power, and +1 to armor count from added dex
                 atkPower=atkPower+0;
		 magPower=magPower+2;
		 defense=defense+0;
		 health=health+0;
		 armorCount=armorCount+1;
	 }
	}//End of constructor
	//Constructors///
	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^
	public int findValue(String[] values, String query) {// Return where the value is found if the query is found.
		for (int i = 0; i < values.length; i++) {
			if (values[i] == query) {
				System.out.println("Array contains" + query + "  at index " + i);
				return i;
			}
		}
		System.out.println("Value not Found.");
		return -1;
	}

	/// &&&&&START OF GET STAT&&&&&//
	public   int getStat(String name) {// Set the following
											// -Stats
											// -Mana
											// -Health
											// -Gold
		int d = 0;// Stat to return
		if (name == "atkPower") {
			d = strength;
		}
		if (name == "magPower") {
			d = intelligence;
		}
		if (name == "Defense") {
			d = constitution;
		}
		
		if (name == "Health") {
			d = health;
		}
		if (name == "Gold") {
			d = gold;
		}
		return d;
	}

	/// &&&&&END OF GET STAT&&&&&//
	/// &&&&&Start OF SET STAT&&&&&//
	public   void setStat(String name, int value) {// Set the following
														// -Stats
														// -Mana
														// -Health
														// -Gold
		int d = 0;// Stat to change to
		if (name == "atkPower") {
			strength=value;
		}
		if (name == "magPower") {
			intelligence=value;
		}
		if (name == "Defense") {
			constitution=value;
		}
		
		if (name == "Health") {
			health=value;
		}
		if (name == "Gold") {
			gold=value;
		}
	}

	/// &&&&&END OF SET STAT&&&&&//
	/// &&&&&END OF GET STAT&&&&&//
	public  Item getGear(Item name) {// Get the following
												// -Helmet
												// -Armor
												// -Weapon
												// -Shield
												// -Accessory
		String d = name.getName();// Gear to report back.
		if (name == "Armor") {
			d = gear[1];
		}
		if (name == "Weapon") {
			d = gear[2];
		}
		if (name == "Shield") {
			d = gear[3];
		}
		if (name == "Accessory") {
			d = gear[4];
		}
		if (name == "Helmet") {
			d = gear[0];
		}
		return d;
	}

	/// &&&&&END OF GET GEAR&&&&&//
	public Item getGear() {// Get the following
									// -Slot 0-7
		int i = 0;
		String totalGear = "";
		for (i = 0; i < gear.length; i++) {
			if (i < gear.length - 1) {
				totalGear += gear[i] + ", ";
			} else {
				totalGear += gear[i];
			}
		}
		// i=items.length()-1;
		// items=items.substring(items.length(),i+1);

		return totalGear;

	}

	/// &&&&&END OF SET GEAR&&&&&//
	public  void setGear(String slot, Item newGear) {// Get the following
																// -Helmet
																// -Armor
																// -Weapon
																// -Shield
																// -Accessory

		if (name == "Armor") {
			gear[1] = newGear;
		}
		if (name == "Weapon") {
			gear[2] = newGear;
		}
		if (name == "Shield") {
			gear[3] = newGear;
		}
		if (name == "Accessory") {
			gear[4] = newGear;
		}
		if (name == "Helmet") {
			gear[0] = newGear;
		}

	}
	/// &&&&&END OF SET GEAR&&&&&//

	/// &&&&&END OF SET ITEMS&&&&&//
	public Item getItems(Item name) {// Get the following
												// -Slot 0-7

		String d = name.getName();// Returned item
		index = findValue(inventory, newItem);
		// Search for a value that says 'none' if not return -1
		// If you find a value it will set it at the first instance 'none' slot
                for(int i=0;i<inventory.length;i++)
                {
		if (index!=-1) {//If it finds it then it'll give you the name of the item.
			d=inventory[index].getName();//Return name
		}
                }
		return d;//Return name of item.

	}

	/// &&&&&END OF SET Items&&&&&//
	public Item getItems() {// Get the following
										// -Slot 0-7
		int i = 0;
		String items = "";
		for (i = 0; i < inventory.length; i++) {
			if (i < inventory.length - 1) {
				items += inventory[i].getName() + ", ";
			} else {
				items += inventory[i].getName();
			}
		}
		// i=items.length()-1;
		// items=items.substring(items.length(),i+1);

		return items;//Return list of items.

	}

	/// &&&&&END OF SET Items&&&&&//
	/// &&&&&END OF SET ITEMS&&&&&//
	public void setItems(String slot, Item newItem) {// Get the following
														// Slots 0-7
		int index;
		index = findValue(inventory, "None");
		// Search for a value that says 'none' if not return -1
		// If you find a value it will set it at the first instance 'none' slot
		if (index != -1) {//If item is not found in the inventory add it
			inventory[index] = newItem;
		}
		if (slot == "Slot 0") {
			inventory[0] = newItem;
		}
		if (slot == "Slot 1") {
			inventory[1] = newItem;
		}
		if (slot == "Slot 2") {
			inventory[2] = newItem;
		}
		if (slot == "Slot 3") {
			inventory[3] = newItem;
		}
		if (slot == "Slot 4") {
			inventory[4] = newItem;
		}
		if (slot == "Slot 5") {
			inventory[5] = newItem;
		}
		if (slot == "Slot 6") {
			inventory[6] = newItem;
		}
		if (slot == "Slot 7") {
			inventory[7] = newItem;
		}

	}

	/// &&&&&END OF SET Items&&&&&//
	public void setItems(Item newItem) {// Get the following
											// Slots 0-7
		int index;
		index = findValue(inventory, newItem);
		// Search for a value that says 'none' if not return -1
		// If you find a value it will set it at the first instance 'none' slot
                for(int i=0;i<inventory.length;i++)
                {
		if (index==-1) {//If it does not return a value AKA not in your inventory
			inventory[index] = newItem;//Add item to inventory in null location
		}
		
                }
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
}
