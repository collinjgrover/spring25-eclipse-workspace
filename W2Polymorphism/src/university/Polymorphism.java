package university;

public class Polymorphism {

	public static void main(String[] args) {
		Person[] list = new Person[3];

		list[0] = new Person("Col. Mustard", 10);
		list[1] = new Student("Ms. Scarlet", 20, 1998, 3.2);
		list[2] = new Faculty("Prof. Plum", 30, 1981);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].toString());
		}
	}
}