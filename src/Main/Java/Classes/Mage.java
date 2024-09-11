/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.adventurer;

/***************************************************
 ***Name:Mage.java**********************************
 ***Author:Jorel Singer*****************************
 ***Date: 9-8-2024**********************************
 ***Purpose: To create an object that holds spells**
 *********** and will be utilized by ***************
 *********** the main Program for a text adventure**
 * *************************************************
 */

/**
 * @param args the command line arguments
 */
public class Mage {
	// Variables//

	// **Variables//
	// **UNIQUE Variables//
	static String job;
	static int jobBoost;
	static String jobAbility;
	// **UNIQUE Variables//

	// ##Constructors##

	public Mage() {
		// Basic already built non-customized object
	}

	public Mage(String inName, int inStrength, int inIntelligence, int inWisdom, int inConstitution, int dexterity,
			int inCharisma, int inGold, int inHealth, int inMana) {// Constructor for the elf object. Where you can
																	// allocate HP

	}

	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^

	/// &&&&&START OF GET Race&&&&&//
	public static String getJob() {
		return job = "Mage";
	}

	/// &&&&&END OF GET Race&&&&&//
	/// &&&&&START OF GET RacialAbility&&&&&//
	/// &&&&&START OF GET RacialAbility&&&&&//
	public static String getJobAbility() {
		// Code for job abilities.
		return jobAbility;
	}
	/// &&&&&END OF GET RacialAbility&&&&&//

	/// &&&&&START OF GET RacialBoost&&&&&//
	public static String getjobBoost() {
		// Code for job stat boosts.
		return String.valueOf(jobBoost);
	}
	/// &&&&&END OF GET RacialBoost&&&&&//

	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^

}
