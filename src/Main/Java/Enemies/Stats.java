package Enemies;

public class Stats {

	String hitpoints ="";
	String armor;
	String speed;
	String name;
	String challengeRating;

	// Getters

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
        public String getChallengeRating() {
		return challengeRating;
	}

	// Setters
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
	public void setChallengeRating(String newChallenge){
		this.challengeRating = newChallenge;
}
