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
//*******Version: 1.3*******************************
//*******Recent Changes: Added Room & Inventory*****
//*******Empty Slot detecting method****************
//********************** For Lists******************
public class Adventurer {
	// Variables//
	public String name;
	public static int strength;
	public static int intelligence;
	public static int wisdom;
	public static int constitution;
	public static int dexterity;
	public static int charisma;
	public static int gold;
	public static int health;
	public static int mana;
	public static int armorCount;// The character's difficulty to deal damage to them.
	public static String[] spells;
	// public static String[]
	// inventory={"None","None","None","None","None","None","None"};
	public static String[] inventory = { "None", "None", "None", "None", "None", "None", "None" };
	// Slot 0 - Head
	// Slot 1 - Armor
	// Slot 2 - Weapon
	// Slot 3 - Shield
	// Slot 4 - Accessory
	public static String[] gear = { "None", "None", "None", "None", "None" };
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
	public static int getStat(String name) {// Set the following
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
	public static void setStat(String name, int value) {// Set the following
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
	public static String getGear(String name) {// Get the following
												// -Helmet
												// -Armor
												// -Weapon
												// -Shield
												// -Accessory
		String d = "";// Gear to report back.
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
	public static String getGear() {// Get the following
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
	public static void setGear(String name, String newGear) {// Get the following
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
	public static String getItems(String name) {// Get the following
												// -Slot 0-7

		String d = "";// Returned item
		if (name == "Slot 0") {
			d = inventory[0];
		}
		if (name == "Slot 1") {
			d = inventory[1];
		}
		if (name == "Slot 2") {
			d = inventory[2];
		}
		if (name == "Slot 3") {
			d = inventory[3];
		}
		if (name == "Slot 4") {
			d = inventory[4];
		}
		if (name == "Slot 5") {
			d = inventory[5];
		}
		if (name == "Slot 6") {
			d = inventory[6];
		}
		if (name == "Slot 7") {
			d = inventory[7];
		}
		return d;

	}

	/// &&&&&END OF SET Items&&&&&//
	public static String getItems() {// Get the following
										// -Slot 0-7
		int i = 0;
		String items = "";
		for (i = 0; i < inventory.length; i++) {
			if (i < inventory.length - 1) {
				items += inventory[i] + ", ";
			} else {
				items += inventory[i];
			}
		}
		// i=items.length()-1;
		// items=items.substring(items.length(),i+1);

		return items;

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
	public void setItems(String newItem) {// Get the following
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
	/// &&&&&END OF SET REMOVE ITEMS&&&&&//
	public static void setRemoveItems(String name, String newItem) {// Get the following
																	// -Helmet
																	// -Armor
																	// -Weapon
																	// -Shield
																	// -Accessory

		if (name == "Slot 0") {
			inventory[0] = "None";
		}
		if (name == "Slot 1") {
			inventory[1] = "None";
		}
		if (name == "Slot 2") {
			inventory[2] = "None";
		}
		if (name == "Slot 3") {
			inventory[3] = "None";
		}
		if (name == "Slot 4") {
			inventory[4] = "None";
		}
		if (name == "Slot 5") {
			inventory[5] = "None";
		}
		if (name == "Slot 6") {
			inventory[6] = "None";
		}
		if (name == "Slot 7") {
			inventory[7] = "None";
		}

	}
	/// &&&&&END OF SET REMOVE Items&&&&&//

	/// &&&&&END OF GET SPELLS&&&&&//
	public static String getSpells(String name) {// Get the following
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
	public static String getSpells() {// Get the following
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
	public static void SetSpells(String name, String newItem) {// Get the following
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

	/// &&&&&END OF SAVING THROW&&&&&//
	public static void savingThrow() {
		// Put code for Saving Throw here
	}
	/// &&&&&END OF SAVING THROW&&&&&//

	/// &&&&&END OF SKILL CHECK&&&&&//
	public static void skillCheck() {
		// Put code for Skill Check here
	}
	/// &&&&&END OF SKIL CHECK&&&&&//

	/// &&&&&END OF ACTION ATTACK&&&&&//
	public static void actionAttack() {
		// Put code for Attack Action here
	}
	/// &&&&&END OF ACTION ATTACK&&&&&//

	/// &&&&&END OF ACTION DEFEND&&&&&//
	public static void actionDefend() {
		// Put code for Defend Action here
	}
	/// &&&&&END OF ACTION DEFEND&&&&&//

	/// &&&&&END OF ACTION SPELL&&&&&//
	public static void actionSpell() {
		// Put code for Spell Action here
	}
	/// &&&&&END OF ACTION SPELL&&&&&//

	/// &&&&&END OF ACTION HIDE&&&&&//
	public static void actionHide() {
		// Put code for Hide Action here
	}

	/// &&&&&END OF ACTION HIDE&&&&&//
	/// Start of Calculate Armor Count///
	public static void calculateAC() {// Calculate the armorcount of a character
										// Base AC = 10, if Dex is 10 or higher then modifier 0, -1 at 9 or lower.
										// If modifier is 12 or higher then modifier is +1
										// Shield gives +2 AC
										// Hide Armor turns base AC to 12
										// Chain shirt armor gives 13
										// Elven chain, scale or breastplate add 14
										// Half plate is 15
										// Ringmail is 14
										// Chain mail is 15
										// SPlint armor is 17
										// Plate is 18
		if ("None" != gear[1]) {// Slot 1 - Armor
								// Slot 0 - Head

			// Slot 2 - Weapon
			// Slot 3 - Shield
			// Slot 4 - Accessory

		}
		if ("None" != gear[3]) {// Slot 3 - Shield
			armorCount = 10 + 2;

		} else {
			armorCount = armorCount - 2;
		}
	}
	/// End of Calculate Armor Count///

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
