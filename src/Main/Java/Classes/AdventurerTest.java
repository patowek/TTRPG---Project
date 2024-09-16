package Classes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdventurerTest {

	@Test
	void valueShouldEqual0() {
		var adv = new Adventurer();
		String[] str = {"helmet", "boot"};
		assertTrue(adv.findValue(str, "helmet")==0);
	}

}

/*
 * 	public int findValue(String[] values, String query) {// Return where the value is found if the query is found.
		for (int i = 0; i < values.length; i++) {
			if (values[i] == query) {
				System.out.println("Array contains" + query + "  at index " + i);
				return i;
			}
		}
		System.out.println("Value not Found.");
		return -1;
	}
 */