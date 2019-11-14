package school;

import java.util.ArrayList;
import java.util.Random;

public class ClassRoom {
	private String name;
	private Teacher teacher;
	private ArrayList<Student> students;

	public ClassRoom(String name, Teacher teacher, String[] professions) {
		this.name = name;
		this.teacher = teacher;
		this.students = new ArrayList<Student>();
		addStudentsToTheClassRoom(15, professions); // when initialized class room automatically get 15 students
	}

	public void addStudentsToTheClassRoom(int numbersStudents, String[] professions) {
		for (int i = 0; i < numbersStudents; i++) {
			String nameStudent = "Student" + (i + 1);
			this.students.add(new Student(nameStudent, professions));
		}
	}

	public void addStudentToTheClassRoom(Student student) {
		students.add(student);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public int getAverageScore() {
		int sumScore = 0;

		for (Student student : students) {
			sumScore += student.getAverageScore();
		}

		return sumScore / students.size();
	}

	public int getGradeAverageScore(String nameGrade) {
		int sumScore = 0;
		for (Student student : students) {
			sumScore += student.getGradeScore(nameGrade);
		}
		return sumScore / students.size();
	}

}
