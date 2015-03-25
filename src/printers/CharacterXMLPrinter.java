package printers;

import characterData.DDCharacter;


public class CharacterXMLPrinter implements CharacterPrinter{

	public String print(DDCharacter character) {

		StringBuilder builder = new StringBuilder();
		builder.append("<DDCharacter name = '");
		builder.append(character.name());
		builder.append("'>");
		
		for(String className: character.characterClass()){
			builder.append("<Class type= '"+ className +"'>");
		}
		
		builder.append("</DDCharacter>");
		return builder.toString();
	}

	
}
