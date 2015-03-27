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
					characterBuilder = new CharacterBuilder();
					characterBuilder.newCharacter();
					if(splitInput.length >1)
						characterBuilder.rename(splitInput[1]);
					break;
				case "level":
					String className;
					if(splitInput.length == 1){
						className = readLine("Which Class?");
					}
					else
						className = splitInput[1];

					characterBuilder.levelUp(className);
					break;
				case "save":
					System.out.println(characterBuilder.save(new CharacterXMLPrinter()));
					break;
				case "exit":
					System.out.println("Quitting character builder");
					characterBuilder = null;
					keepRunning = false;
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
	
	private String readLine(String output) throws IOException {
	    if (System.console() != null) {
	        return System.console().readLine(output);
	    }
	    System.out.print(output);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(
	            System.in));
	    return reader.readLine();
	}
	
	public static void main(String[] argvs) throws IOException{
		CommandLineController controller = new CommandLineController();
		controller.run();
	}
}
