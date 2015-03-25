package printers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import characterData.DDCharacter;

public class XMLPrinterTest {

	@Test
	public void printSimpleCharacterTest(){
		DDCharacter character = new DDCharacter();
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Character'></DDCharacter>", xmlPrintout);
	}
	
	@Test
	public void printRenamedCharacterTest(){
		DDCharacter character = new DDCharacter("New Name");
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Name'></DDCharacter>", xmlPrintout);
	}
	
	@Test
	public void printSingleLeveledCharacterTest(){
		DDCharacter character = new DDCharacter();
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		
		character.levelUp("Fighter");
		
		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Character'><Class type= 'Fighter'></DDCharacter>", xmlPrintout);
	}
	
	@Test
	public void printDoubleLeveledCharacterTest(){
		DDCharacter character = new DDCharacter();
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		
		character.levelUp("Fighter");
		character.levelUp("Cleric");

		String xmlPrintout = printer.print(character);
		assertEquals("<DDCharacter name = 'New Character'><Class type= 'Fighter'><Class type= 'Cleric'></DDCharacter>", xmlPrintout);
	}
}

