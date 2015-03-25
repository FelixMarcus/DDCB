
public class DDCharacter {

	String name;
	
	public DDCharacter(String newName) {
		this();
		rename(newName);
	}
	
	public DDCharacter() {
		name = "New Character";
	}


	public String name() {
		return name;
	}

	public void rename(String newName) {
		name = newName;
	}

}
