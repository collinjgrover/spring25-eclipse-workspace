package checkingAccess;

//Same package as ClassA, but not a subclass of ClassA

public class ClassB {
	ClassA a = new ClassA();
	public ClassB() {
		a.publicVis = 21;
		a.protectedVis = 22;
		//a.privateVis = 23;
		a.packageVis = 24;
	}
	
	public void checkAccess() {
		System.out.println(a.publicVis);
		System.out.println(a.protectedVis);
		//System.out.println(a.privateVis);
		System.out.println(a.packageVis);
	}

}
