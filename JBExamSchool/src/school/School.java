package school;

import java.util.ArrayList;

public class School {
	private ArrayList<ClassRoom> classes;
	private ArrayList<Mentor> mentors;

	public School(String[] professions) {
		this.classes = new ArrayList<ClassRoom>();
		setClasses(5, professions); // when initialized school automatically get 5 class rooms
		this.mentors = new ArrayList<Mentor>();
		setMentors(10, professions); // when initialized school automatically get 10 mentors
	}

	public ArrayList<ClassRoom> getClasses() {
		return classes;
	}

	public ArrayList<Mentor> getMentors() {
		return mentors;
	}

	public void setClasses(int numbersOfClasses, String[] professions) {
		for (int i = 0; i < numbersOfClasses; i++) {
			String nameClass = "Class" + (i + 1);
			String nameTeacher = "Teacher" + (i + 1);
			this.classes.add(new ClassRoom(nameClass, new Teacher(nameTeacher, professions), professions));
		}
	}

	public void addClass(ClassRoom classRoom) {
		classes.add(classRoom);
	}

	public void setMentors(int numbersMentors, String[] professions) {
		for (int i = 0; i < numbersMentors; i++) {
			String nameMentor = "Mentor" + (i + 1);
			mentors.add(new Mentor(nameMentor, professions));
		}
	}

	public void addMethor(Mentor mentor) {
		mentors.add(mentor);
	}

	public int getAveragScore() {
		int sumScore = 0;

		for (ClassRoom classRoom : this.getClasses()) {
			sumScore += classRoom.getAverageScore();
		}

		return sumScore / classes.size();
	}

	public int getAverageScoreByProfession(String nameGrade) {
		int sumScore = 0;
		for (ClassRoom classRoom : classes) {
			sumScore += classRoom.getGradeAverageScore(nameGrade);
		}
		return sumScore / classes.size();
	}

	public int getCountStudentsByAge(int minAge, int maxAge) {
		int countStudents = 0;

		for (ClassRoom classRoom : classes) {
			for (Student student : classRoom.getStudents()) {
				if (student.getAge() >= minAge && student.getAge() <= maxAge) {
					countStudents++;
				}
			}
		}

		return countStudents;
	}

	public int getAverageScoreStudentsByAge(int minAge, int maxAge) {
		int sumScore = 0;

		for (ClassRoom classRoom : classes) {
			for (Student student : classRoom.getStudents()) {
				if (student.getAge() >= minAge && student.getAge() <= maxAge) {
					sumScore += student.getAverageScore();
				}
			}
		}

		return sumScore / getCountStudentsByAge(minAge, maxAge);

	}

	public int getAverageAgeStudents() {
		int sumAge = 0;
		int countStudents = 0;

		for (ClassRoom classRoom : classes) {
			for (Student student : classRoom.getStudents()) {
				sumAge += student.getAge();
				countStudents++;
			}
		}

		return sumAge / countStudents;
	}

	public int getCountTeacherByProfession(String nameProfession) {
		int count = 0;
		for (ClassRoom classRoom : classes) {
			if (classRoom.getTeacher().getProfession().equals(nameProfession)) {
				count++;
			}
		}
		return count;
	}

	public int getCountMentorsByProfessions(String nameProfession1, String nameProfession2) {
		int count = 0;
		for (Mentor mentor : mentors) {
			int countMentor = 0;
			for (String profession : mentor.getProfessions()) {
				if (profession.equals(nameProfession1) || profession.equals(nameProfession2)) {
					countMentor++;
				}
			}
			if (countMentor == 2) {
				count++;
			}
		}
		return count;
	}

	public int getCountStudentsFromTeachers(String nameProfessionTeachers) {
		int count = 0;
		for (ClassRoom classRoom : classes) {
			if (classRoom.getTeacher().getProfession().equals(nameProfessionTeachers)) {
				count += classRoom.getStudents().size();
			}
		}
		return count;
	}

	public void printDreamTeam(String nameGrade) {
		System.out.println("10. Dream team of the School by " + nameGrade + ":");
		int numberPlayer = 1;
		for (ClassRoom classRoom : classes) {
			for (Student student : classRoom.getStudents()) {
				if (student.getGradeScore(nameGrade) > 90) {
					System.out.println("Player " + numberPlayer + " is " + student.getName() + " from the class "
							+ classRoom.getName() + " with score " + student.getGradeScore(nameGrade));
					numberPlayer++;
				}
			}
		}
	}
}
