
import java.util.Scanner;

/*Comhghall McKeating
 * This class creates new character files at the behest of the user.
 * This allows the program to save multiple characters.
 */

public class CreatePlayerCharacter {
	
	int[] temp = new int[6];
	
	public void enterValues(){ 
		Scanner in = new Scanner(System.in);
		
		String[] attributeNames = new String[6];
		
		attributeNames[0] = "STRENGTH";
		attributeNames[1] = "CONSTITUTION";
		attributeNames[2] = "DEXTERITY";
		attributeNames[3] = "INTELLIGENCE";
		attributeNames[4] = "WISDOM";
		attributeNames[5] = "CHARISMA";
		
		for(int i = 0; i < temp.length; i++){
			
			System.out.println("Enter base " + attributeNames[i] + ": ");
			temp[i] = in.nextInt();
		}
		
		/*Need to add the information entered into a file that can be read by the Player character class*/
		
	}

}
