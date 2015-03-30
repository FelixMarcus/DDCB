package characterData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import characterData.utils.Attribute;

public class DDCharacter {

	private String name;
	private int level;
	private ArrayList<ClassLevel> charClass  = new ArrayList<>();

	private Map<Attribute, Integer> attributes = new HashMap<>();

	public DDCharacter(String newName) {
		this();
		rename(newName);
	}

	public DDCharacter() {
		name = "New Character";
		level = 0;
		attributes.put(Attribute.STR, 10);
		attributes.put(Attribute.DEX, 10);
		attributes.put(Attribute.CON, 10);
		attributes.put(Attribute.WIS, 10);
		attributes.put(Attribute.INT, 10);
		attributes.put(Attribute.CHA, 10);
	}

	public String name() {
		return name;
	}

	public void rename(String newName) {
		if(newName == "" || newName == null){
			newName = "Default Character Name";
		}

		name = newName;
	}

	public int level() {
		return level;
	}

	public void addClassLevel(ClassLevel classLevel) {
		if(classLevel.name().isEmpty() || classLevel.name() == null)
			throw new IllegalArgumentException("Blank class name passed on level up. Level up not continued.");
		level++;
		charClass.add(classLevel);
	}

	public Map<String, Integer> characterClass() {
		HashMap<String, Integer> classMap = new HashMap<>();
		for(ClassLevel classLevel: charClass){
			if(classMap.get(classLevel.name()) == null)
				classMap.put(classLevel.name(), 1);
			else
				classMap.put(classLevel.name(), classMap.get(classLevel.name())+1);
		}
				
		return classMap;
	}

	public int getAttribute(Attribute attr) {
		return attributes.get(attr);	
	}

	public void setAttribute(Attribute attr, int inStat) {
		if(inStat < 0)
			throw new IllegalArgumentException("Statistics cannot go below 0. Please check typing, or kill character.");
		else
			attributes.put(attr, inStat);
	}
}
