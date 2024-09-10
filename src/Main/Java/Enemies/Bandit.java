public class Bandit extends Enemies{
	
	Bandit(int multiplier){
		this.setName("Bandit");
		hitpoints = 11 * multiplier;
		armor = 12 * multiplier;
		speed = 30 * multiplier;
		challengeRating = 25 * multiplier;
	}

}