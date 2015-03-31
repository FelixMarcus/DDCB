package characterBuilder;

import characterData.ClassLevel;
import characterData.DDCharacter;
import characterData.utils.Attribute;
import printers.CharacterXMLPrinter;

public class CharacterBuilder {

	private DDCharacter character;

	public void newCharacter() {
		character = new DDCharacter();
	}
	
	public String save(CharacterXMLPrinter characterXMLPrinter) {
		return characterXMLPrinter.print(character);
	}

	public void levelUp(String inClass) {
		
		character.addClassLevel(new ClassLevel(inClass));
	}

	public void setAttribute(Attribute attr, int inStat) {
		character.setAttribute(attr, inStat);
	}

	public void rename(String newName) {
		character.rename(newName);;
	}

	public void setDetail(String detailKey, String detailValue) {
		character.setDetail(detailKey, detailValue);
	}	
}
