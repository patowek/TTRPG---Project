/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.adventurer;
//Imports//
import com.mycompany.adventurer.Fighter;
import com.mycompany.adventurer.Mage;
import com.mycompany.adventurer.Rogue;
//Imports//
/***************************************************
 ***Name:Human.java****************************
 ***Author:Jorel Singer*****************************
 ***Date: 9-8-2024**********************************
 ***Purpose: To create an object that holds stats***
 *********** and race and will be utilized by ******
 *********** the main Program for a text adventure**
 * *************************************************
 */


    /**
     * @param args the command line arguments
     */
   public class Human extends Adventurer {
    //Variables//
    String name;
    static int strength;
    static int intelligence;
    static int wisdom;
    static int constitution;
    static int dexterity;
    static int charisma;
    static int gold;
    static int health;
    static int mana;
    static String[] spells;
    static String[] inventory={"None","None","None","None","None","None","None"};
    //Slot 0 - Head
    //Slot 1 - Armor
    //Slot 2 - Weapon
    //Slot 3 - Shield
    // Slot 4 - Accessory
    static String[] gear={"None","None","None","None","None"};
    //**Variables//
    //**UNIQUE Variables//
    static String race;
    static int racialBoost;
    static String racialAbility;
    //**UNIQUE Variables//
    
    //##Constructors##
    
    public Human()
    {
      //Basic already built non-customized object  
    }
    public Human(String inName,int inStrength,
            int inIntelligence, int inWisdom, int inConstitution,int dexterity,
            int inCharisma, int inGold, int inHealth, int inMana)
    {//Constructor for the Human object. Where you can allocate all stats
        
    }
    
     //^^^^^^^^^^^^^^^^^^^^^^^
    //^^^Methods^^^^^^^^^^^^^
    //^^^^^^^^^^^^^^^^^^^^^^^
    
    ///&&&&&START OF GET Race&&&&&//
    public static String getRace()
    {
        return race="Elf";
    }
    ///&&&&&END OF GET Race&&&&&//
    ///&&&&&START OF GET RacialAbility&&&&&//
    public static String getRacialAbility()
    {
        //Code for racial abilities or stat boosts.
        return racialAbility;
    }
    ///&&&&&END OF GET RacialAbility&&&&&//
    
     ///&&&&&START OF GET RacialBoost&&&&&//
    public static String getRacialBoost()
    {
        //Code for racial abilities or stat boosts.
        return String.valueOf(racialBoost);
    }
    ///&&&&&END OF GET RacialBoost&&&&&//
    
     //^^^^^^^^^^^^^^^^^^^^^^^
    //^^^Methods^^^^^^^^^^^^^
    //^^^^^^^^^^^^^^^^^^^^^^^
    
}

