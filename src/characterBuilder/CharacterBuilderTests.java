package characterBuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import characterData.utils.Attribute;
import printers.CharacterXMLPrinter;

public class CharacterBuilderTests {

	@Test 
	public void saveNewCharacterTest(){
		CharacterBuilder builder = new CharacterBuilder();
		builder.newCharacter();
		String saveString = builder.save(new CharacterXMLPrinter());
		
		assertEquals("<DDCharacter name = 'New Character'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10></DDCharacter>", saveString);
	}
	
	@Test
	public void renameCharacterTest(){
		CharacterBuilder builder = new CharacterBuilder();
		builder.newCharacter();
		builder.rename("Onan");
		String saveString = builder.save(new CharacterXMLPrinter());
		
		assertEquals("<DDCharacter name = 'Onan'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10></DDCharacter>", saveString);
	}
	
	@Test
	public void addDetailsToCharacterTest(){
		CharacterBuilder builder = new CharacterBuilder();
		builder.newCharacter();
		builder.setDetail("Height", "175");
		String saveString = builder.save(new CharacterXMLPrinter());
		
		assertEquals("<DDCharacter name = 'New Character' height='175'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10></DDCharacter>", saveString);
	}
	
	@Test
	public void levelUpTest(){
		CharacterBuilder builder = new CharacterBuilder();
		builder.newCharacter();
		builder.levelUp("Fighter");
		String saveString = builder.save(new CharacterXMLPrinter());
		
		assertEquals("<DDCharacter name = 'New Character'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10><Class type='Fighter'></DDCharacter>", saveString);		
	}
	
	@Test
	public void changeAttributesTest(){
		CharacterBuilder builder = new CharacterBuilder();
		builder.newCharacter();
		builder.setAttribute(Attribute.STR, 11);
		builder.setAttribute(Attribute.DEX, 12);
		builder.setAttribute(Attribute.CON, 13);
		builder.setAttribute(Attribute.WIS, 14);
		builder.setAttribute(Attribute.INT, 15);
		builder.setAttribute(Attribute.CHA, 16);

		String saveString = builder.save(new CharacterXMLPrinter());
		
		assertEquals("<DDCharacter name = 'New Character'><Attributes str=11 dex=12 con=13 wis=14 int=15 cha=16></DDCharacter>", saveString);		
	}
}
