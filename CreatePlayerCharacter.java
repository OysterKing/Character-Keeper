
import java.io.PrintWriter;
import java.util.Scanner;

/*Comhghall McKeating
 * This class creates new character files at the behest of the user.
 * This allows the program to save multiple characters.
 */

public class CreatePlayerCharacter {
	
	public void enterValues(){ 
		Scanner in = new Scanner(System.in);
		
		String[] attributeNames = new String[6];
		
		attributeNames[0] = "STRENGTH";
		attributeNames[1] = "CONSTITUTION";
		attributeNames[2] = "DEXTERITY";
		attributeNames[3] = "INTELLIGENCE";
		attributeNames[4] = "WISDOM";
		attributeNames[5] = "CHARISMA";
		
		try{
			PrintWriter out = new PrintWriter("CharacterTest.txt");
			for(int i = 0; i < 6; i++){
			
				System.out.println("Enter base " + attributeNames[i] + ": ");
				out.println(in.nextInt());
			}
			
			out.close();
			
		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught.");
		}	
		
	}

}
