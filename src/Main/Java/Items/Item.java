package Items;

public class Item {
	private String uid;
	private String name;
	private String[] stat;
	private int type;

	// Constructor
	public Item(String[] line) {
		uid = line[0].trim();
		name = line[1].trim();
		stat = line[2].trim().split("(?=[+-])|(?<=[+-])");
		type = Integer.parseInt(line[3].trim());
	}
	
	public Item(String name, String stat, int type) {
		this.name = name;
		this.stat = stat.split("(?=[+-])|(?<=[+-])");
		this.type = type;
	}

	// Getters
	public String getUID() {
		return uid;
	}
	
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
