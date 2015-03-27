package commandlinegui;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 1L;
	private String command;

	public InvalidCommandException(String command) {
		this.command = command;
	}
	
	public String command() {
		return command;
	}

}
