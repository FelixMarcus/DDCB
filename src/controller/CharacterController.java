package controller;

import characterData.DDCharacter;
import printers.CharacterXMLPrinter;

public class CharacterController {

	private DDCharacter character;

	public void newCharacter() {
		character = new DDCharacter();
	}

	public String save(CharacterXMLPrinter characterXMLPrinter) {
		return characterXMLPrinter.print(character);
	}
	
	
}
