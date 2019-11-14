package school;


public class SchoolStatistics {

	public static void main(String[] args) {
		String[] professions = { "math", "chemistry", "geography", "literature", "physics", "sports" };

		School mySchool = new School(professions); 

		System.out.println("1. Average score in the School is: " + mySchool.getAveragScore());

		for (ClassRoom classRoom : mySchool.getClasses()) {
			System.out.println("2. Average score in the " + classRoom.getName() + " is " + classRoom.getAverageScore());
		}
		
		for (String string : professions) {
			System.out.println("3. Average score in the school by grade " + string + " is "
					+ mySchool.getAverageScoreByProfession(string));
		}

		System.out.print("4. Count students by age between 20 - 30 years old is " + mySchool.getCountStudentsByAge(20, 30));
		System.out.println(", and their average score is " + mySchool.getAverageScoreStudentsByAge(20, 30));

		System.out.print("5. Count students by age more then 30 years old is " + mySchool.getCountStudentsByAge(31, 120));
		System.out.println(", and their average score is " + mySchool.getAverageScoreStudentsByAge(31, 120));

		System.out.println("6. Average age of students in the School is " + mySchool.getAverageAgeStudents() + " years old");

		for (String string : professions) {
			System.out.println("7. Count " + string + " teachers is " + mySchool.getCountTeacherByProfession(string));
		}

		/*
		 * for (Mentor mentor : mySchool.getMentors()) {
		 * System.out.println(mentor.getProfessions()); }
		 */ // for test

		System.out.println("8. Count mentors with math and physics professions is "
				+ mySchool.getCountMentorsByProfessions("math", "physics"));

		/*
		 * for (ClassRoom classRoom : mySchool.getClasses()) {
		 * System.out.println(classRoom.getTeacher().getProfession()); }
		 */ // for test

		System.out.println("9. Count teachers sports is " + mySchool.getCountTeacherByProfession("sports")
				+ ", count of their students is " + mySchool.getCountStudentsFromTeachers("sports"));

		mySchool.printDreamTeam("sports");
		
		
	}

}
