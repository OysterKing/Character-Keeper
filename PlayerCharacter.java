
/* Comhghall McKeating
 * Basic player character class
 */

public class PlayerCharacter {
	String name, race, character_class;
	int level, age, height, weight;
	Ability[] abilities = new Ability[6];
	
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
					abilities[i].calculateMod();
				}
				
				if(i == 1){
					abilities[i] = new Ability("Constitution", 18);
					abilities[i].calculateMod();
				}
				
				if(i == 2){
					abilities[i] = new Ability("Dexterity", 15);
					abilities[i].calculateMod();
				}
				
				if(i == 3){
					abilities[i] = new Ability("Intelligence", 10);
					abilities[i].calculateMod();
				}
				
				if(i == 4){
					abilities[i] = new Ability("Wisdom", 12);
					abilities[i].calculateMod();
				}
				
				if(i == 5){
					abilities[i] = new Ability("Charisma", 8);
					abilities[i].calculateMod();
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
			
			public void calculateMod(){
					int temp = value - lowest_value;
					modifier = lowest_mod + temp/2 + level/2;
			}
			
			public void printAbility(){
				System.out.println(ability_name + ": " + value + " -> " + modifier);
			}
	}
	
}
