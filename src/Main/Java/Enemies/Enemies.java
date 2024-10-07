package Enemies;

public class Enemies {
	private String uid;
	private String name;
	private int hitpoints;
	private int armor;
	private int speed;
	private int challengeRating;

	public Enemies(String[] line) {
		uid = line[0].trim();
		name = line[1].trim();
		armor = Integer.parseInt(line[3].trim());
		speed = Integer.parseInt(line[4].trim());
		challengeRating = Integer.parseInt(line[5].trim());
		hitpoints = Integer.parseInt(line[2].trim()) * challengeRating;
	}

	public String getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public int getArmor() {
		return armor;
	}

	public int getSpeed() {
		return speed;
	}

	public int getChallengeRating() {
		return challengeRating;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}
	
	

}
