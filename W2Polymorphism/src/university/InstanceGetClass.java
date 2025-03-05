package university;

public class InstanceGetClass {
	public static void main(String[] args) {
		Person bobp = new Person("Bob", 1);
		Person teds = new Student("Ted", 2, 1990, 4.0);
		Person carolf = new Faculty("Carol", 3, 2016);
	
		if (bobp.getClass() != teds.getClass()) {
			System.out.println("1. Bob and Ted associated with different getClass value");
		}

		if (bobp instanceof Person) {
			System.out.println("2. Bob instance of Person");
		}

		if (teds instanceof Student) {
			System.out.println("3. Ted instance of Student");
		}

		if (teds instanceof Person) {
			System.out.println("4. Ted instance of Person");
		}

		if (!(bobp instanceof Student)) {
			System.out.println("5. Bob is not an instance of Student");
		}

		if (carolf instanceof Person) {
			System.out.println("6. Carol instance of Person");
		}

		if (carolf instanceof Student) {
			System.out.println("7. Carol instance of Student");
		}

		/* Notice we are using Faculty variable rather than Person */
		Faculty drSmithf = new Faculty("DrSmith", 4, 2019);


		/* instanceof operator performs a compile-time check to ensure that the object 
		 * reference and the class name are compatible. If they are not, 
		 * the code will not compile.
		 * - The Following will not compile:
		 * 
		if (drSmithf instanceof Student) {
		   System.out.println("drSmith instance of Student"); 
		}
		*/
		if (drSmithf instanceof Person) {
			   System.out.println("drSmith instance of Person"); 
			}
	}
}
