package university;

import java.util.*;

public class SafeDownCasting {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();

		list.add(new Person("John", 1));
		list.add(new Student("Laura", 20, 2022, 4.0));
		list.add(new Faculty("Dr. Roberts", 30, 1990));

		for (int i = 0; i < list.size(); i++) {
			Person person = list.get(i);
			System.out.print(person.getName());
			if (person instanceof Student) {
				Student student = (Student) person;
				System.out.println(", admission year is " + student.getAdmitYear());
			} else {
				System.out.println();
			}
		}
	}
}
