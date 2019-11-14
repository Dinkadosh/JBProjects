package school;

import java.util.Arrays;
import java.util.Random;

public class Student extends Person {
	private Grade[] grades;

	public Student(String name, String[] professions) {
		super(name, new Random().nextInt(121 - 20) + 20); // when initialized student get random age between 20 - 120
															// years
		grades = new Grade[professions.length];
		setGradesForStudent(professions); // when initialized student get grades and their random score
	}

	public void setGradesForStudent(String[] professions) {
		for (int i = 0; i < professions.length; i++) {
			int randomScore = new Random().nextInt(101 - 40) + 40;
			this.grades[i] = new Grade(professions[i], randomScore);
		}
	}

	public Grade[] getGrades() {
		return grades;
	}

	public int getAverageScore() {
		int sumScore = 0;
		for (Grade grade : grades) {
			sumScore += grade.getScore();
		}
		return sumScore / 6;
	}

	public int getGradeScore(String nameGrade) {
		for (Grade grade : grades) {
			if (grade.getProfession() == nameGrade) {
				return grade.getScore();
			}
		}
		return 0;
	}

	// for test
	@Override
	public String toString() {
		return this.getName() + " score: " +
				grades[0].getProfession() + " : " + grades[0].getScore() + ", " + 
				grades[1].getProfession() + " : " + grades[1].getScore() + ", " + 
				grades[2].getProfession() + " : " + grades[2].getScore() + ", " + 
				grades[3].getProfession() + " : " + grades[3].getScore() + ", " + 
				grades[4].getProfession() + " : " + grades[4].getScore() + ", " + 
				grades[5].getProfession() + " : " + grades[5].getScore() + ", ";
	}
	
	
}
