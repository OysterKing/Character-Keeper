
public class CharacterTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PlayerCharacter Grell = new PlayerCharacter("Grell", "Human", "Barbarian", 5, 33, 198, 95);
		Grell.print_basic_info();
		System.out.println();
		Grell.printAbilityTable();
		System.out.println();
		Grell.printSkillTable();
	}

}
