package characterData;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import characterData.utils.Attribute;

public class CharacterTest {

	@Test
	public void createNewCharacterTest(){
		DDCharacter character = new DDCharacter();
		assertEquals("New Character", character.name());
		assertEquals(0, character.level());
	}
	
	@Test
	public void createNamedCharacterTest(){
		DDCharacter character = new DDCharacter("Onan");
		assertEquals("Onan", character.name());
	}
	
	@Test
	public void createNewCharacterChangeNameTest(){
		DDCharacter character = new DDCharacter();
		assertEquals("New Character", character.name());
		character.rename("Renamed");
		assertEquals("Renamed", character.name());
	}
	
	@Test
	public void setDetailTest(){
		DDCharacter character = new DDCharacter();
		character.setDetail("Hair Colour", "Brown");
		assertEquals(character.getDetail("hair colour"), "Brown");
	}
	
	@Test 
	public void defaultCharacterAttributesTest(){
		DDCharacter character = new DDCharacter();
		assertEquals(10, character.getAttribute(Attribute.STR));
		assertEquals(10, character.getAttribute(Attribute.DEX));
		assertEquals(10, character.getAttribute(Attribute.CON));
		assertEquals(10, character.getAttribute(Attribute.WIS));
		assertEquals(10, character.getAttribute(Attribute.INT));
		assertEquals(10, character.getAttribute(Attribute.CHA));
	}
	
	@Test
	public void changeAttributeTest(){
		DDCharacter character = new DDCharacter();
		character.setAttribute(Attribute.STR, 11);
		character.setAttribute(Attribute.DEX, 12);
		character.setAttribute(Attribute.CON, 13);
		character.setAttribute(Attribute.WIS, 14);
		character.setAttribute(Attribute.INT, 15);
		character.setAttribute(Attribute.CHA, 16);
		
		assertEquals(11, character.getAttribute(Attribute.STR));
		assertEquals(12, character.getAttribute(Attribute.DEX));
		assertEquals(13, character.getAttribute(Attribute.CON));
		assertEquals(14, character.getAttribute(Attribute.WIS));
		assertEquals(15, character.getAttribute(Attribute.INT));
		assertEquals(16, character.getAttribute(Attribute.CHA));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void changeAttributeToNegativeTest(){
		DDCharacter character = new DDCharacter();
		character.setAttribute(Attribute.STR, -1);
	}
	
	@Test
	public void createBlankNameTest(){
		DDCharacter character = new DDCharacter();
		assertEquals("New Character", character.name());
		character.rename("");
		assertEquals("Default Character Name", character.name());
		character.rename(null);
		assertEquals("Default Character Name", character.name());
	}
	
	@Test 
	public void characterGetFirstLevelTest(){
		DDCharacter character = new DDCharacter();
		assertEquals(0, character.level());
	}
	
	@Test 
	public void characterLevelUpTest(){
		DDCharacter character = new DDCharacter();
		character.addClassLevel(new ClassLevel("Fighter"));
		assertEquals(1, character.level());
		Integer testClassLevel = character.characterClass().get("Fighter");
		assertEquals(Integer.valueOf(1), testClassLevel);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void characterLevelUpBlankClassTest(){
		DDCharacter character = new DDCharacter();
		character.addClassLevel(new ClassLevel(""));
	}
	
	@Test 
	public void characterLevelUpTwoClassTest(){
		DDCharacter character = new DDCharacter();
		
		character.addClassLevel(new ClassLevel("Fighter"));
		
		assertEquals(1, character.level());
		Integer testClassLevel = character.characterClass().get("Fighter");
		assertEquals(Integer.valueOf(1), testClassLevel);
		
		character.addClassLevel(new ClassLevel("Cleric"));
		
		assertEquals(2, character.level());
		
		testClassLevel = character.characterClass().get("Fighter");
		assertEquals(Integer.valueOf(1), testClassLevel);
		testClassLevel = character.characterClass().get("Cleric");
		assertEquals(Integer.valueOf(1), testClassLevel);
	}
	
	@Test 
	public void characterGetBABTest(){
		DDCharacter character = new DDCharacter();
		
		character.addClassLevel(new ClassLevel("Fighter"));
		
		assertEquals(1, character.bab(), 0.0001);
		
		character = new DDCharacter();
		character.addClassLevel(new ClassLevel("Cleric"));
		assertEquals(0.666, character.bab(), 0.001);
		
		character.addClassLevel(new ClassLevel("Fighter"));
		
		assertEquals(1.666, character.bab(), 0.001);
	}
}
