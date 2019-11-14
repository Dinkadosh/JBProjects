package school;

import java.util.ArrayList;
import java.util.Random;

public class Mentor extends Person {
	private ArrayList<String> professions;

	public Mentor(String name, String[] professions) {
		super(name, new Random().nextInt(121 - 20) + 20); // when initialized mentor get random age between 20 - 120
															// years
		this.professions = setTwoProfessionForMentor(professions);// when initialized mentor automatically get two different
																	// professions
	}

	public ArrayList<String> setTwoProfessionForMentor(String[] professions) {
		ArrayList<String> twoProfessions = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
			String profession = professions[new Random().nextInt(professions.length)];
			if (twoProfessions.contains(profession)) { // if list already have profession try again
				i--;
				continue;
			}
			twoProfessions.add(profession); // if list not have profession - add it

		}
		return twoProfessions;
	}

	public ArrayList<String> getProfessions() {
		return professions;
	}

	public void setProfessions(ArrayList<String> professions) {
		this.professions = professions;
	}

}
