import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CharacterTest {

	@Test
	public void createNewCharacterTest(){
		DDCharacter character = new DDCharacter();
		assertEquals("New Character", character.name());
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
}
