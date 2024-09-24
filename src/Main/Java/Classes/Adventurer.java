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
 *** Name:Adventurer.java**************************** Author:Jorel
 * Singer***************************** Date:
 * 9-8-2024********************************** Purpose: To create an object that
 * holds stats*** That will be utilized by the main****** Program for a text
 * adventure*********** *************************************************
 */

//**************************************************
//*******Version: 1.4*******************************
//*******Recent Changes: Removed Statitc vars &*****
//*******edited item and gear method****************
//********************** For Lists******************
public class Adventurer {
	// Variables//
	public String name;
	public   int strength;
	public   int intelligence;
	public   int wisdom;
	public   int constitution;
	public   int dexterity;
	public   int charisma;
	public   int gold;
	public   int health;
	public   int mana;
	public   int armorCount;// The character's difficulty to deal damage to them.
	public   String[] spells;
	// public   String[]
	// inventory={"None","None","None","None","None","None","None"};
	public Item[] inventory = { "None", "None", "None", "None", "None", "None", "None" };
	// Slot 0 - Head
	// Slot 1 - Armor
	// Slot 2 - Weapon
	// Slot 3 - Shield
	// Slot 4 - Accessory
	public Item[] gear = { "None", "None", "None", "None", "None" };
	public Room currentRoom;
	// **Variables//

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
		if (name == "Strength") {
			d = strength;
		}
		if (name == "Intelligence") {
			d = intelligence;
		}
		if (name == "Wisdom") {
			d = wisdom;
		}
		if (name == "Constitution") {
			d = constitution;
		}
		if (name == "Dexterity") {
			d = dexterity;
		}
		if (name == "Charisma") {
			d = charisma;
		}
		if (name == "Health") {
			d = health;
		}
		if (name == "Mana") {
			d = mana;
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
		if (name == "Strength") {
			strength = value;
		}
		if (name == "Intelligence") {
			intelligence = value;
		}
		if (name == "Wisdom") {
			wisdom = value;
		}
		if (name == "Constitution") {
			constitution = value;
		}
		if (name == "Dexterity") {
			dexterity = value;
		}
		if (name == "Charisma") {
			charisma = value;
		}
		if (name == "Health") {
			health = value;
		}
		if (name == "Mana") {
			mana = value;
		}
		if (name == "Gold") {
			gold = value;
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
	public void setItems(String slot, String newItem) {// Get the following
														// Slots 0-7
		int index;
		index = findValue(inventory, "None");
		// Search for a value that says 'none' if not return -1
		// If you find a value it will set it at the first instance 'none' slot
		if (index != -1) {
			inventory[index] = newItem;
		}
		if (name == "Slot 0") {
			inventory[0] = newItem;
		}
		if (name == "Slot 1") {
			inventory[1] = newItem;
		}
		if (name == "Slot 2") {
			inventory[2] = newItem;
		}
		if (name == "Slot 3") {
			inventory[3] = newItem;
		}
		if (name == "Slot 4") {
			inventory[4] = newItem;
		}
		if (name == "Slot 5") {
			inventory[5] = newItem;
		}
		if (name == "Slot 6") {
			inventory[6] = newItem;
		}
		if (name == "Slot 7") {
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
	

	/// &&&&&END OF GET SPELLS&&&&&//
	public  String getSpells(String name) {// Get the following
													// -Slot 0-7

		String d = " ";// Returned item
		if (name == "Slot 0") {
			d = spells[0];
		}
		if (name == "Slot 1") {
			d = spells[1];
		}
		if (name == "Slot 2") {
			d = spells[2];
		}
		if (name == "Slot 3") {
			d = spells[3];
		}
		if (name == "Slot 4") {
			d = spells[4];
		}
		if (name == "Slot 5") {
			d = spells[5];
		}
		if (name == "Slot 6") {
			d = spells[6];
		}
		if (name == "Slot 7") {
			d = spells[7];
		}
		return d;

	}

	/// &&&&&END OF GET Spells&&&&&//
	/// &&&&&END OF SET Items&&&&&//
	public String getSpells() {// Get the following
										// -Slot 0-7
		int i = 0;
		String totalSpells = "";
		for (i = 0; i < spells.length; i++) {
			if (i < spells.length - 1) {
				totalSpells += spells[i] + ", ";
			} else {
				totalSpells += spells[i];
			}
		}
		// i=items.length()-1;
		// items=items.substring(items.length(),i+1);

		return totalSpells;

	}

	/// &&&&&END OF SET SPELLS&&&&&//
	public  void SetSpells(String name, String newItem) {// Get the following
																// Slots 0-7

		if (name == "Slot 0") {
			spells[0] = newItem;
		}
		if (name == "Slot 1") {
			spells[1] = newItem;
		}
		if (name == "Slot 2") {
			spells[2] = newItem;
		}
		if (name == "Slot 3") {
			spells[3] = newItem;
		}
		if (name == "Slot 4") {
			spells[4] = newItem;
		}
		if (name == "Slot 5") {
			spells[5] = newItem;
		}
		if (name == "Slot 6") {
			spells[6] = newItem;
		}
		if (name == "Slot 7") {
			spells[7] = newItem;
		}

	}
	/// &&&&&END OF SET SPELLS&&&&&//

	
	

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
