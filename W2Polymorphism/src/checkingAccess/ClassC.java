package checkingAccess;

//Same package as ClassA, is a subclass of ClassA

public class ClassC extends ClassA {
	public ClassC() {
		publicVis = 31;
		protectedVis = 32;
		//privateVis = 33;
		packageVis = 34;
	}
	
	public void checkAccess() {
		System.out.println(publicVis);
		System.out.println(protectedVis);
		//System.out.println(privateVis);
		System.out.println(packageVis);
	}

}
