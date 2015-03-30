package printers;

import characterData.DDCharacter;
import characterData.utils.Attribute;


public class CharacterXMLPrinter implements CharacterPrinter{

	public String print(DDCharacter character) {

		StringBuilder builder = new StringBuilder();
		builder.append("<DDCharacter name = '");
		builder.append(character.name());
		builder.append("'>");
		
		builder.append("<Attributes");
		for(Attribute attr: Attribute.values()){
			builder.append(" "+ attr.toString().toLowerCase() +"="+character.getAttribute(attr));
		}
		builder.append(">");
		
		for(String className: character.characterClass().keySet()){
			builder.append("<Class type='"+ className +"'>");
		}
		
		builder.append("</DDCharacter>");
		return builder.toString();
	}

	
}
