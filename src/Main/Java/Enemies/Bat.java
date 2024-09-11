public class Bat extends Enemies {

	Bat(int multiplier) {
		this.setName("Bat");
		hitpoints = 1 * multiplier;
		armor = 12 * multiplier;
		speed = 5 * multiplier;
		challengeRating = 10 * multiplier;
	}

}
