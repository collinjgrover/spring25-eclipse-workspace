package university;

public class Faculty extends Person {
	private int hireYear; /* year when hired */

	public Faculty(String name, int id, int hireYear) {
		super(name, id);
		this.hireYear = hireYear;
	}

	public Faculty() {
		super();
		hireYear = -1;
	}

	public Faculty(Faculty faculty) {
		/* Why are we using get methods for the first two? */
		this(faculty.getName(), faculty.getId(), faculty.hireYear);
	}

	int getHireYear() {
		return hireYear;
	}

	void setHireYear(int year) {
		hireYear = year;
	}

	public String toString() {
		return super.toString() + " " + hireYear;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Faculty))
			return false;
		Faculty faculty = (Faculty) obj;

		/* Relying on Person equals; passing student */
		return super.equals(faculty) && hireYear == faculty.hireYear;
	}

	public static void main(String[] args) {
		Faculty jin = new Faculty("Jin", 20, 2022);
		Faculty jack = new Faculty(jin);
		Faculty maria = new Faculty("Maria", 101, 2010);

		System.out.println(maria);
		System.out.println("Same:" + jin.equals(jack));
		System.out.println("Same:" + jack.equals(maria));

		System.out.println("Id: " + jin.getId());
		System.out.println("HireYear: " + jin.getHireYear());
	}
}
