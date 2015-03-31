package characterBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import characterData.ClassLevel;
import characterData.DDCharacter;
import characterData.utils.Attribute;
import printers.CharacterXMLPrinter;

public class CharacterBuilder {

	private DDCharacter character;

	public void newCharacter() {
		character = new DDCharacter();
	}

	public String save(CharacterXMLPrinter characterXMLPrinter) {
		return characterXMLPrinter.print(character);
	}

	public void levelUp(String inClass) throws DDClassNotRecognisedException {

		ArrayList<String> classIndex = readInList();

		if(classIndex.contains(inClass))
			character.addClassLevel(new ClassLevel(inClass));
		else
			throw new DDClassNotRecognisedException(inClass +" is not a recognised class.");
	}

	private ArrayList<String> readInList() {
		ArrayList<String> classIndex = new ArrayList<>();
		String fileName  = "C:/Users/fmillne/Desktop/DDCB/Resources/ClassFileIndex";

		try(FileReader fileReader = new FileReader(fileName);
				BufferedReader buffReader = new BufferedReader(fileReader);){

			String line;

			while((line = buffReader.readLine()) != null){
				classIndex.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.print("Unable to find file: "+ fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem occured while loading list from file:"+ fileName);
			e.printStackTrace();
		}
		return classIndex;
	}

	public void setAttribute(Attribute attr, int inStat) {
		character.setAttribute(attr, inStat);
	}

	public void rename(String newName) {
		character.rename(newName);
	}

	public void setDetail(String detailKey, String detailValue) {
		character.setDetail(detailKey, detailValue);
	}	
}
