package Classes;

public enum Attributes {
	STR("Strength", 10),
	DEX("Dexterity", 10),
	CON("Constitution", 10),
	INT("Intelligence", 10),
	WIS("Wisdom", 10),
	CHA("Charisma", 10),
	ATK("Attack Power", 0),
	MAG("Magic Power", 0),
	DEF("Defense", 0),
	HP("Health", 50),
	MP("Mana", 20),
	GP("Gold", 0);

	private final String name;
	private int value;
	
	Attributes(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBaseValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void modifyValue(int value) {
		this.value += value;
	}
}