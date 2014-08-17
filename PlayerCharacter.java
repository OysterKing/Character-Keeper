
/* Comhghall McKeating
 * Basic player character class
 */

public class PlayerCharacter {
	String name, race, character_class;
	int level, age, height, weight;
	Ability[] abilities = new Ability[6];
	Skill[] skills = new Skill[17];
	
	public PlayerCharacter(String n, String r, String char_class, int lvl, int a, int h, int w){
			name = n;
			race = r;
			age = a;
			character_class = char_class;
			level = lvl;
			height = h;
			weight = w;
			
			for(int i = 0; i < abilities.length; i++){
				if(i == 0){
					abilities[i] = new Ability("Strength", 18);
					abilities[i].calculateAbilityMod();
				}
				
				if(i == 1){
					abilities[i] = new Ability("Constitution", 18);
					abilities[i].calculateAbilityMod();
				}
				
				if(i == 2){
					abilities[i] = new Ability("Dexterity", 15);
					abilities[i].calculateAbilityMod();
				}
				
				if(i == 3){
					abilities[i] = new Ability("Intelligence", 10);
					abilities[i].calculateAbilityMod();
				}
				
				if(i == 4){
					abilities[i] = new Ability("Wisdom", 12);
					abilities[i].calculateAbilityMod();
				}
				
				if(i == 5){
					abilities[i] = new Ability("Charisma", 8);
					abilities[i].calculateAbilityMod();
				}
					
			}
			
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
					skills[i] = new Skill("Athletics", false, 0);
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
					skills[i] = new Skill("Intimidate", true, 5);
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
	
	public void print_basic_info(){
		System.out.println("Name: " + name);
		System.out.println("Race: " + race);
		System.out.println("Class: " + character_class);
		System.out.println("Level: " + level);
		System.out.println("Age: " + age);
		System.out.println("Height(cm): " + height);
		System.out.println("Weight(kilo): " + weight);
	}
	
	public class Ability{
			private String ability_name;
			int value;
			private int modifier;
			private int lowest_mod = -4;
			private int lowest_value = 2;
			
			public Ability(String name, int val){
				ability_name = name;
				value = val;
			}
			
			public void calculateAbilityMod(){
					int temp = value - lowest_value;
					modifier = lowest_mod + temp/2 + level/2;
			}
			
			public void printAbility(){
				System.out.println(ability_name + ": " + value + " -> " + modifier);
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
				if(trained){
					skill_mod += 5;
				}
				
				skill_mod = skill_mod + abilities[abilityIndex].value + level/2;
			}
			
			public void printSkill(){
				System.out.println(skill_name + ": " + "+" + skill_mod);
			}
	}
	
}
