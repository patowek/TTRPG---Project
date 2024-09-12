/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Main.Java.Classes;

/***************************************************
 ***Name:Fighter.java**********************************
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
public class Fighter {
	// Variables//

	// **Variables//
	// **UNIQUE Variables//
	static String job;
	static int jobBoost;
	static String jobAbility;
	// **UNIQUE Variables//

	// ##Constructors##

	public Fighter() {
		// Basic already built non-customized object
	}

	public Fighter(String inName, int inStrength, int inIntelligence, int inWisdom, int inConstitution, int dexterity,
			int inCharisma, int inGold, int inHealth, int inMana) {// Constructor for the fighter object. Where you can
																	// allocate points

	}

	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^

	/// &&&&&START OF GET Race&&&&&//
	public static String getJob() {
		return job = "Fighter";
	}

	/// &&&&&END OF GET Race&&&&&//
	/// &&&&&START OF GET RacialAbility&&&&&//
	public static String getJobAbility() {
		// Code for racial abilities or stat boosts.
		return jobAbility;
	}
	/// &&&&&END OF GET RacialAbility&&&&&//

	/// &&&&&START OF GET RacialBoost&&&&&//
	public static String getjobBoost() {
		// Code for racial abilities or stat boosts.
		return String.valueOf(jobBoost);
	}
	/// &&&&&END OF GET RacialBoost&&&&&//

	// ^^^^^^^^^^^^^^^^^^^^^^^
	// ^^^Methods^^^^^^^^^^^^^
	// ^^^^^^^^^^^^^^^^^^^^^^^

}
