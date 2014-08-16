
/* Comhghall McKeating
 * Basic player character class
 */

public class PlayerCharacter {
	String name, race, character_class;
	int level, age, height, weight;
	
	public PlayerCharacter(String n, String r, String char_class, int lvl, int a, int h, int w){
			name = n;
			race = r;
			age = a;
			character_class = char_class;
			level = lvl;
			height = h;
			weight = w;
			
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
	
}
