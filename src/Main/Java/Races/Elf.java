/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

//Imports//

//Imports//
/***************************************************
 ***Name:Elf.java****************************
 ***Author:Jorel Singer*****************************
 ***Date: 9-8-2024**********************************
 ***Purpose: To create an object that holds stats***
 *********** and race and will be utilized by ******
 *********** the main Program for a text adventure**
 * *************************************************
 */
//**************************************************
//*******Version: 1.1*******************************
//*******Recent Changes: Removed duplicate vars*****
//**************************************************
//**************************************************
package Races;

import Classes.Adventurer;

/**
 * @param args the command line arguments
 */
public class Elf extends Adventurer {

	// **UNIQUE Variables//
	static String race;
	static int racialBoost;
	static String racialAbility;
	// **UNIQUE Variables//

	// ##Constructors##

	public Elf() { // Elf elfAdventurer = new Elf("Saiyos",1,3,3,2,2,2,2,10,10);//String inName,int
					// inStrength,
		name = "Saiyos";
	}

	public Elf(String inName, int inStrength, int inIntelligence, int inWisdom, int inConstitution, int inDexterity,
			int inCharisma, Attributes inGold, Attributes inHealth, int inMana) {// Constructor for the elf object. Where you can
																	// allocate HP
		name = inName;
		gold = inGold;
		health = inHealth;

	}

	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^

	/// &&&&&START OF GET Race&&&&&//
	public String getRace() {
		return race = "Elf";
	}

	/// &&&&&END OF GET Race&&&&&//
	/// &&&&&START OF GET RacialAbility&&&&&//
	public static String getRacialAbility() {
		// Code for racial abilities or stat boosts.
		return racialAbility;
	}
	/// &&&&&END OF GET RacialAbility&&&&&//

	/// &&&&&START OF GET RacialBoost&&&&&//
	public static String getRacialBoost() {
		// Code for racial abilities or stat boosts.
		return String.valueOf(racialBoost);
	}
	/// &&&&&END OF GET RacialBoost&&&&&//

	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^

}
