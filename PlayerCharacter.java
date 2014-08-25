import java.io.FileReader;
import java.util.Scanner;


/* Comhghall McKeating
 * Basic player character class
 */

public class PlayerCharacter {
	String name, race, character_class, characterFilePrefix;
	int level = 1; 
	int age, height, weight;
	Ability[] abilities = new Ability[6];
	Skill[] skills = new Skill[17];
	String[] abilityNames = new String[6];
	String[] skillNames = new String[17];
	
	public PlayerCharacter(String n, String r, String char_class, int a, int h, int w){
			name = n;
			characterFilePrefix = n;
			race = r;
			age = a;
			character_class = char_class;
			height = h;
			weight = w;
			
			//this array makes the code look a little neater as we can iterate through
			//it rather than have many conditions as when creating the skills.
			
			abilityNames[0] = "STRENGTH"; 
			abilityNames[1] = "CONSTITUTION";
			abilityNames[2] = "DEXTERITY";
			abilityNames[3] = "INTELLIGENCE";
			abilityNames[4] = "WISDOM";
			abilityNames[5] = "CHARISMA";
			
			//Load Abilities. Read in from a file created by the CreatePlayerCharacterClass
			
			try{
				FileReader readFile = new FileReader(characterFilePrefix + "Attributes.txt");
				Scanner in = new Scanner(readFile);
				for(int i = 0; i < 6; i++){
					abilities[i] = new Ability(abilityNames[i], Integer.parseInt(in.nextLine()));
					abilities[i].calculateAbilityMod();
				}
			}catch(Exception ex){
				System.out.println("Exception " + ex.getMessage() + " caught in PlayerCharacter.");
			}
			
			//Load skills.
			
			for(int i = 0; i < skills.length; i++){
				if(i == 0){
					skills[i] = new Skill("Acrobatics", false, 2);
					skills[i].calculateSkillMod();
				}
				
				if(i == 1){
					skills[i] = new Skill("Arcana", false, 3);
					skills[i].calculateSkillMod();
				}
				
				if(i == 2){
					skills[i] = new Skill("Athletics", true, 0);
					skills[i].calculateSkillMod();
				}
				
				if(i == 3){
					skills[i] = new Skill("Bluff", false, 5);
					skills[i].calculateSkillMod();
				}
				
				if(i == 4){
					skills[i] = new Skill("Diplomacy", false, 5);
					skills[i].calculateSkillMod();
				}
				
				if(i == 5){
					skills[i] = new Skill("Dungeoneering", false, 4);
					skills[i].calculateSkillMod();
				}
				
				if(i == 6){
					skills[i] = new Skill("Endurance", true, 1);
					skills[i].calculateSkillMod();
				}
				
				if(i == 7){
					skills[i] = new Skill("Heal", false, 4);
					skills[i].calculateSkillMod();
				}
				
				if(i == 8){
					skills[i] = new Skill("History", false, 3);
					skills[i].calculateSkillMod();
				}
				
				if(i == 9){
					skills[i] = new Skill("Insight", false, 4);
					skills[i].calculateSkillMod();
				}
				
				if(i == 10){
					skills[i] = new Skill("Intimidate", false, 5);
					skills[i].calculateSkillMod();
				}
				
				if(i == 11){
					skills[i] = new Skill("Nature", true, 4);
					skills[i].calculateSkillMod();
				}
				
				if(i == 12){
					skills[i] = new Skill("Perception", true, 4);
					skills[i].calculateSkillMod();
				}
				
				if(i == 13){
					skills[i] = new Skill("Religion", false, 3);
					skills[i].calculateSkillMod();
				}
				
				if(i == 14){
					skills[i] = new Skill("Stealth", false, 2);
					skills[i].calculateSkillMod();
				}
				
				if(i == 15){
					skills[i] = new Skill("Streetwise", false, 5);
					skills[i].calculateSkillMod();
				}
				
				if(i == 16){
					skills[i] = new Skill("Thievery", false, 2);
					skills[i].calculateSkillMod();
				}
			}
	}
	
	public class Ability{
			int value;
			String abilityName;
			private int modifier;
			private int lowest_mod = -4;
			private int lowest_value = 2;
			
			public Ability(String name, int val){
				value = val;
				abilityName = name;
			}
			
			public void calculateAbilityMod(){
					int temp = value - lowest_value;
					modifier = lowest_mod + temp/2 + level/2;
			}
			
			public void printAbility(){
				System.out.println(abilityName + ": " + value + " -> " + modifier);
			}
	}
	
	public class Skill{
			private String skill_name;
			private Boolean trained;
			private int skill_mod;
			private int abilityIndex;
			
			public Skill(String sname, Boolean train, int abilityMod){
					skill_name = sname;
					trained = train;
					abilityIndex = abilityMod;
			}
			
			public void calculateSkillMod(){
				if(trained == true){
					skill_mod = skill_mod + 5;
				}
				
				skill_mod = skill_mod + abilities[abilityIndex].modifier + level/2;
			}
			
			public void printSkill(){
				
				if(skill_mod < 0){
					System.out.println(skill_name + ": " + skill_mod);
				}
				
				else{
					System.out.println(skill_name + ": " + "+ " + skill_mod);
				}
			}
	}
	
	public void print_basic_info(){
		System.out.println("Name: " + name);
		System.out.println("Race: " + race);
		System.out.println("Class: " + character_class);
		System.out.println("Level: " + level);
		System.out.println("Age: " + age);
		System.out.println("Height(cm): " + height);
		System.out.println("Weight(kilo): " + weight);
	}
	
	public void printAbilityTable(){
		for(int i=0; i < abilities.length; i++){
			abilities[i].printAbility();
		}
	}
	
	public void printSkillTable(){
		for(int i=0; i < skills.length; i++){
			skills[i].printSkill();
		}
	}
	
}