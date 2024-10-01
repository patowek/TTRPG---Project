package Map;

public enum Directions {
	NORTH("north"), 
	SOUTH("south"), 
	EAST("east"), 
	WEST("west");


	private final String name;

	Directions(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static Directions fromString(String direction) {
		try {
	        return Directions.valueOf(direction.toUpperCase());
	    } catch (IllegalArgumentException e) {
	        return null; // or throw a custom exception
	    }
	}
}