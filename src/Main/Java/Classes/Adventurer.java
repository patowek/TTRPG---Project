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
import Attributes.*;
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
	 Attributes atkPower = Attributes.ATK;
	 Attributes magPower = Attributes.MAG;
	 Attributes defense = Attributes.DEF;
         Attributes gold = Attributes.GP;
	 Attributes health = Attributes.HP;
	public  String jobClass;
	public String race;
	public   int armorCount;// The character's difficulty to deal damage to them.
	// public   String[]
	// inventory={"None","None","None","None","None","None","None"};
	public Item[] inventory = new Item[7];//8 inv slots
	// Slot 0 - Head
	// Slot 1 - Armor
	// Slot 2 - Weapon
	// Slot 3 - Shield
	// Slot 4 - Accessory
	public Item[] gear= new Item[4];//five gear slots
	public Room currentRoom;
	// **Variables//


	//Constructors///
        public Adventurer()
	{
	 name="Janice";
	 jobClass="Fighter";
         race="Human";
	
	
	}//end of constructor
	 public Adventurer(String inName, String inJob,String inRace, int inAtk, int inMag, int inDef,int inGold,int inHealth, int inCount)
	{
	 name=inName;
	 jobClass=inJob;
         race=inRace;
	
		 if(race.toLowerCase()=="human")
	 {
		 //Racial Bonuses +1 to all physical stats
                atkPower.setValue(inAtk+1);
	 	magPower.setValue(inMag+1);
	 	defense.setValue(inDef+1);
	 	gold.setValue(inGold+1);
	 	health.setValue(inHealth+1);
		
	 }
	 if(race.toLowerCase()=="dwarf")
	 {
		 //Racial Bonuses +2 to all physical stats except magic power & AC
                 atkPower.setValue(inAtk+2);
	 	magPower.setValue(inMag);
	 	defense.setValue(inDef+2);
	 	gold.setValue(inGold);
	 	health.setValue(inHealth+2);
	 }
		 if(race.toLowerCase()=="elf")
	 {
		 //Racial Bonuses +2 to magic power, and +1 to armor count from added dex
                atkPower.setValue(inAtk);
	 	magPower.setValue(inMag+2);
	 	defense.setValue(inDef+1);
	 	gold.setValue(inGold);
	 	health.setValue(inHealth);
	 }
	}//End of constructor
	//Constructors///
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
	/// &&&&&START OF GET RACE&&&&&//
	public String getRace(){
	return race;
	}
	/// &&&&&START OF GET RACE&&&&&//
	/// &&&&&START OF GET JOBCLASS&&&&&//
	public String getJobClass(){
	return jobClass;
	}
	/// &&&&&START OF GET JOBCLASS&&&&&//
	/// &&&&&START OF GET STAT&&&&&//
	public   int getStat(Attributes name) {// Set the following
											// -Stats
											// -Mana
											// -Health
											// -Gold
		int d = 0;// Stat to return
		if (name == ATK) {
			d = atkPower.getValue();
		}
		if (name == MAG) {
			d = magPower.getValue();
		}
		if (name == DEF) {
			d = defense.getValue();
		}
		
		if (name == HP) {
			d = health.getValue();
		}
		if (name == GP) {
			d = gold.getValue();
		}
		return d;
	}

	/// &&&&&END OF GET STAT&&&&&//
	/// &&&&&Start OF SET STAT&&&&&//
	public   void setStat(Attributes name, int value) {// Set the following
														// -Stats
														// -Mana
														// -Health
														// -Gold
		int d = 0;// Stat to change to
		if (name == ATK) {
			atkPower.setValue(value);
		}
		if (name == MAG) {
			magPower.setValue(value);
		}
		if (name == DEF) {
			defense.setValue(value);
		}
		
		if (name == HP) {
			health.setValue(value);
		}
		if (name == GP) {
			gold.setValue(value);
		}
	}

	/// &&&&&END OF SET STAT&&&&&//
	/// &&&&&END OF GET STAT&&&&&//
	public  Item getGear(integer slot) {// Get the following
												// -Helmet
												// -Armor
												// -Weapon
												// -Shield
												// -Accessory
		return gear[slot];// Gear to report back.
	
	}

	/// &&&&&END OF GET GEAR&&&&&//
	public Item getGear() {// Get the following
									// -Slot 0-7
		

		return gear;

	}

	/// &&&&&END OF SET GEAR&&&&&//
	public  void setGear(integer slot, Item newGear) {// Get the following
																// -Helmet
																// -Armor
																// -Weapon
																// -Shield
																// -Accessory
			gear[slot] = newGear;
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
	public Item getItems() {// Get the following
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
}
