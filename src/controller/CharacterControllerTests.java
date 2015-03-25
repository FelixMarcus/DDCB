package controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import characterData.DDCharacter;
import printers.CharacterXMLPrinter;

public class CharacterControllerTests {

	@Test 
	public void saveNewCharacterTest(){
		CharacterController controller = new CharacterController();
		controller.newCharacter();
		String saveString = controller.save(new CharacterXMLPrinter());
		
		CharacterXMLPrinter printer = new CharacterXMLPrinter();
		String controlString = printer.print(new DDCharacter());
		assertEquals(saveString, controlString);
	}
}
