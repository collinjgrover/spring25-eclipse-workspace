package checkingAccessAway;

import checkingAccess.ClassA;

//Different package as ClassA, is NOT a subclass of ClassA


public class ClassE {
	ClassA a = new ClassA();
	public ClassE() {
		a.publicVis = 51;
		//protectedVis = 52;
		//privateVis = 53;
		//packageVis = 54;
	}
	
	public void checkAccess() {
		System.out.println(a.publicVis);
		//System.out.println(a.protectedVis);
		//System.out.println(a.privateVis);
		//System.out.println(a.packageVis);
	}

}
