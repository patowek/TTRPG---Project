package project1;

public class Main {

	public static void main(String[] args) {
		Bandit a = new Bandit(1);
		Bat b = new Bat(1);
		AncientGoldDragon c = new AncientGoldDragon(1);
		
		System.out.println(a.getName());
		System.out.println(a.getArmorClass());
		System.out.println(a.getSpeed());
		System.out.println(a.getChallengeRating());
		System.out.println(b.getName());
		System.out.println(b.getArmorClass());
		System.out.println(b.getSpeed());
		System.out.println(b.getChallengeRating());
		System.out.println(c.getName());
		System.out.println(c.getArmorClass());
		System.out.println(c.getSpeed());
		System.out.println(c.getChallengeRating());
	}

}
