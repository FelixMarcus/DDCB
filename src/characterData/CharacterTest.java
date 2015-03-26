package characterData;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		character.levelUp("Fighter");
		assertEquals(1, character.level());
		assertEquals(Arrays.asList("Fighter"), character.characterClass());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void characterLevelUpBlankClassTest(){
		DDCharacter character = new DDCharacter();
		character.levelUp("");
	}
	
	@Test 
	public void characterLevelUpTwoClassTest(){
		DDCharacter character = new DDCharacter();
		character.levelUp("Fighter");
		assertEquals(1, character.level());
		assertEquals(Arrays.asList("Fighter"), character.characterClass());
		character.levelUp("Cleric");
		assertEquals(2, character.level());
		assertEquals(Arrays.asList("Fighter", "Cleric"), character.characterClass());
	}
}
