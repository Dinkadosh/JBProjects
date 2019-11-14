package school;

import java.util.Random;

public class Teacher extends Person {
	String profession;

	public Teacher(String name, String[] professions) {
		super(name, new Random().nextInt(121 - 20) + 20); // when initialized teacher get random age between 20 - 120
															// years
		this.profession = setProfessionForTeacher(professions); // when initialized teacher automatically get a
																// profession
	}

	public String setProfessionForTeacher(String[] professions) {
		return professions[new Random().nextInt(professions.length)];
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
