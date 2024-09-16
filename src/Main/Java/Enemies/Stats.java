package Enemies;

public class Stats {
	int strength;
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	String hitpoints ="";
	String armor;
	String speed;
	String name;
	String challengeRating;

	// Getters
	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public String getHitpoints() {
		return hitpoints;
	}

	public String getArmor() {
		return armor;
	}

	public String getSpeed() {
		return speed;
	}

	public String getName() {
		return name;
	}

	// Setters
	public void setStrength(int newStrength) {
		this.strength = newStrength;
	}

	public void setDexterirty(int newDexterity) {
		this.dexterity = newDexterity;
	}

	public void setConstitution(int newConstitution) {
		this.constitution = newConstitution;
	}

	public void setIntelligence(int newIntelligence) {
		this.intelligence = newIntelligence;
	}

	public void setWisdom(int newWisdom) {
		this.wisdom = newWisdom;
	}

	public void setCharisma(int newCharisma) {
		this.charisma = newCharisma;
	}

	public void setHitpoints(String newHitpoints) {
		this.hitpoints = newHitpoints;
	}

	public void setArmorClass(String newArmor) {
		this.armor = newArmor;
	}

	public void setSpeed(String newSpeed) {
		this.speed = newSpeed;
	}

	public void setName(String newName) {
		this.name = newName;
	}
}
