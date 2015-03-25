import java.util.ArrayList;
import java.util.List;


public class DDCharacter {

	private String name;
	private int level;
	private ArrayList<String> charClass  = new ArrayList<>();

	public DDCharacter(String newName) {
		this();
		rename(newName);
	}

	public DDCharacter() {
		name = "New Character";
		level = 0;
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

	public void levelUp(String inClass) {
		if(inClass.isEmpty() || inClass == null)
			throw new IllegalArgumentException("Blank class name passed on level up. Level up not continued.");
		
		level++;
		charClass.add(inClass);
	}

	public List characterClass() {
		return charClass;
	}



}
