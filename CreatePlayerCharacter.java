import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/*Comhghall McKeating
 * This class creates new character files at the behest of the user.
 * This allows the program to save multiple characters.
 */

public class CreatePlayerCharacter {

	String newCharacter;
	//	String tempRace;

	public CreatePlayerCharacter(String newCharacterName){
		newCharacter = newCharacterName;
	}

	public void create(){
		try{
			FileReader readFile = new FileReader(newCharacter + "BasicInfo.txt");
			Scanner in = new Scanner(readFile);
			PlayerCharacter Grell = new PlayerCharacter(in.nextLine(), in.nextLine(), in.nextLine(), 
					Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));

			Grell.print_basic_info();
			System.out.println();
			Grell.printAbilityTable();
			System.out.println();
			Grell.printSkillTable();
		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught in create.");
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
			PrintWriter out = new PrintWriter(newCharacter + "BasicInfo.txt");
			Scanner in = new Scanner(System.in);

			for(int i = 0; i < 6; i++){
				System.out.println("Enter " + basicInfo[i] + ": ");

				if(i == 1){
					//					tempRace = in.nextLine(); //need to use the race to adjust ability scores accordingly
					//					out.flush();
					//					out.println(tempRace);

					//					tempRace = "Human";
					out.println(in.nextLine());
				}

				else{
					out.println(in.nextLine());
				}
			}

			out.close();

		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught in enterBasicInfo");
		}

	}

	public void enterValues(){ 
		Scanner in = new Scanner(System.in);

		int temp;

		String[] abilityNames = new String[6];

		abilityNames[0] = "STRENGTH";
		abilityNames[1] = "CONSTITUTION";
		abilityNames[2] = "DEXTERITY";
		abilityNames[3] = "INTELLIGENCE";
		abilityNames[4] = "WISDOM";
		abilityNames[5] = "CHARISMA";

		try{
			PrintWriter out = new PrintWriter(newCharacter + "Attributes.txt");
			FileReader readFile = new FileReader(newCharacter + "BasicInfo.txt");
			Scanner inFile = new Scanner(readFile);

			while(inFile.hasNextLine()){
				
				System.out.println("CHECK");
				String line = inFile.nextLine();

				if("Dragonborn".equals(line)){ //+2 strength and charisma
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 0 || i == 5){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}




				else if("Dwarf".equals(line)){ //+2 constitution and wisdom
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 1 || i == 4){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}





				else if("Eladrin".equals(line)){ //+2 intelligence and dexterity
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 2 || i == 3){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}



				else if("Elf".equals(line)){ //+2 dexterity and wisdom
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 2 || i == 4){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}



				else if("Half-Elf".equals(line)){ //+2 constitution and charisma
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 1 || i == 5){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}



				else if("Halfling".equals(line)){ //+2 dexterity and charisma
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 2 || i == 5){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}



				else if("Human".equals(line)){ //+2 to one attribute of your choice

					int choiceAttribute;

					System.out.println("Choose attribute for racial bonus (+2): ");
					for(int i = 0; i < 6; i++){
						System.out.println(abilityNames[i] + ": " + i);
					}

					choiceAttribute = in.nextInt();
					System.out.println();

					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == choiceAttribute){
							temp = in.nextInt();
							temp += 2;
							out.println(temp);
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}



				else if("Tiefling".equals(line)){ //+2 to intelligence and charisma
					for(int i = 0; i < 6; i++){

						System.out.println("Enter base " + abilityNames[i] + ": ");

						if(i == 3 || i == 5){
							temp = in.nextInt();
							temp += 2;
						}

						else{
							out.println(in.nextInt());	
						}
					}
				}
			}	

			out.close();
			inFile.close();

		}catch(Exception ex){
			System.out.println("Exception " + ex.getMessage() + " caught in enter attributes.");
		}	

	}

}