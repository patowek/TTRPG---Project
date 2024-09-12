package Items;

import Classes.Adventurer;

public class Item {
	private String name;
	private String description;
	private boolean isCollectible;

	// Constructor
	public Item(String name, String description, boolean isCollectible) {
		this.name = name;
		this.description = description;
		this.isCollectible = isCollectible;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isCollectible() {
		return isCollectible;
	}

	// Method to use the item
	public void use(Adventurer player) {
		System.out.println("You use " + name);
	}
}
