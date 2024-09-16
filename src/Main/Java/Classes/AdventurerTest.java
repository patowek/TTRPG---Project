package Classes;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class AdventurerTest {

	@Test
	void valueShouldEqual0() {
		var adv = new Adventurer();
		String[] str = {"helmet", "boot"};
		assertTrue(adv.findValue(str, "helmet")==0);
	}
	@Test
	void valueShouldEqualNeg1() {
		var adv = new Adventurer();
		String[] str1 = {"nothing","something"};
		assertTrue(adv.findValue(str1, "boot")==-1);
	}

}
