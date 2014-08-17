
public class CharacterTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PlayerCharacter Grell = new PlayerCharacter("Grell", "Human", "Barbarian", 5, 33, 198, 95);
		Grell.print_basic_info();
		Grell.abilities[0].printAbility();
		Grell.abilities[1].printAbility();
		Grell.abilities[2].printAbility();
		Grell.abilities[3].printAbility();
		Grell.abilities[4].printAbility();
		Grell.abilities[5].printAbility();
	}

}
