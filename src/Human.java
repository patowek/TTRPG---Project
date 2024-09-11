/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/***************************************************
 ***Name:Human.java****************************
 ***Author:Jorel Singer*****************************
 ***Date: 9-8-2024**********************************
 ***Purpose: To create an object that holds stats***
 *********** and race and will be utilized by ******
 *********** the main Program for a text adventure**
 * *************************************************
 */
//**************************************************
//*******Version: 1.1*******************************
//*******Recent Changes: Removed Duplicate vars*****
//**************************************************
//**************************************************

    /**
     * @param args the command line arguments
     */
   public class Human extends Adventurer {
   
    //**UNIQUE Variables//
    static String race;
    static int racialBoost;
    static String racialAbility;
    //**UNIQUE Variables//
    
    //##Constructors##
    
    public Human()
    {//Human("Lizette",1,3,3,2,2,2,2,10,10)
      //Basic already built non-customized object 
        name="Lizette";
        strength=1;
        intelligence=3;
        wisdom=3;
        constitution=2;
        dexterity=2;
        charisma=2;
        gold=10;
        health=10;
        mana=10; 
    }
    public Human(String inName,int inStrength,
            int inIntelligence, int inWisdom, int inConstitution,int inDexterity,
            int inCharisma, int inGold, int inHealth, int inMana)
     {//Constructor for the elf object. Where you can allocate HP
        name=inName;
        strength=inStrength;
        intelligence=inIntelligence;
        wisdom=inWisdom;
        constitution=inConstitution;
        dexterity=inDexterity;
        charisma=inCharisma;
        gold=inGold;
        health=inHealth;
        mana=inMana;
        
    }
    
     //^^^^^^^^^^^^^^^^^^^^^^^
    //^^^Methods^^^^^^^^^^^^^
    //^^^^^^^^^^^^^^^^^^^^^^^
    
    ///&&&&&START OF GET Race&&&&&//
    public static String getRace()
    {
        return race="Human";
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

