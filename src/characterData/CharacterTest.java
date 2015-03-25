package characterData;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;


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
