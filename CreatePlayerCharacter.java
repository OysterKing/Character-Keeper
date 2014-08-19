
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*Comhghall McKeating
 * This class creates new character files at the behest of the user.
 * This allows the program to save multiple characters.
 */

public class CreatePlayerCharacter {
	
	public void create(){
		try{
			FileReader readFile = new FileReader("BasicCharacterinfo.txt");
			Scanner in = new Scanner(readFile);
			PlayerCharacter Grell = new PlayerCharacter(in.nextLine(), in.nextLine(), in.nextLine(), 
					Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
			
			Grell.print_basic_info();
			System.out.println();
			Grell.printAbilityTable();
			System.out.println();
			Grell.printSkillTable();
		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught.");
		}
	}
	
	public void enterBasicInfo(){
		String[] basicInfo = new String[6];
		
		basicInfo[0] = "Name";
		basicInfo[1] = "Race";
		basicInfo[2] = "Class";
		basicInfo[3] = "Age";
		basicInfo[4] = "Height(cm)";
		basicInfo[5] = "Weight(kg)";
		
		try{
			PrintWriter out = new PrintWriter("BasicCharacterInfo.txt");
			Scanner in = new Scanner(System.in);
			
			for(int i = 0; i < 6; i++){
				System.out.println("Enter " + basicInfo[i] + ": ");
				out.println(in.nextLine());
			}
			
			out.close();
			
		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught");
		}
		
	}
	
	public void enterValues(){ 
		Scanner in = new Scanner(System.in);
		
		
		
		String[] abilityNames = new String[6];
		
		abilityNames[0] = "STRENGTH";
		abilityNames[1] = "CONSTITUTION";
		abilityNames[2] = "DEXTERITY";
		abilityNames[3] = "INTELLIGENCE";
		abilityNames[4] = "WISDOM";
		abilityNames[5] = "CHARISMA";
		
		try{
			PrintWriter out = new PrintWriter("CharacterAttributes.txt");
			
			for(int i = 0; i < 6; i++){
			
				System.out.println("Enter base " + abilityNames[i] + ": ");
				out.println(in.nextInt());
			}
			
			out.close();
			
		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught.");
		}	
		
	}

}
