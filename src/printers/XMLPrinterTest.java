package printers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import characterData.ClassLevel;
import characterData.DDCharacter;

public class XMLPrinterTest {

	@Test
	public void printSimpleCharacterTest(){
		DDCharacter character = new DDCharacter();
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Character'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10></DDCharacter>", xmlPrintout);
	}
	
	@Test
	public void printRenamedCharacterTest(){
		DDCharacter character = new DDCharacter("New Name");
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Name'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10></DDCharacter>", xmlPrintout);
	}
	
	@Test
	public void printDetailedCharacterTest(){
		DDCharacter character = new DDCharacter("New Name");
		character.setDetail("Eye Colour", "Blue");
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Name' eyecolour='Blue'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10></DDCharacter>", xmlPrintout);
	}

	@Test
	public void printSingleLeveledCharacterTest(){
		DDCharacter character = new DDCharacter();
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		
		character.addClassLevel(new ClassLevel("Fighter"));
		
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Character'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10><AttackStats bab=1.00><Class type='Fighter'></DDCharacter>", xmlPrintout);
	}
	
	@Test
	public void printDoubleLeveledCharacterTest(){
		DDCharacter character = new DDCharacter();
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		
		character.addClassLevel(new ClassLevel("Fighter"));
		character.addClassLevel(new ClassLevel("Cleric"));

		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Character'><Attributes str=10 dex=10 con=10 wis=10 int=10 cha=10><AttackStats bab=1.66><Class type='Fighter'><Class type='Cleric'></DDCharacter>", xmlPrintout);
	}
}

