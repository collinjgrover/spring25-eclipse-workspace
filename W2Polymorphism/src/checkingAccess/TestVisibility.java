package checkingAccess;

import checkingAccessAway.ClassD;
import checkingAccessAway.ClassE;

public class TestVisibility {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		System.out.println("Testing ClassA: ");
		a.checkAccess();
		
		ClassB b = new ClassB();
		System.out.println("\nTesting ClassB: ");
		b.checkAccess();
		
		ClassC c = new ClassC();
		System.out.println("\nTesting ClassC: ");
		c.checkAccess();
		
		ClassD d = new ClassD();
		System.out.println("\nTesting ClassD: ");
		d.checkAccess();
		
		ClassE e = new ClassE();
		System.out.println("\nTesting ClassE: ");
		e.checkAccess();

	}

}
