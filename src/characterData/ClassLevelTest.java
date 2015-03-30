package characterData;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClassLevelTest {

	@Test
	public void newClassTest(){
		ClassLevel testClass = new ClassLevel("Fighter");
		assertEquals("Fighter", testClass.name());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void newClassBlankNameTest(){
		ClassLevel testClass = new ClassLevel("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void newClassNullNameTest(){
		ClassLevel testClass = new ClassLevel(null);
	}
	
	@Test
	public void getFighterBABTest(){
		ClassLevel testClass = new ClassLevel("Fighter");
		assertEquals(1, testClass.bab(), 0.0001);
	}
	
	@Test
	public void getClericBABTest(){
		ClassLevel testClass = new ClassLevel("Cleric");
		assertEquals(2/3, testClass.bab(), 0.0001);
	}
}
