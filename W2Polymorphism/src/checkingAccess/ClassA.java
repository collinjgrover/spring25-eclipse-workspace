package checkingAccess;

//ClassA - checking if other classes have access instance variables
// each with different visibility modifiers

public class ClassA {
	public int publicVis;
	protected int protectedVis;
	private int privateVis;
	int packageVis;
	
	public ClassA() {
		publicVis = 11;
		protectedVis = 12;
		privateVis = 13;
		packageVis = 14;
	}
	
	public void checkAccess() {
		System.out.println("Public: " + publicVis);
		System.out.println("Protected: " + protectedVis);
		System.out.println("Private: " + privateVis);
		System.out.println("Package: " + packageVis);
	}
	

}
