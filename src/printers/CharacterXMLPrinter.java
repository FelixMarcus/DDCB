package printers;

import java.text.DecimalFormat;

import characterData.DDCharacter;
import characterData.utils.Attribute;


public class CharacterXMLPrinter implements CharacterPrinter{

	public String print(DDCharacter character) {

		StringBuilder builder = new StringBuilder();
		builder.append("<DDCharacter name = '");
		builder.append(character.name());
		builder.append("'");


		for(String detail: character.detailsSet()){
			builder.append(" "+ detail.toLowerCase().replace(" ", "") +"='"+character.getDetail(detail)+"'");
		}

		builder.append(">");

		builder.append("<Attributes");
		for(Attribute attr: Attribute.values()){
			builder.append(" "+ attr.toString().toLowerCase() +"="+character.getAttribute(attr));
		}
		builder.append(">");

		builder.append(attackStats(character));

		for(String className: character.characterClass().keySet()){
			builder.append("<Class type='"+ className +"'>");
		}

		builder.append("</DDCharacter>");
		return builder.toString();
	}

	private String attackStats(DDCharacter character) {
		StringBuilder statBuilder = new StringBuilder();
		boolean nonzero = false;

		statBuilder.append("<AttackStats");
		if(character.bab() != 0){
			nonzero = true;
			statBuilder.append(" bab=");
			DecimalFormat df = new DecimalFormat("#.00");
			statBuilder.append(df.format(character.bab()));
			}
		statBuilder.append(">");
		
		if(nonzero)
			return statBuilder.toString();
		else
			return "";
	}


}
