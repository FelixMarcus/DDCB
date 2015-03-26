package characterData.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AttributeTest {

	@Test
	public void bonusTest(){
		assertEquals(-2, Attribute.bonus(6));
		assertEquals(-2, Attribute.bonus(7));
		assertEquals(-1, Attribute.bonus(8));
		assertEquals(-1, Attribute.bonus(9));

		assertEquals(0, Attribute.bonus(10));

		assertEquals(0, Attribute.bonus(11));
		assertEquals(1, Attribute.bonus(12));
		assertEquals(1, Attribute.bonus(13));
		assertEquals(2, Attribute.bonus(14));
	}
}
