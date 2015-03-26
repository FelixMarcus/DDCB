package characterBuilder;

import characterData.DDCharacter;
import printers.CharacterXMLPrinter;

public class CharacterBuilder {

	private DDCharacter character;

	public void newCharacter() {
		character = new DDCharacter();
	}
	
	public String save(CharacterXMLPrinter characterXMLPrinter) {
		return characterXMLPrinter.print(character);
	}
	
	
}
