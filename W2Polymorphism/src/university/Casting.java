package university;

/* This code generates a java.lang.ClassCastException */

public class Casting {
	public static void main(String[] args) {
		Person personRefVariable;
		Person teds = new Student("Ted", 2, 2000, 4.0);
		Student StudentRefVariable;
		GradStudent GradStudentRefVariable;

		// Same type
		personRefVariable = teds;

		// Does not compile as teds may not be a Student; notice we defined teds
		// as a Person variable not a Student
		//
		//StudentRefVariable = teds;

		// Downcasting
		// OK as teds is actually a Student; no run-time error
		StudentRefVariable = (Student) teds;

		// Downcasting
		// run-time error (ClassCastException); ted isn't a graduate student
		GradStudentRefVariable = (GradStudent) teds;
	}
}