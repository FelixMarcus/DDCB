package characterData;

public class ClassLevel {

	private String name;

	public ClassLevel(String newName) {
		if(newName == null || newName.equals(""))
			throw new IllegalArgumentException("Blank string given for class type. Must be a non-blank string.");
		this.name = newName;
	}

	public String name() {
		return name;
	}

	public float bab() {
		if(name().equals("Fighter"))
			return 1;
		else 
			return 2/3;
	}
}
