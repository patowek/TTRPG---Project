package Items;

public class Item {
	private String name;
	private String[] stat;
	private int type;

	// Constructor
	public Item() {
		
	}
	
	public Item(String name, String stat, int type) {
		this.name = name;
		this.stat = stat.split("(?=[+-])|(?<=[+-])");;
		this.type = type;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String[] getStat() {
		return stat;
	}
	
	public int getType() {
		return type;
	}
}
