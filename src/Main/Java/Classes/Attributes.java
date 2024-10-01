package Classes;

public enum Attributes {
	ATK("Attack", 0),
	SPD("Speed", 0),
	DEF("Defense", 0),
	HP("Health", 50),
	MHP("Max Health", 50),
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
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void modifyValue(int value) {
		this.value += value;
	}
	
	public String toString() {
		return name + ": " + value;
	}
}