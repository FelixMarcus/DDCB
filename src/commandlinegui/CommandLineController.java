package commandlinegui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import printers.CharacterXMLPrinter;
import characterBuilder.CharacterBuilder;

public class CommandLineController {

	private CharacterBuilder characterBuilder;

	public void run() throws IOException{
		
		System.out.println("Starting Character Builder Interface");
		boolean keepRunning = true;
		
		while(keepRunning){
			String input = readLine("Type command...");

			String[] splitInput = input.split(" ");

			String command = splitInput[0];

			try{
				switch(command){
				case "create":
					createCommand(splitInput);
					break;
				case "level":
					levelCommand(splitInput);
					break;
				case "save":
					saveCommand();
					break;
				case "describe":
					describeCommand(splitInput);
					break;
				case "exit":
					keepRunning = exitCommand();
					break;
				default:
					throw new InvalidCommandException(command);
				}
			}
			catch(InvalidCommandException e){
				System.out.println("Command entered:"+ e.command() +" is not a valid command. To view list of valid commands and arguments, enter help.");
			}
		}
	}

	private boolean exitCommand() {
		boolean keepRunning;
		System.out.println("Quitting character builder");
		characterBuilder = null;
		keepRunning = false;
		return keepRunning;
	}

	private void describeCommand(String[] splitInput) throws IOException {
		if(splitInput.length >2)
			characterBuilder.setDetail(splitInput[1], splitInput[2]);
		else{
			String descriptor = readLine("descriptor:");
			String value = readLine("set as:");
			characterBuilder.setDetail(descriptor, value);
		}
	}

	private void saveCommand() {
		System.out.println(characterBuilder.save(new CharacterXMLPrinter()));
	}

	private void levelCommand(String[] splitInput) throws IOException {
		String className;
		if(splitInput.length == 1){
			className = readLine("Which Class?");
		}
		else
			className = splitInput[1];

		characterBuilder.levelUp(className);
	}

	private void createCommand(String[] splitInput) {
		characterBuilder = new CharacterBuilder();
		characterBuilder.newCharacter();
		if(splitInput.length >1)
			characterBuilder.rename(splitInput[1]);
	}
	
	private String readLine(String output) throws IOException {
	    if (System.console() != null) {
	        return System.console().readLine(output);
	    }
	    System.out.print(output);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    return reader.readLine();
	}
	
	public static void main(String[] argvs) throws IOException{
		CommandLineController controller = new CommandLineController();
		controller.run();
	}
}
