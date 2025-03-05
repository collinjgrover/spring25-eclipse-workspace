package university;

/* Simplified GradStudent class */

public class GradStudent extends Student {
	private String advisor;

	public GradStudent(String name, int id, int admitYear, double gpa, String advisor) {
		super(name, id, admitYear, gpa);
		this.advisor = advisor;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof GradStudent))
			return false;
		GradStudent gradStudent = (GradStudent) obj;

		return super.equals(gradStudent) && advisor.equals(gradStudent.advisor);
	}

	public String toString() {
		return super.toString() + ", advisor: " + advisor;
	}
}
