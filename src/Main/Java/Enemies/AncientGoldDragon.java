public class AncientGoldDragon extends Enemies{
	
	AncientGoldDragon(int multiplier){
		this.setName("Ancient Golden Dragon");
		hitpoints = 546 * multiplier;
		armor = 22 * multiplier;
		speed = 40 * multiplier;
		challengeRating = 62000 * multiplier;
	}

}